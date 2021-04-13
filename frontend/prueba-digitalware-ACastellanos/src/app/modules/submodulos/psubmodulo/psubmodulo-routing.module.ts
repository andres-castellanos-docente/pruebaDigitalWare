import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PasajerosComponent} from './pasajeros/pasajeros.component';


const routes: Routes = [
    {
        path: '',
        children: [
            { path: 'pasajeros', component: PasajerosComponent },
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PsubmoduloRoutingModule { }
