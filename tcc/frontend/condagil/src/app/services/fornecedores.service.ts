import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants';

@Injectable({
  providedIn: 'root'
})
export class FornecedoresService {

  constructor(private http: HttpClient) {}

  getFornecedoresList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/fornecedor/itens`);
  }

  getFornecedor(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/fornecedor/${id}`);
  }

  createFornecedor(fornecedor: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/fornecedor`, fornecedor);
  }

  deletarFornecedor(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/fornecedor/${id}`, { responseType: 'text' });
  }

  updateFornecedor(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/fornecedor/${id}`, value);
  }
}