import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ComunicadoService } from "../../services/comunicado.service";
import { Comunicados } from '../../model/comunicados.model';

@Component({
  selector: 'app-update-comunicados',
  templateUrl: './update-comunicados.component.html',
  styleUrls: ['./update-comunicados.component.css']
})
export class UpdateComunicadosComponent implements OnInit {

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

  updateDespesa() {
    this.comunicadoService.updateComunicado(this.id, this.comunicado)
      .subscribe(data => {
        console.log(data);
        this.comunicado = new Comunicados();
        this.list();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateDespesa();    
  }

  list(){
    this.router.navigate(['comunicados']);
  }

}
