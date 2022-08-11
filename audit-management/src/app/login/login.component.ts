import { style } from '@angular/animations';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { AuthService, AuthResponseData } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 
  isLoginMode = true;
  isLoading = false;
  error='';
  usernameArray='';
  
 

  constructor(private authService: AuthService,
    private router: Router) {}


  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }
  

  onSubmit(form: NgForm) {
    if (!form.valid) {
      return;
    }
    const username = form.value.username;
    const password = form.value.password;

    let authObs: Observable<AuthResponseData>;

    this.isLoading = true;

    if (this.isLoginMode) {
      authObs = this.authService.login(username, password);
   
    
    } else {
      authObs = this.authService.signup(username, password);
    }

    authObs.subscribe(
      resData => {
        console.log(resData);
        this.isLoading = false;
        this.router.navigate(['request']);
      },
      errorMessage => {
        console.log(errorMessage);
        this.error = errorMessage;
        this.isLoading = false;
        
      }
    );

    form.reset();
    // if(idLogin)
    // this.router.navigate(['request']);
  }
}
