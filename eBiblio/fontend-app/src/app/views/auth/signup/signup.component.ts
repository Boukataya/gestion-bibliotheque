import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      firstname: 'James',
      lastname: 'Spader',
      email: 'james.spader@gmail.com',
      password: '123456'
    });
  }

  onSubmit() {
    console.log(this.signupForm.value);
  }
}
