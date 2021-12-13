import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrearTarea } from '../modelo/crearTarea';
import { ResponseGenerico } from '../modelo/responseGenerico';
import { TareaService } from '../service/tarea.service';

@Component({
  selector: 'app-crear-tarea',
  templateUrl: './crear-tarea.component.html',
  styleUrls: ['./crear-tarea.component.css']
})
export class CrearTareaComponent implements OnInit {

  titulo:string="Tareas";
  user: any;

  respGenerico:ResponseGenerico = new ResponseGenerico();
  tarea:CrearTarea = new CrearTarea();
  cod:string;
  constructor(private tareaService:TareaService, private router:Router) { }
  ngOnInit(): void {
    this.user = sessionStorage.getItem('login');
  }

  crearTarea(){
    this.tarea.usuario = this.user
    this.tareaService.crearTarea(this.tarea).subscribe(
     data =>{
      this.respGenerico.cod=data.cod
      this.respGenerico.desc=data.desc
      if(this.respGenerico.cod=="01"){
       this.router.navigate(['/tareas']);
      }else{
        alert(this.respGenerico.desc);
      }
     }
   );
 }
}
