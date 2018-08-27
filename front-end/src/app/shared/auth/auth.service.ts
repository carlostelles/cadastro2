import {Injectable} from '@angular/core';

@Injectable()
export class AuthService {
  private token: string;

  constructor() {
  }

  signinUser() {
    this.token = '1';
    localStorage.setItem('token', this.token);
    return true;
  }

  logout() {
    localStorage.removeItem('token');
  }

  getToken() {
    this.token = localStorage.getItem('token');
    return this.token;
  }

  isAuthenticated() {
    return this.getToken();
  }
}
