import { Component, OnInit } from '@angular/core';
import { ComunicadoService } from "../../services/comunicado.service";
import { Comunicados } from '../../model/comunicados.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-comunicados-detalhes',
  templateUrl: './comunicados-detalhes.component.html',
  styleUrls: ['./comunicados-detalhes.component.css']
})
export class ComunicadosDetalhesComponent implements OnInit {

  id: number;
  comunicado: Comunicados = new Comunicados();

  constructor(private route: ActivatedRoute, private router: Router, private comunicadoService: ComunicadoService) { 
    this.id = 0;
  }

  ngOnInit(): void {
    this.comunicado = new Comunicados();

    this.id = this.route.snapshot.params['id'];
    
    this.comunicadoService.getComunicado(this.id)
      .subscribe(data => {
        console.log(data)
        this.comunicado = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['comunicados']);
  }

}
