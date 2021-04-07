import { Component, OnInit, Input } from '@angular/core';
import { ReceitasService } from "../../services/receitas.service";
import { Receitas } from '../../model/receitas.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-receitas-detalhes',
  templateUrl: './receitas-detalhes.component.html',
  styleUrls: ['./receitas-detalhes.component.css']
})
export class ReceitasDetalhesComponent implements OnInit {

  
  id: number;
  receita: Receitas = new Receitas();

  constructor(private route: ActivatedRoute,private router: Router, private receitasService: ReceitasService) { 
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

  list(){
    this.router.navigate(['receitas']);
  }

}