import {Component, ElementRef, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../../_services/authentication.service";
import {User} from "../../../_models/user";

@Component({
  selector: 'app-dashboard-layout',
  templateUrl: './dashboard-layout.component.html',
  styleUrls: ['./dashboard-layout.component.css']
})
export class DashboardLayoutComponent implements OnInit {
  username: string;
  roles: string;
  user: User = this.authenticationService.userValue;

  constructor(
    private elementRef: ElementRef,
    private authenticationService: AuthenticationService,
    private router: Router) {
  }


  ngOnInit() {

  }

  toggleSidebar() {
    const sidebar = (<HTMLElement>this.elementRef.nativeElement).querySelector('.sidebar');
    sidebar.classList.toggle("open");
    this.menuBtnChange();

  }

  menuBtnChange() {
    const closeBtn = (<HTMLElement>this.elementRef.nativeElement).querySelector('#btn');
    const sidebar = (<HTMLElement>this.elementRef.nativeElement).querySelector('.sidebar');
    if (sidebar.classList.contains("open")) {
      closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
    } else {
      closeBtn.classList.replace("bx-menu-alt-right", "bx-menu");//replacing the iocns class
    }
  }


  logout() {
    console.log("logout");
    this.authenticationService.logout();
    this.router.navigate(['/']);
  }
}
