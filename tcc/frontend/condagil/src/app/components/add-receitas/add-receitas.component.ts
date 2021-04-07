import { Component, OnInit } from '@angular/core';
import { ReceitasService } from "../../services/receitas.service";
import { Receitas } from '../../model/receitas.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-receitas',
  templateUrl: './add-receitas.component.html',
  styleUrls: ['./add-receitas.component.css']
})
export class AddReceitasComponent implements OnInit {

  receita: Receitas = new Receitas();
  submitted = false;
  sucess: Boolean = false;
  errors: String[] = [];

  constructor(private receitasService: ReceitasService, private router: Router) { 

  }

  ngOnInit(): void {
  }

  novaReceita(): void {
    this.submitted = false;
    this.receita = new Receitas();
  }

  save() {
    this.receitasService
    .createReceita(this.receita).subscribe(data => {
      console.log(data)
      this.sucess = true;
      this.receita = new Receitas();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/receitas']);
  }

}