import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  private baseQueryUrl = 'http://localhost:8080/api/query/funcionario';
  private baseCommandUrl = 'http://localhost:8080/api/command/funcionario';
  private baseCommandPontoUrl = 'http://localhost:8080/api/command/ponto';

  constructor(private http: HttpClient) {}

  getFuncionariosList(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/itens`);
  }

  getFuncionario(id: number): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/${id}`);
  }

  createFuncionario(funcionario: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandUrl}`, funcionario);
  }

  createPontoFuncionario(ponto: Object): Observable<Object> {
    return this.http.post(`${this.baseCommandPontoUrl}`, ponto);
  }

  deletarFuncionario(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandUrl}/${id}`, { responseType: 'text' });
  }

  deletarPonto(id: number): Observable<any> {
    return this.http.delete(`${this.baseCommandPontoUrl}/${id}`, { responseType: 'text' });
  }

  updateFuncionario(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseCommandUrl}/${id}`, value);
  }
}