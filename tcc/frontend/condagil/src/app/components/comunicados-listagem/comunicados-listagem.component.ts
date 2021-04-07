import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Comunicados } from "../../model/comunicados.model";
import { ComunicadoService } from "../../services/comunicado.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-comunicados-listagem',
  templateUrl: './comunicados-listagem.component.html',
  styleUrls: ['./comunicados-listagem.component.css']
})
export class ComunicadosListagemComponent implements OnInit {

  listaComunicados?: Observable<Comunicados[]>;

  constructor(private comunicadoService: ComunicadoService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaComunicados = this.comunicadoService.getComunicadosList();
  }

  deletarComunicado(id: number) {
    this.comunicadoService.deletarComunicado(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarComunicado(){
    this.router.navigate(['comunicados/addComunicado']);
  }

  comunicadoDetalhes(id: number){
    this.router.navigate(['comunicados/detalhes', id]);
  }

  atualizarComunicado(id: number){
    this.router.navigate(['comunicados/updateComunicado', id]);
  }

  exportarPdf(id: number){
    this.comunicadoService.expotarComunicadoEmPdf(id)
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
        link.download = 'comunicado.pdf';
        link.dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true, view: window}));
        setTimeout(() => {
          window.URL.revokeObjectURL(data);
          link.remove();
        }, 100);
      },
      error => console.log(error));
  }

}