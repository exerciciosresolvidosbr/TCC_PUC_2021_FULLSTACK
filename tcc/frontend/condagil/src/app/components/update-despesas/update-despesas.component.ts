import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DespesasService } from "../../services/despesas.service";
import { Despesas } from '../../model/despesas.model';

@Component({
  selector: 'app-update-despesas',
  templateUrl: './update-despesas.component.html',
  styleUrls: ['./update-despesas.component.css']
})
export class UpdateDespesasComponent implements OnInit {

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

  updateDespesa() {
    this.despesasService.updateDespesa(this.id, this.despesa)
      .subscribe(data => {
        console.log(data);
        this.despesa = new Despesas();
        this.list();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateDespesa();    
  }

  list(){
    this.router.navigate(['despesas']);
  }

}
