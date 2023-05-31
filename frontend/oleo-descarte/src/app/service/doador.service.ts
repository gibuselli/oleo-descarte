import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Doador } from '../domain/doador';

@Injectable({
  providedIn: 'root'
})
export class DoadorService {

  private readonly API: string;

  constructor(private http: HttpClient) {
    this.API = 'http://localhost:8080/';
  }

  public save(doador: Doador) {
    return this.http.post<Doador>(this.API, doador)
  }
}
