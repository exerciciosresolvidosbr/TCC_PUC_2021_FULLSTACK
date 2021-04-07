import {Moradores} from "./moradores.model";

export class Multas { 
    
    id: number;
    motivo: string;
    dataOcorrencia: string;
    dataPagamento: string;
    valor: number;
    idMorador: number;
    morador: Moradores;

    constructor() {
        this.id = 0;
        this.motivo = '';
        this.dataOcorrencia = '';
        this.dataPagamento = '';
        this.valor = 0;
        this.idMorador = 0;
        this.morador = new Moradores();
    }
}