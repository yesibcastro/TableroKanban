import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Login } from '../modelo/login';
import { ResponseLogin } from '../modelo/responseLogin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url:string="http://localhost:8080/api/login";
  constructor(private http:HttpClient) {}

    //obtengo validacion del login
    loggeo(login:Login):Observable<ResponseLogin> {
      return this.http.post<ResponseLogin>(this.url, login);
  }
}

