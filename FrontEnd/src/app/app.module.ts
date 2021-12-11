import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";
import {Routes, RouterModule} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { HomeComponent } from './home/home.component';
import { TareasComponent } from './tareas/tareas/tareas.component';

const routes:Routes = [
  {path: '',redirectTo:'/login',pathMatch:'full'},
  {path: 'login', component: UsuariosComponent},
  {path: 'home', component:HomeComponent},
  {path: 'tareas', component:TareasComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    UsuariosComponent,
    HomeComponent,
    TareasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
