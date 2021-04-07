import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseQueryUrl = 'http://localhost:8080/api/query/usuario';
  private baseCommandUrl = 'http://localhost:8080/api/command/usuario';

  constructor(private http: HttpClient) { }

  getCurrentUser(): Observable<any> {
    return this.http.get(`${this.baseQueryUrl}/me`);
  }
}
