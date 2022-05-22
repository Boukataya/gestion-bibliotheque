import {Component, ElementRef, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard-layout',
  templateUrl: './dashboard-layout.component.html',
  styleUrls: ['./dashboard-layout.component.css']
})
export class DashboardLayoutComponent implements OnInit {
  username: string;
  roles: string;

  constructor(
    private elementRef: ElementRef,
    public authService: AuthService,
    private router: Router) {
  }


  ngOnInit() {
    this.username = localStorage.getItem('username');
    this.roles = localStorage.getItem('roles');
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
    this.authService.doLogout();
  }

}
