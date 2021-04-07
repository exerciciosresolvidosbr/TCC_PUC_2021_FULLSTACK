import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DespesasListagemComponent } from './despesas-listagem.component';

describe('DespesasListagemComponent', () => {
  let component: DespesasListagemComponent;
  let fixture: ComponentFixture<DespesasListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DespesasListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DespesasListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
