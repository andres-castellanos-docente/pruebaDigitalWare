import { NgModule } from '@angular/core';
import {AppMaterialModule} from './app.material.module';
import {MatTableExporterModule} from 'mat-table-exporter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';

@NgModule({
  imports:      [ AppMaterialModule,  MatTableExporterModule, ReactiveFormsModule,
    FormsModule, HttpClientModule,      CommonModule],
  declarations: [  ],
  exports:      [
    AppMaterialModule,  MatTableExporterModule, ReactiveFormsModule,
    FormsModule,  HttpClientModule,     CommonModule]
})
export class SharedModule { }
