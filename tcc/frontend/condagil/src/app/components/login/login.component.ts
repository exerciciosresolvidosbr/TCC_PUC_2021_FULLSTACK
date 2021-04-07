import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from '../../services/token-storage-service.service';
import { AuthService } from '../../services/auth-service.service';
import { UserService } from '../../services/user-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  currentUser: any;
  googleURL = 'http://localhost:8080/oauth2/authorization/google?redirect_uri=http://localhost:8081/login';

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private route: ActivatedRoute, private router: Router, private userService: UserService) {}

  ngOnInit(): void {
    const token: string = this.route.snapshot.queryParamMap.get('token');
    const error: string = this.route.snapshot.queryParamMap.get('error');

    if (this.tokenStorage.getToken() && Object.keys(this.tokenStorage.getToken()).length === 0) {
      this.isLoggedIn = true;
      this.currentUser = this.tokenStorage.getUser();
    }else if(token){
        this.tokenStorage.saveToken(token);
        this.userService.getCurrentUser().subscribe(
              data => {
                this.login(data);
              },
              err => {
                this.errorMessage = err.error.message;
                this.isLoginFailed = true;
              }
          );
    }
    else if(error){
        this.errorMessage = error;
        this.isLoginFailed = true;
    }
  }

  onSubmit(): void {
    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.login(data.usuarioDTO);
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  login(user: any): void {
    this.tokenStorage.saveUser(user);
    this.isLoginFailed = false;
    this.isLoggedIn = true;
    this.currentUser = this.tokenStorage.getUser();
    this.router.navigate(['/home']);
  }

  prepararCadastro(){
    this.router.navigate(['/registro']);
  }

}
