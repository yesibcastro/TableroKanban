import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActualizarTarea } from '../modelo/actualizarTarea';
import { ResponseGenerico } from '../modelo/responseGenerico';
import { TareaService } from '../service/tarea.service';

@Component({
  selector: 'app-actualizar-tarea',
  templateUrl: './actualizar-tarea.component.html',
  styleUrls: ['./actualizar-tarea.component.css']
})
export class ActualizarTareaComponent implements OnInit {

  titulo:string="Tareas";

  respGenerico:ResponseGenerico = new ResponseGenerico();
  acttarea:ActualizarTarea = new ActualizarTarea();
  tarea:any;
  constructor(private tareaService:TareaService, private router:Router) { }
  ngOnInit(): void {
    this.tarea = sessionStorage.getItem('tarea');
  }

  actualizarTarea(){

    this.acttarea.nombreTarea = this.tarea;
    this.tareaService.actualizarTarea(this.acttarea).subscribe(
     data =>{
      this.respGenerico.cod=data.cod
      this.respGenerico.desc=data.desc
      if(this.respGenerico.cod=="01"){
       this.router.navigate(['/tareas']);
       sessionStorage.removeItem('tarea')
      }else{
        alert(this.respGenerico.desc);
      }
     }
   );
 }
}
