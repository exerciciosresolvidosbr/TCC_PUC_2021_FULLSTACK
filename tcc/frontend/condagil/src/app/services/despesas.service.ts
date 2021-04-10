import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants';

@Injectable({
  providedIn: 'root'
})
export class DespesasService {

  constructor(private http: HttpClient) {
  }

  getDespesasList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/despesa/itens`);
  }

  getDespesa(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/despesa/${id}`);
  }

  createDespesa(despesa: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/despesa`, despesa);
  }

  deletarDespesa(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/despesa/${id}`, { responseType: 'text' });
  }

  updateDespesa(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/despesa/${id}`, value);
  }

  expotarDespesasEmPdf(): Observable<Blob> {
    return this.http.get(`${AppConstants.COMMAND_BASE_URL}/despesa/export/pdf`, {responseType: 'blob'});
  }
}