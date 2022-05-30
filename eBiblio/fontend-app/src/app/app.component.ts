import { Component } from '@angular/core';
import {AuthenticationService} from "./_services/authentication.service";
import {User} from "./_models/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user: User;

  constructor(private authenticationService: AuthenticationService) {
    this.authenticationService.user.subscribe(x => this.user = x);
  }

  get isAdmin() {
    return this.user && this.user.roles === ['ADMIN'];
  }

  logout() {
    this.authenticationService.logout();
  }
}
