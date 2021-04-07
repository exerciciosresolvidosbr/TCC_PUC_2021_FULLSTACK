import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComunicadosListagemComponent } from './comunicados-listagem.component';

describe('ComunicadosListagemComponent', () => {
  let component: ComunicadosListagemComponent;
  let fixture: ComponentFixture<ComunicadosListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComunicadosListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComunicadosListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
