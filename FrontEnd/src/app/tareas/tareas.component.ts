import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObtenerTarea } from 'src/app/modelo/obtenerTarea';
import { TareaService } from 'src/app/service/tarea.service';
import { ActualizarTarea } from '../modelo/actualizarTarea';
import { EliminarTarea } from '../modelo/eliminarTarea';
import { ResponseGenerico } from '../modelo/responseGenerico';


@Component({
  selector: 'app-tareas',
  templateUrl: './tareas.component.html',
  styleUrls: ['./tareas.component.css']
})
export class TareasComponent implements OnInit {

  titulo:string="Usuarios";

  respTareaUsurio:any;
  obtenerTarea:ObtenerTarea = new ObtenerTarea();
  eliTarea:EliminarTarea = new EliminarTarea();
  acttarea:ActualizarTarea = new ActualizarTarea();
  respGenerico: ResponseGenerico = new ResponseGenerico();
  user: any;
  cod:string;
  nombreUsuario:any;
  nombreT:string
  constructor(private tareaService:TareaService, private router:Router) { }
  ngOnInit(): void {
    this.user = sessionStorage.getItem('login');
    this.obtenerTareaUsuario();
    // sessionStorage.removeItem('login');
  }

  obtenerTareaUsuario(){
    this.obtenerTarea.usuario = this.user
    this.tareaService.obtenerTareaUsuario(this.obtenerTarea).subscribe(
     data =>{
      console.log(data)
        this.respTareaUsurio = data;
        this.nombreUsuario = data.idUsuario;
         console.log(this.respTareaUsurio)
     }
   );
 }

 eliminarTarea(nombreT: string){
  this.eliTarea.nombreTarea = nombreT;
  this.tareaService.eliminarTarea(this.eliTarea).subscribe(
   data => this.obtenerTareaUsuario()
 );
}

actualizarTarea(nombreT: string){
  sessionStorage.setItem('tarea',nombreT);
  this.router.navigate(['/actualizarTarea'])
}

}
