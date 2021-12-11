import { Component, OnInit } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { Login } from '../modelo/login';
import { ResponseLogin } from '../modelo/responseLogin';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  titulo:string="Lista de Usuarios";

  login:Login = new Login();
  respLogin:ResponseLogin = new ResponseLogin();
  cod:string;
  constructor(private loginService:LoginService, private router:Router) { }
  ngOnInit(): void {

  }

  loggear(){

     this.loginService.loggeo(this.login).subscribe(
      data =>{
       this.respLogin.cod=data.cod
       this.respLogin.desc=data.desc
       if(this.respLogin.cod=="01"){
        this.router.navigate(['/tareas']);
       }else{
        this.router.navigate(['/home']);
       }

      }
    );
  }

}
