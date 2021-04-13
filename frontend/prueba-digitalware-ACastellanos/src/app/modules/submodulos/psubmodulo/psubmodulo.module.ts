import {NgModule} from '@angular/core';

import {PsubmoduloRoutingModule} from './psubmodulo-routing.module';
import {PasajerosComponent} from './pasajeros/pasajeros.component';
import {SharedModule} from '../../../SharedModule';
import {DialogConfElimComponent} from './pasajeros/diagconfelim.component';
import {DialogcreatpasajerosComponent} from './pasajeros/diagcreatpasajeros.component';
import {DialogMessagesComponent} from './pasajeros/diagmessages.component';


@NgModule({
  imports: [
    PsubmoduloRoutingModule,
    SharedModule
  ],
  declarations: [
    PasajerosComponent,
    DialogMessagesComponent,
    DialogConfElimComponent,
    DialogcreatpasajerosComponent

  ],
  entryComponents: [
    DialogcreatpasajerosComponent
  ]
})
export class PsubmoduloModule {
}
