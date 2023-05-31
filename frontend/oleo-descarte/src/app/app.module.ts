import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { CadastroComponent } from './components/cadastro/cadastro.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { ListarDoadoresComponent } from './components/listar-doadores/listar-doadores.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    CadastroComponent,
    PerfilComponent,
    ListarDoadoresComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
