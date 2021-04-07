import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DespesasService {
  
  private baseQueryUrl = 'http://localhost:8080/api/query/despesa';
  private baseCommandUrl = 'http://localhost:8080/api/command/despesa';

  constructor(private http: HttpClient) {
  }

  getDespesasList(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/itens`);
  }

  getDespesa(id: number): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/${id}`);
  }

  createDespesa(despesa: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandUrl}`, despesa);
  }

  deletarDespesa(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandUrl}/${id}`, { responseType: 'text' });
  }

  updateDespesa(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseCommandUrl}/${id}`, value);
  }

  expotarDespesasEmPdf(): Observable<Blob> {
    return this.http.get(`${this.baseQueryUrl}/export/pdf`, {responseType: 'blob'});
  }
}