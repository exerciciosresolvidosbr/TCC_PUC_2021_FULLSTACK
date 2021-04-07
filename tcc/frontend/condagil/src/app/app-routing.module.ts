import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ReceitasListagemComponent } from './components/receitas-listagem/receitas-listagem.component';
import { AddReceitasComponent } from './components/add-receitas/add-receitas.component';
import { ReceitasDetalhesComponent } from './components/receitas-detalhes/receitas-detalhes.component';
import { UpdateReceitasComponent } from './components/update-receitas/update-receitas.component';

import { DespesasListagemComponent } from './components/despesas-listagem/despesas-listagem.component';
import { AddDespesasComponent } from './components/add-despesas/add-despesas.component';
import { DespesasDetalhesComponent } from './components/despesas-detalhes/despesas-detalhes.component';
import { UpdateDespesasComponent } from './components/update-despesas/update-despesas.component';

import { ComunicadosListagemComponent } from './components/comunicados-listagem/comunicados-listagem.component';
import { AddComunicadosComponent } from './components/add-comunicados/add-comunicados.component';
import { ComunicadosDetalhesComponent } from './components/comunicados-detalhes/comunicados-detalhes.component';
import { UpdateComunicadosComponent } from './components/update-comunicados/update-comunicados.component';

import { MultasListagemComponent } from './components/multas-listagem/multas-listagem.component';
import { AddMultasComponent } from './components/add-multas/add-multas.component';
import { MultasDetalhesComponent } from './components/multas-detalhes/multas-detalhes.component';
import { UpdateMultasComponent } from './components/update-multas/update-multas.component';

import { MoradoresListagemComponent } from './components/moradores-listagem/moradores-listagem.component';
import { AddMoradoresComponent } from './components/add-moradores/add-moradores.component';
import { MoradoresDetalhesComponent } from './components/moradores-detalhes/moradores-detalhes.component';
import { UpdateMoradoresComponent } from './components/update-moradores/update-moradores.component';

import { FornecedoresListagemComponent } from './components/fornecedores-listagem/fornecedores-listagem.component';
import { AddFornecedoresComponent } from './components/add-fornecedores/add-fornecedores.component';
import { FornecedoresDetalhesComponent } from './components/fornecedores-detalhes/fornecedores-detalhes.component';
import { UpdateFornecedoresComponent } from './components/update-fornecedores/update-fornecedores.component';

import { FuncionariosListagemComponent } from './components/funcionarios-listagem/funcionarios-listagem.component';
import { AddFuncionariosComponent } from './components/add-funcionarios/add-funcionarios.component';
import { FuncionariosDetalhesComponent } from './components/funcionarios-detalhes/funcionarios-detalhes.component';
import { UpdateFuncionariosComponent } from './components/update-funcionarios/update-funcionarios.component';

import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { LayoutComponent } from './components/layout/layout.component';
import { HomeComponent } from './components/home/home.component';
import { GraficosComponent } from './components/graficos/graficos.component'

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  //{ path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: '', component: LayoutComponent, children:[
    { path: 'home', component: HomeComponent },
    { path: 'graficos', component: GraficosComponent },
    { path: 'receitas', component: ReceitasListagemComponent },
    { path: 'receitas/addReceita', component: AddReceitasComponent },
    { path: 'receitas/detalhes/:id', component: ReceitasDetalhesComponent },
    { path: 'receitas/updateReceita/:id', component: UpdateReceitasComponent },
    { path: 'despesas', component: DespesasListagemComponent },
    { path: 'despesas/addDespesa', component: AddDespesasComponent },
    { path: 'despesas/detalhes/:id', component: DespesasDetalhesComponent },
    { path: 'despesas/updateDespesa/:id', component: UpdateDespesasComponent },
    { path: 'comunicados', component: ComunicadosListagemComponent },
    { path: 'comunicados/addComunicado', component: AddComunicadosComponent },
    { path: 'comunicados/detalhes/:id', component: ComunicadosDetalhesComponent },
    { path: 'comunicados/updateComunicado/:id', component: UpdateComunicadosComponent },
    { path: 'multas', component: MultasListagemComponent },
    { path: 'multas/addMulta', component: AddMultasComponent },
    { path: 'multas/detalhes/:id', component: MultasDetalhesComponent },
    { path: 'multas/updateMulta/:id', component: UpdateMultasComponent },
    { path: 'moradores', component: MoradoresListagemComponent },
    { path: 'moradores/addMorador', component: AddMoradoresComponent },
    { path: 'moradores/detalhes/:id', component: MoradoresDetalhesComponent },
    { path: 'moradores/updateMorador/:id', component: UpdateMoradoresComponent },
    { path: 'fornecedores', component: FornecedoresListagemComponent},
    { path: 'fornecedores/addFornecedor', component: AddFornecedoresComponent },
    { path: 'fornecedores/detalhes/:id', component: FornecedoresDetalhesComponent },
    { path: 'fornecedores/updateFornecedor/:id', component: UpdateFornecedoresComponent },
    { path: 'funcionarios', component: FuncionariosListagemComponent},
    { path: 'funcionarios/addFuncionario', component: AddFuncionariosComponent },
    { path: 'funcionarios/detalhes/:id', component: FuncionariosDetalhesComponent },
    { path: 'funcionarios/updateFuncionario/:id', component: UpdateFuncionariosComponent },
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }