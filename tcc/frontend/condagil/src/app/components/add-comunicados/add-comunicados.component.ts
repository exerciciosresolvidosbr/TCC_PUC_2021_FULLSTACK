import { Component, OnInit } from '@angular/core';
import { ComunicadoService } from "../../services/comunicado.service";
import { Comunicados } from '../../model/comunicados.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-comunicados',
  templateUrl: './add-comunicados.component.html',
  styleUrls: ['./add-comunicados.component.css']
})
export class AddComunicadosComponent implements OnInit {
 
  comunicado: Comunicados = new Comunicados();
  submitted = false;

  constructor(private comunicadoService: ComunicadoService, private router: Router) { 

  }

  ngOnInit(): void {
  }

  novoComunicado(): void {
    this.submitted = false;
    this.comunicado = new Comunicados();
  }

  save() {
    this.comunicadoService
    .createComunicado(this.comunicado).subscribe(data => {
      console.log(data)
      this.comunicado = new Comunicados();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/comunicados']);
  }

}
