import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponseGenerico } from '../modelo/responseGenerico';
import { Usuario } from '../modelo/usuario';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  titulo:string="Usuarios";

  respGenerico:ResponseGenerico = new ResponseGenerico();
  usuario:Usuario = new Usuario();
  cod:string;
  constructor(private usuarioService:UsuarioService, private router:Router) { }
  ngOnInit(): void {

  }

  crearUsuario(){

    this.usuarioService.creacionUsuario(this.usuario).subscribe(
     data =>{
      this.respGenerico.cod=data.cod
      this.respGenerico.desc=data.desc
      if(this.respGenerico.cod=="01"){
       this.router.navigate(['/login']);
      }else{
        alert(this.respGenerico.desc);
      }

     }
   );
 }
}
