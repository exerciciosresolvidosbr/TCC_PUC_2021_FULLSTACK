import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoradoresService {

  private baseQueryUrl = 'http://localhost:8080/api/query/morador';
  private baseCommandUrl = 'http://localhost:8080/api/command/morador';

  constructor(private http: HttpClient) {
  }

  getMoradoresList(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/itens`);
  }

  getMorador(id: number): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/${id}`);
  }

  createMorador(morador: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandUrl}`, morador);
  }

  deletarMorador(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandUrl}/${id}`, { responseType: 'text' });
  }

  updateMorador(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseCommandUrl}/${id}`, value);
  }
  
}