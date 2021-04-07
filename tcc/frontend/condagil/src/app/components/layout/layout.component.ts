import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../services/token-storage-service.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  title = 'condagil';
  isMorador = false;
  isFuncionario = false;
  isLoggedIn = false;
  private roles: any[] = [];

  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    const token = this.token.getToken();
    if (token != null) {
      const user = this.token.getUser();
      this.roles = user.rolesDTO;
      this.isMorador = this.roles[0]['name'].includes('MORADOR');
      this.isFuncionario = this.roles[0]['name'].includes('FUNCIONARIO');
    }
  }

}
