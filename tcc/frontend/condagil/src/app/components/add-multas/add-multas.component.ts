import { Component, OnInit } from '@angular/core';
import { MultasService } from "../../services/multas.service";
import { MoradoresService } from "../../services/moradores.service";
import { Multas } from '../../model/multas.model';
import { Moradores } from '../../model/moradores.model';
import { Router } from '@angular/router';
import { Observable } from "rxjs";

@Component({
  selector: 'app-add-multas',
  templateUrl: './add-multas.component.html',
  styleUrls: ['./add-multas.component.css']
})
export class AddMultasComponent implements OnInit {

  multa: Multas = new Multas();
  listaMoradores: Moradores[] = [];
  submitted = false;

  constructor(private multasService: MultasService, private moradoresService: MoradoresService, private router: Router) { 

  }

  ngOnInit(): void {
    this.moradoresService.getMoradoresList().subscribe(res => {
      this.listaMoradores = res;
    });
  }

  novaMulta(): void {
    this.submitted = false;
    this.multa = new Multas();
  }

  save() {
    this.multasService
    .createMulta(this.multa).subscribe(data => {
      console.log(data)
      this.multa = new Multas();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/multas']);
  }

}
