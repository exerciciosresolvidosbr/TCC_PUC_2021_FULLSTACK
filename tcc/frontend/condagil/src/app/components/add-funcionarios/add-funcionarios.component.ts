import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from "../../services/funcionario.service";
import { Funcionarios } from '../../model/funcionarios.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-funcionarios',
  templateUrl: './add-funcionarios.component.html',
  styleUrls: ['./add-funcionarios.component.css']
})
export class AddFuncionariosComponent implements OnInit {

  funcionario: Funcionarios = new Funcionarios();
  submitted = false;

  constructor(private funcionarioService: FuncionarioService, private router: Router) { 

  }

  ngOnInit(): void {
  }

  novoFuncionario(): void {
    this.submitted = false;
    this.funcionario = new Funcionarios();
  }

  save() {
    this.funcionarioService
    .createFuncionario(this.funcionario).subscribe(data => {
      console.log(data)
      this.funcionario = new Funcionarios();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/funcionarios']);
  }
}