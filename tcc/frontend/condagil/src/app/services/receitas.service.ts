import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants';

@Injectable({
  providedIn: 'root'
})
export class ReceitasService {

  constructor(private http: HttpClient) {
  }

  getReceitasList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/receita/itens`);
  }

  getReceita(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/receita/${id}`);
  }

  createReceita(receita: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/receita`, receita);
  }

  deletarReceita(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/receita/${id}`, { responseType: 'text' });
  }

  updateReceita(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/receita/${id}`, value);
  }

  expotarReceitasEmPdf(): Observable<Blob> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/receita/export/pdf`, {responseType: 'blob'});
  }

}
