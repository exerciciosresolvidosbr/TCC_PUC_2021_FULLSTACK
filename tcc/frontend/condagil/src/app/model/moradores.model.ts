export class Moradores { 
    
    id: number;
    cpf: string;
    nome: string;
    identificacaoUnidadeHabitacional: string;
    email: string;
    telefone: string;
    
    constructor() {
        this.id = 0;
        this.cpf = '';
        this.nome = '';
        this.identificacaoUnidadeHabitacional = '';
        this.email = '';
        this.telefone = '';
    }
}