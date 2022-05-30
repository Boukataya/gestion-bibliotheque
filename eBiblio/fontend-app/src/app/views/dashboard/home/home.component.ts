import {Component, OnInit} from '@angular/core';
import {MessageService} from "primeng/api";
import {AuthenticationService} from "../../../_services/authentication.service";
import {User} from "../../../_models/user";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [MessageService]

})
export class HomeComponent implements OnInit {
  user: User = this.authenticationService.userValue;

  constructor(
    private authenticationService: AuthenticationService,
    private messageService: MessageService) {

  }


  ngOnInit() {
    setTimeout(() => {
      this.messageService.add({
        key: 'df',
        severity: 'info',
        summary: 'Info',
        detail: 'Welcome ' + this.user.username.toUpperCase(),
        life: 5000
      });
    }, 1000);
  }


}
