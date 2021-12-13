import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../modelo/login';
import { ResponseGenerico } from '../modelo/responseGenerico';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  titulo:string="Login";

  login:Login = new Login();
  respGenerico:ResponseGenerico = new ResponseGenerico();
  cod:string;
  constructor(private loginService:LoginService, private router:Router) { }
  ngOnInit(): void {

  }

  loggear(){

    this.loginService.loggeo(this.login).subscribe(
     data =>{
      this.respGenerico.cod=data.cod
      this.respGenerico.desc=data.desc
      if(this.respGenerico.cod=="01"){
        sessionStorage.setItem('login',this.login.usuario);
       this.router.navigate(['/tareas']);
      }else{
        alert(this.respGenerico.desc);
      }

     }
   );
 }

}
