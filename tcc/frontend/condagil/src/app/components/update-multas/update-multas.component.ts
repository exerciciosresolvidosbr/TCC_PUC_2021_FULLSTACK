import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MultasService } from "../../services/multas.service";
import { MoradoresService } from "../../services/moradores.service";
import { Multas } from '../../model/multas.model';
import { Moradores } from '../../model/moradores.model';

@Component({
  selector: 'app-update-multas',
  templateUrl: './update-multas.component.html',
  styleUrls: ['./update-multas.component.css']
})
export class UpdateMultasComponent implements OnInit {

  id: number;
  multa: Multas = new Multas();
  listaMoradores: Moradores[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private multasService: MultasService, private moradoresService: MoradoresService) { 
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

      this.moradoresService.getMoradoresList().subscribe(res => {
        this.listaMoradores = res;
      });
  }

  updateMulta() {
    this.multasService.updateMulta(this.id, this.multa)
      .subscribe(data => {
        console.log(data);
        this.multa = new Multas();
        this.list();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateMulta();    
  }

  list(){
    this.router.navigate(['multas']);
  }

}
