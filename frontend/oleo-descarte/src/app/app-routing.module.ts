import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './components/cadastro/cadastro.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'cadastro',
    component: CadastroComponent,
    pathMatch: 'full'
  },
/*   {
    path: 'listarDoadores',
    component: ListarDoadoresComponent
  },
  {
    path: 'perfil',
    component: PerfilComponent
  } */

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
