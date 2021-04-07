import { Component, OnInit } from '@angular/core';
import { MoradoresService } from "../../services/moradores.service";
import { Moradores } from '../../model/moradores.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-moradores',
  templateUrl: './add-moradores.component.html',
  styleUrls: ['./add-moradores.component.css']
})
export class AddMoradoresComponent implements OnInit {

  morador: Moradores = new Moradores();
  submitted = false;

  constructor(private moradoresService: MoradoresService, private router: Router) { 

  }

  ngOnInit(): void {
  }

  novoMorador(): void {
    this.submitted = false;
    this.morador = new Moradores();
  }

  save() {
    this.moradoresService
    .createMorador(this.morador).subscribe(data => {
      console.log(data)
      this.morador = new Moradores();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/moradores']);
  }

}