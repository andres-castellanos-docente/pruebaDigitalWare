import {Component, Injectable, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatDialog} from '@angular/material/dialog';
import {DialogMessagesComponent} from './diagmessages.component';
import {DialogConfElimComponent} from './diagconfelim.component';
import {AppCargandoService} from '../../../../appBase/cargando/app.cargando.service';
import {subirAnimation} from '../../../../animations/listanim.animations';
import {PasajerosService} from '../services/pasajeros.service';
import {PasajerosModel} from '../models/pasajeros.model';
import {DialogcreatpasajerosComponent} from './diagcreatpasajeros.component';

@Component({
  templateUrl: './pasajeros.component.html',
  styleUrls: ['./pasajeros.component.scss'],
  animations: [subirAnimation]
})

@Injectable()
export class PasajerosComponent implements OnInit {

  constructor(private pasajerosService: PasajerosService, private cargServ: AppCargandoService, public dialog: MatDialog) {
  }

  dataPasajeros: PasajerosModel[];
  dataSource: MatTableDataSource<PasajerosModel>;
  displayedColumns: string[] = ['editar',  'tipdocumento', 'identificacion', 'pnombre', 'snombre', 'papellido', 'sapellido', 'email', 'ncelular', 'eliminar'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  indexElEd: number;

  ngOnInit(): void {

    this.cargarTodosPasajeros();
  }

  createDialog(): void {
    const dialogRef = this.dialog.open(DialogcreatpasajerosComponent, {
      minWidth: '320px',
      maxWidth: '532px',
      data: {dataed: null}
    });

    dialogRef.afterClosed().subscribe(result => {
      // Se verifica si es diferente de nil para evitar error que ocurre al oprimir Esc
      if (result) {
        if (result.result) {
          if ((result.result === true) && (result.dataAdEd)) {
            this.dialog.open(DialogMessagesComponent, {
              minWidth: '320px',
              maxWidth: '532px',
              data: {message: 'Pasajero Creado 😃'}
            });
            this.dataPasajeros.push(result.dataAdEd);
            this.dataSource = new MatTableDataSource<PasajerosModel>(this.dataPasajeros);
            this.dataSource.paginator = this.paginator;
          }
        }
      }
    });
  }

  eliminar(PasajeroEd: PasajerosModel, indexEl: number): void {
    const dialogRef = this.dialog.open(DialogConfElimComponent, {
      minWidth: '320px',
      maxWidth: '532px',
      data: {message: '🤔 ¿Desea Borrar el Pasajero ' + PasajeroEd.pnombre + ' ' + PasajeroEd.papellido + '?', idPasajeroElim: PasajeroEd.id}
    });
    dialogRef.afterClosed().subscribe(result => {
      // Se verifica si es diferente de nil para evitar error que ocurre al oprimir Esc
      if (result) {
        if (result.result) {
          if ((result.result === true)) {

            this.dialog.open(DialogMessagesComponent, {
              minWidth: '320px',
              maxWidth: '532px',
              data: {message: 'Pasajero Eliminado 😌'}
            });
            this.dataPasajeros.splice(indexEl, 1);
            this.dataSource = new MatTableDataSource<PasajerosModel>(this.dataPasajeros);
            this.dataSource.paginator = this.paginator;
          }
        }
      }
    });


  }

  editar(PasajeroEd: PasajerosModel, indexEd: number): void {
    this.indexElEd = indexEd;
    const dialogRef = this.dialog.open(DialogcreatpasajerosComponent, {
      minWidth: '320px',
      maxWidth: '532px',
      data: {dataed: PasajeroEd}
    });
    dialogRef.afterClosed().subscribe(result => {
      // Se verifica si es diferente de nil para evitar error que ocurre al oprimir Esc
      if (result) {
        if (result.result) {
          if ((result.result === true) && (result.dataAdEd)) {
            this.dialog.open(DialogMessagesComponent, {
              minWidth: '320px',
              maxWidth: '532px',
              data: {message: 'Pasajero Editado 😃'}
            });
            this.dataPasajeros[this.indexElEd] = result.dataAdEd;
            this.dataSource = new MatTableDataSource<PasajerosModel>(this.dataPasajeros);
            this.dataSource.paginator = this.paginator;
          }
        }
      }
    });
  }

  cargarTodosPasajeros(): void {
    this.cargServ.iniciarCargando();

    this.pasajerosService.listarPasajeros().subscribe((res: Response) => {
      const data = res as any;
      this.dataPasajeros = data.pasajeros;
      this.dataSource = new MatTableDataSource<PasajerosModel>(this.dataPasajeros);
      this.dataSource.paginator = this.paginator;
      this.cargServ.detenCargando();
    });

  }


}
