export class Despesas { 
    
    id: number;
    descricao: string;
    dataDespesa: string;
    valor: number;
    
    constructor() {
        this.id = 0;
        this.descricao = '';
        this.dataDespesa = '';
        this.valor = 0;
    }
}