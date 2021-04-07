import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Chart, registerables } from 'chart.js';


@Component({
  selector: 'app-graficos',
  templateUrl: './graficos.component.html',
  styleUrls: ['./graficos.component.css']
})
export class GraficosComponent implements OnInit {

  //https://medium.com/@hannah15198/joboboflow-chart-js-and-d3-6f0872aee0ef
  //continuar daqui para recuperar os dados

  constructor() { }

  @ViewChild('evolucaoDespesas', {static: true}) evolucaoDespesas: ElementRef;
  @ViewChild('evolucaoReceitas', {static: true}) evolucaoReceitas: ElementRef;
  @ViewChild('caixa', {static: true}) caixa: ElementRef;
  @ViewChild('multas', {static: true}) multas: ElementRef;

  ngOnInit(): void {
    Chart.register(...registerables);
    this.configurarEvolucaoDespesas();
    this.configurarEvolucaoReceitas();
    this.configurarCaixa();
    this.configurarMultas();
  }

  configurarMultas(){
    var chartMultas = new Chart(this.multas.nativeElement, {
        type: 'line',
        data: {
            labels: ['Janeiro', 'Fevereiro', 'Março'],
            datasets: [
            {
              label: 'Valor Pago',
              data: [1000, 500, 450],
              fill: false,
              borderColor: 'rgba(75, 192, 192, 0.2)',
            },
            {
              label: 'Valor NÃO Pagas',
              data: [0, 800, 100],
              fill: false,
              borderColor: 'rgba(255, 99, 132, 0.2)',
            }
          ]
        }
    });
  }

  configurarCaixa(){
    var chartCaixa = new Chart(this.caixa.nativeElement, {
        type: 'bar',
        data: {
            labels: ['Janeiro', 'Fevereiro'],
            datasets: [
              {
                label: 'Caixa',
                data: [-500, 1500],
                backgroundColor: [
                  'rgba(255, 205, 86, 0.2)',
                  'rgba(255, 205, 86, 0.2)'
                ],
                borderColor: [
                  'rgb(255, 205, 86)',
                  'rgb(255, 205, 86)'
                ],
                borderWidth: 1
            }
          ]
        }
    });
  }

  configurarEvolucaoReceitas(){
    var chartEvolucaoReceitas = new Chart(this.evolucaoReceitas.nativeElement, {
        type: 'bar',
        data: {
            labels: ['Janeiro', 'Fevereiro'],
            datasets: [{
                label: 'Receitas',
                data: [1000, 1500],
                backgroundColor: [
                  'rgba(75, 192, 192, 0.2)',
                  'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                  'rgb(75, 192, 192)',
                  'rgb(75, 192, 192)'
                ],
                borderWidth: 1
            }]
        },
        options: {
          indexAxis: 'y',
        }
    });
  }

  configurarEvolucaoDespesas(){
    var chartEvolucaoDespesas = new Chart(this.evolucaoDespesas.nativeElement, {
        type: 'bar',
        data: {
            labels: ['Janeiro', 'Fevereiro'],
            datasets: [{
                label: 'Despesas',
                data: [1000, 1500],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(255, 99, 132, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(255, 99, 132, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
          indexAxis: 'y',
        }
    });
  }

}
