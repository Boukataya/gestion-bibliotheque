import {Injectable} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable, throwError} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {Document} from "../models/document";

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  endpoint: string = environment.baseURl;
  headers = new HttpHeaders().set('Content-Type', 'application/json');

  // allDocuments: Document[];

  constructor(private http: HttpClient, public router: Router) {
  }

  // Sign-up
  getAllDocument(): Observable<Document[]> {
    let api = `${this.endpoint}/documents/all`;
    return this.http.get<Document[]>(api, {headers: this.headers}).pipe(
      map(data => {
        return data;
      }),
      catchError(this.handleError)
    );
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
