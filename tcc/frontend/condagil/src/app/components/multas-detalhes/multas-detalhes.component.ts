import { Component, OnInit } from '@angular/core';
import { MultasService } from "../../services/multas.service";
import { Multas } from '../../model/multas.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-multas-detalhes',
  templateUrl: './multas-detalhes.component.html',
  styleUrls: ['./multas-detalhes.component.css']
})
export class MultasDetalhesComponent implements OnInit {

  id: number;
  multa: Multas = new Multas();

  constructor(private route: ActivatedRoute, private router: Router, private multasService: MultasService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.multa = new Multas();

    this.id = this.route.snapshot.params['id'];
    
    this.multasService.getMulta(this.id)
      .subscribe(data => {
        console.log(data)
        this.multa = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['multas']);
  }

}
