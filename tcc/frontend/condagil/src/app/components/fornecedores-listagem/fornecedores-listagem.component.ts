import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Fornecedores } from "../../model/fornecedores.model";
import { FornecedoresService } from "../../services/fornecedores.service";
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-fornecedores-listagem',
  templateUrl: './fornecedores-listagem.component.html',
  styleUrls: ['./fornecedores-listagem.component.css']
})
export class FornecedoresListagemComponent implements OnInit {

  listaFornecedores?: Observable<Fornecedores[]>;

  constructor(private fornecedoresService: FornecedoresService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaFornecedores = this.fornecedoresService.getFornecedoresList();
  }

  deletarFornecedor(id: number) {
    this.fornecedoresService.deletarFornecedor(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarFornecedor(){
    this.router.navigate(['fornecedores/addFornecedor']);
  }

  fornecedorDetalhes(id: number){
    this.router.navigate(['fornecedores/detalhes', id]);
  }

  atualizarFornecedor(id: number){
    this.router.navigate(['fornecedores/updateFornecedor', id]);
  }

}
