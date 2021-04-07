import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants'

@Injectable({
  providedIn: 'root'
})
export class ComunicadoService {

  constructor(private http: HttpClient) {}

  getComunicadosList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/comunicado/itens`);
  }

  getComunicado(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/comunicado/${id}`);
  }

  createComunicado(comunicado: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/comunicado`, comunicado);
  }

  deletarComunicado(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/comunicado/${id}`, { responseType: 'text' });
  }

  updateComunicado(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/comunicado/${id}`, value);
  }

  expotarComunicadoEmPdf(id: number): Observable<Blob> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/comunicado/export/pdf/${id}`, {responseType: 'blob'});
  }
}