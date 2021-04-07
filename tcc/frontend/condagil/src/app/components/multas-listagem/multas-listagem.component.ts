import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Multas } from "../../model/multas.model";
import { MultasService } from "../../services/multas.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-multas-listagem',
  templateUrl: './multas-listagem.component.html',
  styleUrls: ['./multas-listagem.component.css']
})
export class MultasListagemComponent implements OnInit {

  listaMultas?: Observable<Multas[]>;

  constructor(private multasService: MultasService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaMultas = this.multasService.getMultasList();
  }

  deletarMulta(id: number) {
    this.multasService.deletarMulta(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarMulta(){
    this.router.navigate(['multas/addMulta']);
  }

  multaDetalhes(id: number){
    this.router.navigate(['multas/detalhes', id]);
  }

  atualizarMulta(id: number){
    this.router.navigate(['multas/updateMulta', id]);
  }
 
  exportarPdf(id: number){
    this.multasService.expotarMultaEmPdf(id)
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
        link.download = 'multa.pdf';
        link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
        setTimeout(() => {
          window.URL.revokeObjectURL(data);
          link.remove();
        }, 100);
      },
      error => console.log(error));
  }
}