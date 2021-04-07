import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DespesasDetalhesComponent } from './despesas-detalhes.component';

describe('DespesasDetalhesComponent', () => {
  let component: DespesasDetalhesComponent;
  let fixture: ComponentFixture<DespesasDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DespesasDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DespesasDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
