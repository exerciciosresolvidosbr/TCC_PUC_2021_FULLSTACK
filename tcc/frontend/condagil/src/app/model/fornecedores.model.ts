export class Fornecedores { 
    
    id: number;
    docIdentificacao: string;
    nome: string;
    produtoServico: string;
    
    constructor() {
        this.id = 0;
        this.docIdentificacao = '';
        this.nome = '';
        this.produtoServico = '';
    }
}