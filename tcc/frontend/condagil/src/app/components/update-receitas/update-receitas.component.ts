import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReceitasService } from "../../services/receitas.service";
import { Receitas } from '../../model/receitas.model';

@Component({
  selector: 'app-update-receitas',
  templateUrl: './update-receitas.component.html',
  styleUrls: ['./update-receitas.component.css']
})
export class UpdateReceitasComponent implements OnInit {

  id: number;
  receita: Receitas = new Receitas();

  constructor(private route: ActivatedRoute, private router: Router, private receitasService: ReceitasService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.receita = new Receitas();

    this.id = this.route.snapshot.params['id'];
    
    this.receitasService.getReceita(this.id)
      .subscribe(data => {
        console.log(data)
        this.receita = data;
      }, error => console.log(error));
  }

  updateReceita() {
    this.receitasService.updateReceita(this.id, this.receita)
      .subscribe(data => {
        console.log(data);
        this.receita = new Receitas();
        this.list();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateReceita();    
  }

  list(){
    this.router.navigate(['receitas']);
  }

}
