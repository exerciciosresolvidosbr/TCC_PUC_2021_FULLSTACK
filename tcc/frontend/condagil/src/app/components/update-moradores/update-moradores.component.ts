import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MoradoresService } from "../../services/moradores.service";
import { Moradores } from '../../model/moradores.model';

@Component({
  selector: 'app-update-moradores',
  templateUrl: './update-moradores.component.html',
  styleUrls: ['./update-moradores.component.css']
})
export class UpdateMoradoresComponent implements OnInit {

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

  updateMorador() {
    this.moradoresService.updateMorador(this.id, this.morador)
      .subscribe(data => {
        console.log(data);
        this.morador = new Moradores();
        this.list();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateMorador();    
  }

  list(){
    this.router.navigate(['moradores']);
  }

}
