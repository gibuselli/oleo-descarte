import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private authToken!: string | null;

  constructor(private http: HttpClient, private router: Router) { }

  login(email: string, password: string) {
    this.http.post<any>('api/auth/login', { email, password }).subscribe(
      response => {
        this.authToken = response.token;
      },
      error => {
        return throwError(error);
      }
    );
  }

  logout() {
    this.authToken = null;
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return !!this.authToken;
  }

  getAuthToken(): any {
    return this.authToken;
  }
}
