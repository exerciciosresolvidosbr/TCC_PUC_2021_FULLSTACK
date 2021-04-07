import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FornecedoresService {

  private baseQueryUrl = 'http://localhost:8080/api/query/fornecedor';
  private baseCommandUrl = 'http://localhost:8080/api/command/fornecedor';

  constructor(private http: HttpClient) {}

  getFornecedoresList(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/itens`);
  }

  getFornecedor(id: number): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/${id}`);
  }

  createFornecedor(fornecedor: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandUrl}`, fornecedor);
  }

  deletarFornecedor(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandUrl}/${id}`, { responseType: 'text' });
  }

  updateFornecedor(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseCommandUrl}/${id}`, value);
  }
}