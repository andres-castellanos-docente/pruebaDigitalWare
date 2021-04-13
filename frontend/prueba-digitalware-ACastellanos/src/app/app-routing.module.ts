import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppprincComponent} from './appBase/princ/appprinc.component';
import {BlankComponent} from './formas/blank';
import {LoginComponent} from './formas/login';
import { LoginGuard} from './guards';

const routes: Routes = [
  {

    path: '', component: AppprincComponent,
    children: [
      {path: 'inicio', component: BlankComponent, canActivate: [LoginGuard]},
      {
        path: 'modulos',
        loadChildren: () => import('./modules/modulosext.module').then(mod => mod.ModulosextModule)
      },
      {path: '', redirectTo: 'inicio', pathMatch: 'full'}], canActivate: [LoginGuard]
  },
  {path: '', redirectTo: 'login', pathMatch: 'prefix'},
  {path: 'login', component: LoginComponent, canActivate: []},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
