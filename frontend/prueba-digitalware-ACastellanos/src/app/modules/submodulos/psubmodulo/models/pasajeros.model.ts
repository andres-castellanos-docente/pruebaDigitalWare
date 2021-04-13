export class PasajerosModel {
  id: number;
  email: string;
  identificacion: number;
  papellido: string;
  pnombre: string;
  sapellido: string;
  snombre: number;
  tipdocumento: number;
  ncelular: number;
  constructor(json: any = null) {
    if (json !== null) {
      this.id = json.id;
      this.email = json.email;
      this.identificacion = json.identificacion;
      this.papellido = json.papellido;
      this.pnombre = json.pnombre;
      this.sapellido = json.sapellido;
      this.snombre = json.snombre;
      this.tipdocumento = json.tipdocumento;
      this.ncelular = json.ncelular;

    } else {
      this.id = null;
      this.email = null;
      this.identificacion = null;
      this.papellido = null;
      this.pnombre = null;
      this.sapellido = null;
      this.snombre = null;
      this.tipdocumento = null;
      this.ncelular = null;
    }
  }
}
