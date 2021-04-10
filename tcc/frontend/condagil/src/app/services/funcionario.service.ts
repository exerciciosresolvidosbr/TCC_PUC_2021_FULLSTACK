import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  constructor(private http: HttpClient) {}

  getFuncionariosList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/funcionario/itens`);
  }

  getFuncionario(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/funcionario/${id}`);
  }

  createFuncionario(funcionario: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/funcionario`, funcionario);
  }

  createPontoFuncionario(ponto: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/ponto`, ponto);
  }

  deletarFuncionario(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/funcionario/${id}`, { responseType: 'text' });
  }

  deletarPonto(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/ponto/${id}`, { responseType: 'text' });
  }

  updateFuncionario(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/funcionario/${id}`, value);
  }
}