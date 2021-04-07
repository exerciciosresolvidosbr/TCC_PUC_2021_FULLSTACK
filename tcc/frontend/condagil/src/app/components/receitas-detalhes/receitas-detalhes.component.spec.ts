import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceitasDetalhesComponent } from './receitas-detalhes.component';

describe('ReceitasDetalhesComponent', () => {
  let component: ReceitasDetalhesComponent;
  let fixture: ComponentFixture<ReceitasDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceitasDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceitasDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
