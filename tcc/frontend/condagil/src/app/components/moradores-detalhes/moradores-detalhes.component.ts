import { Component, OnInit } from '@angular/core';
import { MoradoresService } from "../../services/moradores.service";
import { Moradores } from '../../model/moradores.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-moradores-detalhes',
  templateUrl: './moradores-detalhes.component.html',
  styleUrls: ['./moradores-detalhes.component.css']
})
export class MoradoresDetalhesComponent implements OnInit {

  id: number;
  morador: Moradores = new Moradores();

  constructor(private route: ActivatedRoute, private router: Router, private moradoresService: MoradoresService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.morador = new Moradores();

    this.id = this.route.snapshot.params['id'];
    
    this.moradoresService.getMorador(this.id)
      .subscribe(data => {
        console.log(data)
        this.morador = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['moradores']);
  }

}