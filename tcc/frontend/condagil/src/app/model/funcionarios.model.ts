import { Observable } from "rxjs";
import { PontoFuncionarios } from "./PontoFuncionarios.model"

export class Funcionarios { 
    
    id: number;
    nome: string;
    dataAdmissao: string;
    dataDemissao: string;
    pontosFuncionarioDTO: PontoFuncionarios[];

    constructor() {
        this.id = 0;
        this.nome = '';
        this.dataAdmissao = '';
        this.dataDemissao = '';
    }
}