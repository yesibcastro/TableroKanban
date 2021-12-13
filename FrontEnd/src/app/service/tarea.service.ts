import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { ObtenerTarea } from '../modelo/obtenerTarea';
import { ResponseGenerico} from '../modelo/responseGenerico';
import { ResponseObtenerTarea } from '../modelo/responseObtenerTarea';
import { CrearTarea } from '../modelo/crearTarea';
import { EliminarTarea } from '../modelo/eliminarTarea';
import { ActualizarTarea } from '../modelo/actualizarTarea';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  private url:string="http://localhost:8081/tarea/";
  constructor(private http:HttpClient) {}

    //obtengo validacion del login
    obtenerTareaUsuario(tareaUsuario:ObtenerTarea):Observable<ResponseObtenerTarea> {
      return this.http.post<ResponseObtenerTarea>(this.url + 'obtenerTareasUsuarios', tareaUsuario);
  }

crearTarea(crearTarea:CrearTarea):Observable<ResponseGenerico> {
    return this.http.post<ResponseGenerico>(this.url + 'create', crearTarea);
}

actualizarTarea(actualizarTarea:ActualizarTarea):Observable<ResponseGenerico> {
  return this.http.post<ResponseGenerico>(this.url + 'update', actualizarTarea);
}
eliminarTarea(eliminarTarea:EliminarTarea):Observable<ResponseGenerico> {
  return this.http.post<ResponseGenerico>(this.url + 'delete', eliminarTarea);
}



}
