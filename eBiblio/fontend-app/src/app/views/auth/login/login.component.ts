import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../../../shared/services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
  ) {
  }

  ngOnInit()
    :
    void {
    this.loginForm = this.formBuilder.group({
      username: 'youness',
      password: '123456'
    });
  }

  onSubmit(): void {
    this.authService.signIn(this.loginForm.value);

  }

}
