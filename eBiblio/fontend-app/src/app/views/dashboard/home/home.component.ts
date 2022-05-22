import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../shared/services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(
    public authService: AuthService,
    private actRoute: ActivatedRoute,
    private router: Router
  ) {

  }

  logout() {
    this.authService.doLogout();
    this.router.navigate(['/']).then(r => {
      console.log(r);
    }).catch(e => {
      console.log(e);
    });

  }

  ngOnInit() {
  }



}
