import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes = [
    {
        path: 'psubmodulo',
        loadChildren: () => import('./submodulos/psubmodulo/psubmodulo.module').then(mod => mod.PsubmoduloModule)
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ModulosextRoutingModule {
}
