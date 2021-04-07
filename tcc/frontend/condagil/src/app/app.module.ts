import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { NgxMaskModule, IConfig } from 'ngx-mask';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { ReceitasListagemComponent } from './components/receitas-listagem/receitas-listagem.component';
import { AddReceitasComponent } from './components/add-receitas/add-receitas.component';
import { ReceitasDetalhesComponent } from './components/receitas-detalhes/receitas-detalhes.component';
import { UpdateReceitasComponent } from './components/update-receitas/update-receitas.component';
import { AddDespesasComponent } from './components/add-despesas/add-despesas.component';
import { UpdateDespesasComponent } from './components/update-despesas/update-despesas.component';
import { DespesasListagemComponent } from './components/despesas-listagem/despesas-listagem.component';
import { DespesasDetalhesComponent } from './components/despesas-detalhes/despesas-detalhes.component';
import { ComunicadosDetalhesComponent } from './components/comunicados-detalhes/comunicados-detalhes.component';
import { ComunicadosListagemComponent } from './components/comunicados-listagem/comunicados-listagem.component';
import { UpdateComunicadosComponent } from './components/update-comunicados/update-comunicados.component';
import { AddComunicadosComponent } from './components/add-comunicados/add-comunicados.component';
import { AddMultasComponent } from './components/add-multas/add-multas.component';
import { UpdateMultasComponent } from './components/update-multas/update-multas.component';
import { MultasDetalhesComponent } from './components/multas-detalhes/multas-detalhes.component';
import { MultasListagemComponent } from './components/multas-listagem/multas-listagem.component';
import { AddMoradoresComponent } from './components/add-moradores/add-moradores.component';
import { UpdateMoradoresComponent } from './components/update-moradores/update-moradores.component';
import { MoradoresDetalhesComponent } from './components/moradores-detalhes/moradores-detalhes.component';
import { MoradoresListagemComponent } from './components/moradores-listagem/moradores-listagem.component';
import { AddFornecedoresComponent } from './components/add-fornecedores/add-fornecedores.component';
import { UpdateFornecedoresComponent } from './components/update-fornecedores/update-fornecedores.component';
import { FornecedoresDetalhesComponent } from './components/fornecedores-detalhes/fornecedores-detalhes.component';
import { FornecedoresListagemComponent } from './components/fornecedores-listagem/fornecedores-listagem.component';
import { LoginComponent } from './components/login/login.component';
import { LayoutComponent } from './components/layout/layout.component';
import { authInterceptorProviders } from './helpers/auth.interceptor';
import { RegistroComponent } from './components/registro/registro.component';
import { FuncionariosListagemComponent } from './components/funcionarios-listagem/funcionarios-listagem.component';
import { FuncionariosDetalhesComponent } from './components/funcionarios-detalhes/funcionarios-detalhes.component';
import { AddFuncionariosComponent } from './components/add-funcionarios/add-funcionarios.component';
import { UpdateFuncionariosComponent } from './components/update-funcionarios/update-funcionarios.component';
import { HomeComponent } from './components/home/home.component';
import { GraficosComponent } from './components/graficos/graficos.component'

@NgModule({
  declarations: [
    AppComponent,
    ReceitasListagemComponent,
    AddReceitasComponent,
    ReceitasDetalhesComponent,
    UpdateReceitasComponent,
    AddDespesasComponent,
    UpdateDespesasComponent,
    DespesasListagemComponent,
    DespesasDetalhesComponent,
    ComunicadosDetalhesComponent,
    ComunicadosListagemComponent,
    UpdateComunicadosComponent,
    AddComunicadosComponent,
    AddMultasComponent,
    UpdateMultasComponent,
    MultasDetalhesComponent,
    MultasListagemComponent,
    AddMoradoresComponent,
    UpdateMoradoresComponent,
    MoradoresDetalhesComponent,
    MoradoresListagemComponent,
    AddFornecedoresComponent,
    UpdateFornecedoresComponent,
    FornecedoresDetalhesComponent,
    FornecedoresListagemComponent,
    LoginComponent,
    LayoutComponent,
    RegistroComponent,
    FuncionariosListagemComponent,
    FuncionariosDetalhesComponent,
    AddFuncionariosComponent,
    UpdateFuncionariosComponent,
    HomeComponent,
    GraficosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    NgxMaskModule.forRoot(),
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
