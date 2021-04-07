import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MultasService {

  private baseQueryUrl = 'http://localhost:8080/api/query/multa';
  private baseCommandUrl = 'http://localhost:8080/api/command/multa';

  constructor(private http: HttpClient) {
  }

  getMultasList(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/itens`);
  }

  getMulta(id: number): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/${id}`);
  }

  createMulta(multa: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandUrl}`, multa);
  }

  deletarMulta(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandUrl}/${id}`, { responseType: 'text' });
  }

  updateMulta(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseCommandUrl}/${id}`, value);
  }

  expotarMultaEmPdf(id: number): Observable<Blob> {
    return this.http.get(`${this.baseQueryUrl}/export/pdf/${id}`, {responseType: 'blob'});
  }

}