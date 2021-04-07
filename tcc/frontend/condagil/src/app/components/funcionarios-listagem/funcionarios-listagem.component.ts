import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Funcionarios } from "../../model/funcionarios.model";
import { FuncionarioService } from "../../services/funcionario.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-funcionarios-listagem',
  templateUrl: './funcionarios-listagem.component.html',
  styleUrls: ['./funcionarios-listagem.component.css']
})
export class FuncionariosListagemComponent implements OnInit {

  listaFuncionarios?: Observable<Funcionarios[]>;

  constructor(private funcionariosService: FuncionarioService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaFuncionarios = this.funcionariosService.getFuncionariosList();
  }

  deletarFuncionario(id: number) {
    this.funcionariosService.deletarFuncionario(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarFuncionario(){
    this.router.navigate(['funcionarios/addFuncionario']);
  }

  funcionarioDetalhes(id: number){
    this.router.navigate(['funcionarios/detalhes', id]);
  }

  atualizarFuncionario(id: number){
    this.router.navigate(['funcionarios/updateFuncionario', id]);
  }

}
