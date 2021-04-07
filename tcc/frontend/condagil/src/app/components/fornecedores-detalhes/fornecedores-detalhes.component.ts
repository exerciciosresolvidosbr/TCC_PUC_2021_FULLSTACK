import { Component, OnInit } from '@angular/core';
import { FornecedoresService } from "../../services/fornecedores.service";
import { Fornecedores } from '../../model/fornecedores.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-fornecedores-detalhes',
  templateUrl: './fornecedores-detalhes.component.html',
  styleUrls: ['./fornecedores-detalhes.component.css']
})
export class FornecedoresDetalhesComponent implements OnInit {

  id: number;
  fornecedor: Fornecedores = new Fornecedores();

  constructor(private route: ActivatedRoute, private router: Router, private fornecedoresService: FornecedoresService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.fornecedor = new Fornecedores();

    this.id = this.route.snapshot.params['id'];
    
    this.fornecedoresService.getFornecedor(this.id)
      .subscribe(data => {
        console.log(data)
        this.fornecedor = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['fornecedores']);
  }

}
