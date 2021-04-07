import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReceitasService {

  private baseQueryUrl = 'http://localhost:8080/api/query/receita';
  private baseCommandUrl = 'http://localhost:8080/api/command/receita';

  constructor(private http: HttpClient) {
  }

  getReceitasList(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/itens`);
  }

  getReceita(id: number): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/${id}`);
  }

  createReceita(receita: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandUrl}`, receita);
  }

  deletarReceita(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandUrl}/${id}`, { responseType: 'text' });
  }

  updateReceita(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseCommandUrl}/${id}`, value);
  }

  expotarReceitasEmPdf(): Observable<Blob> {
    return this.http.get(`${this.baseQueryUrl}/export/pdf`, {responseType: 'blob'});
  }

}
