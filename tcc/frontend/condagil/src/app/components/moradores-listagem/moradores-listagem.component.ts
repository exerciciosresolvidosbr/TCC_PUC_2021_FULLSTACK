import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Moradores } from "../../model/moradores.model";
import { MoradoresService } from "../../services/moradores.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-moradores-listagem',
  templateUrl: './moradores-listagem.component.html',
  styleUrls: ['./moradores-listagem.component.css']
})
export class MoradoresListagemComponent implements OnInit {

  listaMoradores?: Observable<Moradores[]>;

  constructor(private moradoresService: MoradoresService, private router: Router) {
    
  }

  ngOnInit(): void {
    this.recarregarDados();
  }

  recarregarDados() {
    this.listaMoradores = this.moradoresService.getMoradoresList();
  }

  deletarMorador(id: number) {
    this.moradoresService.deletarMorador(id)
      .subscribe(
        data => {
          console.log(data);
          this.recarregarDados();
        },
        error => console.log(error));
  }

  adicionarMorador(){
    this.router.navigate(['moradores/addMorador']);
  }

  moradorDetalhes(id: number){
    this.router.navigate(['moradores/detalhes', id]);
  }

  atualizarMorador(id: number){
    this.router.navigate(['moradores/updateMorador', id]);
  }
 
}