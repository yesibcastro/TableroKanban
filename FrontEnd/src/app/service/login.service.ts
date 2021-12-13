import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Login } from '../modelo/login';
import { ResponseGenerico } from '../modelo/responseGenerico';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url:string="http://localhost:8080/api/login";
  constructor(private http:HttpClient) {}

    //obtengo validacion del login
    loggeo(login:Login):Observable<ResponseGenerico> {
      return this.http.post<ResponseGenerico>(this.url, login);
  }
}

