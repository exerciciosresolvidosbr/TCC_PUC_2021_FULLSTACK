import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants';

@Injectable({
  providedIn: 'root'
})
export class MultasService {

  constructor(private http: HttpClient) {
  }

  getMultasList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/multa/itens`);
  }

  getMulta(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/multa/${id}`);
  }

  createMulta(multa: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/multa`, multa);
  }

  deletarMulta(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/multa/${id}`, { responseType: 'text' });
  }

  updateMulta(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/multa/${id}`, value);
  }

  expotarMultaEmPdf(id: number): Observable<Blob> {
    return this.http.get(`${AppConstants.COMMAND_BASE_URL}/multa/export/pdf/${id}`, {responseType: 'blob'});
  }

}