import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../../../environments/environment';
import {PasajerosModel} from '../models/pasajeros.model';

@Injectable({
    providedIn: 'root'
})
export class PasajerosService {

    constructor( private http: HttpClient) {
    }
    path = 'api/servicios/pasaj';
    crearPasajero(request: PasajerosModel): Observable<any> {
        return this.http.post(environment.apiUrl + this.path, request, {});
    }

    listarPasajeros(): Observable<any> {
        return this.http.get(environment.apiUrl + this.path, {});
    }

    editarPasajero(request: PasajerosModel): Observable<any> {
      return this.http.put(environment.apiUrl + this.path, request, {});
    }
    eliminarPasajero(indexElim: number): Observable<any> {
      return this.http.delete(environment.apiUrl + this.path + '/' + indexElim.toString(), {});
    }
}
