import { Component, OnInit } from '@angular/core';
import { DespesasService } from "../../services/despesas.service";
import { Despesas } from '../../model/despesas.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-despesas',
  templateUrl: './add-despesas.component.html',
  styleUrls: ['./add-despesas.component.css']
})
export class AddDespesasComponent implements OnInit {

  despesa: Despesas = new Despesas();
  submitted = false;

  constructor(private despesasService: DespesasService, private router: Router) { 

  }

  ngOnInit(): void {
  }

  novaDespesa(): void {
    this.submitted = false;
    this.despesa = new Despesas();
  }

  save() {
    this.despesasService
    .createDespesa(this.despesa).subscribe(data => {
      console.log(data)
      this.despesa = new Despesas();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/despesas']);
  }

}