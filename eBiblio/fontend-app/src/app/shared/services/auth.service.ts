import {Injectable} from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {HttpClient, HttpErrorResponse, HttpHeaders,} from '@angular/common/http';
import {Router} from '@angular/router';
import {environment} from "../../../environments/environment";
import {UserModule} from "../models/user.module";

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  endpoint: string = environment.baseURl;
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  currentUser!: UserModule;

  constructor(private http: HttpClient, public router: Router) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.currentUser);
  }

  // Sign-up
  signUp(user: UserModule): Observable<any> {
    let api = `${this.endpoint}/admin/create`;
    return this.http.post(api, user).pipe(catchError(this.handleError));
  }

  // Sign-in
  signIn(user: UserModule) {
    return this.http
      .post<any>(`${this.endpoint}/auth/signin`, user)
      .subscribe((data: any) => {
        localStorage.setItem('jwttoken', data.jwttoken);
        localStorage.setItem('currentUser', data);
        this.currentUser = data;
        this.router.navigate(['dashboard']).then(r => {
          console.log(r);
        });
      });
  }

  getToken() {
    return localStorage.getItem('jwttoken');
  }

  get isLoggedIn(): boolean {
    let authToken = localStorage.getItem('jwttoken');
    return authToken !== null;
  }

  doLogout() {
    localStorage.removeItem('jwttoken');
    if (localStorage.getItem("jwttoken") == null) {
      this.router.navigate(['/']).then(r => {
        console.log(r);
      });
    }
  }


  // Error
  handleError(error: HttpErrorResponse) {
    let msg: string;
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
  }
}
