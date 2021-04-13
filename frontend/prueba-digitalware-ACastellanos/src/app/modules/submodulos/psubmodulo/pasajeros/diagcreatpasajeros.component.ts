import {Component, Inject,  OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DialogMessagesComponent} from './diagmessages.component';
import {PasajerosModel} from '../models/pasajeros.model';
import {PasajerosService} from '../services/pasajeros.service';
import {AppCargandoService} from '../../../../appBase/cargando/app.cargando.service';
import {CreatePasajeroResponse} from '../responses/listResponses';


@Component({
  selector: 'app-diagcreatdependencsp-component',
  templateUrl: 'diagcreatpasajeroscomponent.html'
})
export class DialogcreatpasajerosComponent implements OnInit {
  PasajeroForm: FormGroup;
  dataAdEd: Array<PasajerosModel>;
  selectedPasajero: PasajerosModel;
  PasajeroSubmited: boolean;
  constructor(
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<DialogcreatpasajerosComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private builder: FormBuilder,
    private PasajeroService: PasajerosService, private cargServ: AppCargandoService) {
    if (data.dataed === null) {
      this.selectedPasajero = new PasajerosModel(null);
    } else {
      this.selectedPasajero = new PasajerosModel(data.dataed);
    }

  }

  public Close(resultad: boolean): void {
    let resultado: any;

    if (resultad === true) {
      resultado = {result: resultad, dataAdEd: this.dataAdEd};
    } else {
      resultado = {result: resultad, dataAdEd: null};
    }
    this.dialogRef.close(resultado);
  }

  onSubmitCrear(): void {
    this.PasajeroSubmited = true;
    if (this.PasajeroForm.invalid) {
      return;
    }
    const PasajerosModelEnv = new PasajerosModel(this.PasajeroForm.value);
    this.cargServ.iniciarCargando();
    if (this.data.dataed === null) {
      this.PasajeroService.crearPasajero(PasajerosModelEnv).subscribe((res: Response) => {
        const response: CreatePasajeroResponse = res as any;
        this.cargServ.detenCargando();

        if (response.responseCode === 1) {
          this.dataAdEd = response.pasajeros;
          this.Close(true);
        } else {
          this.dialog.open(DialogMessagesComponent, {
            minWidth: '320px',
            maxWidth: '632px',
            data: {message: response.responseDescription + ' 😅'}
          });
          this.Close(false);
        }
      });
    } else  {
      this.PasajeroService.editarPasajero(PasajerosModelEnv).subscribe((res: Response) => {
        const response: CreatePasajeroResponse = res as any;
        this.cargServ.detenCargando();
        if (response.responseCode === 1) {
          this.dataAdEd = response.pasajeros;
          this.Close(true);
        } else {
          this.dialog.open(DialogMessagesComponent, {
            minWidth: '320px',
            maxWidth: '632px',
            data: {message: response.responseDescription + ' 😅'}
          });
          this.Close(false);
        }
      });
    }

  }


  iniciarForm(): void {
    this.PasajeroForm = this.builder.group({
      id: [this.selectedPasajero.id, []],
      tipdocumento: [this.selectedPasajero.tipdocumento, [Validators.required]],
      identificacion: [this.selectedPasajero.identificacion, [Validators.required,  Validators.maxLength(10)]],
      pnombre: [this.selectedPasajero.pnombre, [Validators.required,  Validators.maxLength(80)]],
      snombre: [this.selectedPasajero.snombre, [Validators.required, Validators.maxLength(80)]],
      papellido: [this.selectedPasajero.papellido, [Validators.required,  Validators.maxLength(80)]],
      sapellido: [this.selectedPasajero.sapellido, [Validators.required,  Validators.maxLength(80)]],
      email: [this.selectedPasajero.email, [Validators.required, Validators.email, Validators.maxLength(200)]],
      ncelular: [this.selectedPasajero.ncelular, [Validators.required,  Validators.maxLength(10)]],
    });
  }

  ngOnInit(): void {
    this.iniciarForm();
  }


}

