import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FornecedoresService } from "../../services/fornecedores.service";
import { Fornecedores } from '../../model/fornecedores.model';

@Component({
  selector: 'app-update-fornecedores',
  templateUrl: './update-fornecedores.component.html',
  styleUrls: ['./update-fornecedores.component.css']
})
export class UpdateFornecedoresComponent implements OnInit {

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

  updateFornecedor() {
    this.fornecedoresService.updateFornecedor(this.id, this.fornecedor)
      .subscribe(data => {
        console.log(data);
        this.fornecedor = new Fornecedores();
        this.list();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateFornecedor();    
  }

  list(){
    this.router.navigate(['fornecedores']);
  }

}
