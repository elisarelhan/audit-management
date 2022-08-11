import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { throwError, Subject, BehaviorSubject } from 'rxjs';

import { User } from './user.model';
import { NonNullAssert } from '@angular/compiler';
import { Router } from '@angular/router';

export interface AuthResponseData {
token: string;
  expiresIn: string;

}

@Injectable({ providedIn: 'root' })
export class AuthService {
  user = new BehaviorSubject<User>(null!);
  private tokenExpirationTimer: any;
  
  

  constructor(private http: HttpClient,
    private router:Router) {}

  signup(username: string, password: string) {
    return this.http
      .post<AuthResponseData>(
        'http://localhost:8000/register',
        {
          username: username,
          password: password,
          
        }
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          this.handleAuthentication(
           
            resData.token,
            +resData.expiresIn
          );
          
        })
      );
  }

  login(username: string, password: string) {
    return this.http
      .post<AuthResponseData>(
        'http://localhost:8000/authenticate',
        {
          username: username,
          password: password,
          
        }
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          this.handleAuthentication(
            
            resData.token,
            +resData.expiresIn
          );
          
        })
      );
  }
  autoLogin() {
    const userData: {
      _token: string;
      _tokenExpirationDate: string;
    } = JSON.parse(localStorage.getItem('userData')||'{}');
    if (!userData) {
      return;
    }

    const loadedUser = new User(
      
      userData._token,
      new Date(userData._tokenExpirationDate)
    );

    if (loadedUser.token) {
      this.user.next(loadedUser);
      const expirationDuration =
        new Date(userData._tokenExpirationDate).getTime() -
        new Date().getTime();
      this.autoLogout(expirationDuration);
      
    }
  }

  logout() {
    this.user.next(null!);
    this.router.navigate(['login']);
    localStorage.removeItem('userData');
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;
  }

  autoLogout(expirationDuration: number) {
    this.tokenExpirationTimer = setTimeout(() => {
      this.logout();
    }, expirationDuration);
    console.log(expirationDuration);
  }
  private handleAuthentication(
  
    token: string,
    expiresIn: number
  ) {
    const expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
    const user = new User( token, expirationDate);
    this.user.next(user);
    this.autoLogout(expiresIn * 1000);
    localStorage.setItem('userData', JSON.stringify(user));
  }

  private handleError(errorRes: HttpErrorResponse) {
    let errorMessage='';
   
  //   if(errorRes.error==="INVALID_CREDENTIALS"){
  //     errorMessage= "Invalid Credentials";
  //   }
  //   else{
  //   errorMessage = 'An unknown error occurred!';
  // }
  //   if (!errorRes.error || !errorRes.error.error) {
  //     return throwError(errorMessage);
  //   }
    switch (errorRes.error) {
      case 'INVALID_CREDENTIALS':
        errorMessage = 'Invalid Credentials';
        break;
      case 'User not found with username:':
        errorMessage = 'User does not exist';
        break;
      case 'Username already exists.':
        errorMessage = 'Username already exists';
        break;
      default:
        errorMessage = 'An unknown error occurred!';
        break;
    }
    return throwError(errorMessage);
  }
}
