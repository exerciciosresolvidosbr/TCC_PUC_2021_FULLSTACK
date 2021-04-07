import { Component, OnInit } from '@angular/core';
import { FornecedoresService } from "../../services/fornecedores.service";
import { Fornecedores } from '../../model/fornecedores.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-fornecedores',
  templateUrl: './add-fornecedores.component.html',
  styleUrls: ['./add-fornecedores.component.css']
})
export class AddFornecedoresComponent implements OnInit {

  fornecedor: Fornecedores = new Fornecedores();
  submitted = false;

  constructor(private fornecedoresService: FornecedoresService, private router: Router) { 

  }

  ngOnInit(): void {
  }

  novoComunicado(): void {
    this.submitted = false;
    this.fornecedor = new Fornecedores();
  }

  save() {
    this.fornecedoresService
    .createFornecedor(this.fornecedor).subscribe(data => {
      console.log(data)
      this.fornecedor = new Fornecedores();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/fornecedores']);
  }

}
