import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComunicadosDetalhesComponent } from './comunicados-detalhes.component';

describe('ComunicadosDetalhesComponent', () => {
  let component: ComunicadosDetalhesComponent;
  let fixture: ComponentFixture<ComunicadosDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComunicadosDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComunicadosDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
