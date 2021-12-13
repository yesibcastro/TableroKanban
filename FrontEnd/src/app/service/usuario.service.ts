import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Usuario } from '../modelo/usuario';
import { ResponseGenerico} from '../modelo/responseGenerico';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url:string="http://localhost:8080/api/create";
  constructor(private http:HttpClient) {}

    //obtengo validacion del login
    creacionUsuario(usuario:Usuario):Observable<ResponseGenerico> {
      return this.http.post<ResponseGenerico>(this.url, usuario);
  }
}

