import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Receitas } from "../../model/receitas.model";
import { ReceitasService } from "../../services/receitas.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-receitas-listagem',
  templateUrl: './receitas-listagem.component.html',
  styleUrls: ['./receitas-listagem.component.css']
})
export class ReceitasListagemComponent implements OnInit {

  listaReceitas?: Observable<Receitas[]>;

  constructor(private receitasService: ReceitasService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaReceitas = this.receitasService.getReceitasList();
  }

  deletarReceita(id: number) {
    this.receitasService.deletarReceita(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarReceita(){
    this.router.navigate(['receitas/addReceita']);
  }

  receitaDetalhes(id: number){
    this.router.navigate(['receitas/detalhes', id]);
  }

  atualizarReceita(id: number){
    this.router.navigate(['receitas/updateReceita', id]);
  }

  expotarReceitasPdf() {
    this.receitasService.expotarReceitasEmPdf()
    .subscribe(
      x => {
        const blob = new Blob([x], {type: 'application/pdf'});
        if(window.navigator && window.navigator.msSaveOrOpenBlob){
          window.navigator.msSaveOrOpenBlob(blob);
          return;
        }
        const data = window.URL.createObjectURL(blob);
        const link = document.createElement('a')
        link.href = data;
        link.download = 'receitas.pdf';
        link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
        setTimeout(() => {
          window.URL.revokeObjectURL(data);
          link.remove();
        }, 100);
      },
      error => console.log(error));
  }

}