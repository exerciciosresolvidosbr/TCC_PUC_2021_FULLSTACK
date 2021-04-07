export class Receitas { 
    
    id: number;
    descricao: string;
    dataReceita: string;
    valor: number;
    
    constructor() {
        this.id = 0;
        this.descricao = '';
        this.dataReceita = '';
        this.valor = 0;
    }
}