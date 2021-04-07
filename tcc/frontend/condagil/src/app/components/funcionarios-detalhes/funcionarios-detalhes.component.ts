import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from "../../services/funcionario.service";
import { Funcionarios } from '../../model/funcionarios.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-funcionarios-detalhes',
  templateUrl: './funcionarios-detalhes.component.html',
  styleUrls: ['./funcionarios-detalhes.component.css']
})
export class FuncionariosDetalhesComponent implements OnInit {

  id: number;
  funcionario: Funcionarios = new Funcionarios();

  constructor(private route: ActivatedRoute, private router: Router, private funcionarioService: FuncionarioService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.funcionario = new Funcionarios();

    this.id = this.route.snapshot.params['id'];
    
    this.funcionarioService.getFuncionario(this.id)
      .subscribe(data => {
        console.log(data)
        this.funcionario = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['funcionarios']);
  }

}