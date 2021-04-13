import {PasajerosModel} from '../models/pasajeros.model';

export interface CreatePasajeroResponse {
    responseCode: number;
    pasajeros: Array<PasajerosModel>;
    responseDescription: string;
}

