import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../helpers/app.constants';

@Injectable({
  providedIn: 'root'
})
export class MoradoresService {

  constructor(private http: HttpClient) {
  }

  getMoradoresList(): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/morador/itens`);
  }

  getMorador(id: number): Observable<any> {
    return this.http.get(`${AppConstants.QUERY_BASE_URL}/morador/${id}`);
  }

  createMorador(morador: Object): Observable<Object> {
    return this.http.post(`${AppConstants.COMMAND_BASE_URL}/morador`, morador);
  }

  deletarMorador(id: number): Observable<any> {
    return this.http.delete(`${AppConstants.COMMAND_BASE_URL}/morador/${id}`, { responseType: 'text' });
  }

  updateMorador(id: number, value: any): Observable<Object> {
    return this.http.put(`${AppConstants.COMMAND_BASE_URL}/morador/${id}`, value);
  }
  
}