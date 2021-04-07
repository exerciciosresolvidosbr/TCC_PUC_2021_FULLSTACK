import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FuncionarioService } from "../../services/funcionario.service";
import { Funcionarios } from '../../model/funcionarios.model';
import { PontoFuncionarios } from '../../model/PontoFuncionarios.model';

@Component({
  selector: 'app-update-funcionarios',
  templateUrl: './update-funcionarios.component.html',
  styleUrls: ['./update-funcionarios.component.css']
})
export class UpdateFuncionariosComponent implements OnInit {

  id: number;
  funcionario: Funcionarios = new Funcionarios();
  ponto : PontoFuncionarios = new PontoFuncionarios();
  closeResult = '';

  constructor(private route: ActivatedRoute, private router: Router, private funcionarioService: FuncionarioService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.funcionario = new Funcionarios();

    this.id = this.route.snapshot.params['id'];
    
    this.atualizarFuncionario();
  }

  updateFuncionario() {
    this.funcionarioService.updateFuncionario(this.id, this.funcionario)
      .subscribe(data => {
        console.log(data);
        this.funcionario = new Funcionarios();
        this.list();
      }, error => console.log(error));
  }

  novoPonto() {
    this.ponto = new PontoFuncionarios();
    this.ponto.idFuncionario = this.funcionario.id;
  }

  onSubmitFuncionario() {
    this.updateFuncionario();    
  }

  onSubmitPonto() {
    this.funcionarioService.createPontoFuncionario(this.ponto)
    .subscribe(data => {
      console.log(data);
      this.atualizarFuncionario();
    }, error => console.log(error));
  }

  list(){
    this.router.navigate(['funcionarios']);
  }

  atualizarFuncionario(){
    this.funcionarioService.getFuncionario(this.id)
    .subscribe(data => {
      console.log(data)
      this.funcionario = data;
    }, error => console.log(error));
  }

  deletarPonto(id: number) {
    this.funcionarioService.deletarPonto(id)
      .subscribe(
        data => {
          console.log(data);
          this.atualizarFuncionario();
        }, error => console.log(error));
  }

}