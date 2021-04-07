import { Component } from '@angular/core';
import { TokenStorageService } from './services/token-storage-service.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'condagil';

  private roles: string[] = [];
  isLoggedIn = false;
  username: string = "";
 
  constructor(private tokenStorageService: TokenStorageService, private router: Router, private route: ActivatedRoute) { }
 
  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken() && Object.keys(this.tokenStorageService.getToken()).length === 0;
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.rolesDTO;
      this.username = user.displayName;
    }
  }
 
  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }

}