import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Despesas } from "../../model/despesas.model";
import { DespesasService } from "../../services/despesas.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-despesas-listagem',
  templateUrl: './despesas-listagem.component.html',
  styleUrls: ['./despesas-listagem.component.css']
})
export class DespesasListagemComponent implements OnInit {

  listaDespesas?: Observable<Despesas[]>;

  constructor(private despesasService: DespesasService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaDespesas = this.despesasService.getDespesasList();
  }

  deletarDespesa(id: number) {
    this.despesasService.deletarDespesa(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarDespesa(){
    this.router.navigate(['despesas/addDespesa']);
  }

  despesaDetalhes(id: number){
    this.router.navigate(['despesas/detalhes', id]);
  }

  atualizarDespesa(id: number){
    this.router.navigate(['despesas/updateDespesa', id]);
  }
 
  expotarDespesasPdf() {
    this.despesasService.expotarDespesasEmPdf()
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
        link.download = 'despesas.pdf';
        link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
        setTimeout(() => {
          window.URL.revokeObjectURL(data);
          link.remove();
        }, 100);
      },
      error => console.log(error));
  }

}