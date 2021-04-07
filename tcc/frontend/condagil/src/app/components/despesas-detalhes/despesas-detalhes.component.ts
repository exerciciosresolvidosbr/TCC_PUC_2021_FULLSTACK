import { Component, OnInit } from '@angular/core';
import { DespesasService } from "../../services/despesas.service";
import { Despesas } from '../../model/despesas.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-despesas-detalhes',
  templateUrl: './despesas-detalhes.component.html',
  styleUrls: ['./despesas-detalhes.component.css']
})
export class DespesasDetalhesComponent implements OnInit {

  id: number;
  despesa: Despesas = new Despesas();

  constructor(private route: ActivatedRoute, private router: Router, private despesasService: DespesasService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.despesa = new Despesas();

    this.id = this.route.snapshot.params['id'];
    
    this.despesasService.getDespesa(this.id)
      .subscribe(data => {
        console.log(data)
        this.despesa = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['despesas']);
  }

}