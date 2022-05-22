import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthService} from "../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class HasRoleGuard implements CanActivate {

  constructor(private authService: AuthService) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    console.log("User Role is = " + route.data['role'])
    console.log(this.authService.currentUser);
    const isAuthorized = this.authService.currentUser.roles.includes(route.data['role']);
    if (!isAuthorized) {
      console.log("User is not authorized")
      return false;
    }
    return isAuthorized;
  }

}
