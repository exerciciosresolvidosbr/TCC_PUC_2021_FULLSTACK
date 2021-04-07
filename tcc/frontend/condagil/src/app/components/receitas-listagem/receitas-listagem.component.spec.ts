import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceitasListagemComponent } from './receitas-listagem.component';

describe('ReceitasListagemComponent', () => {
  let component: ReceitasListagemComponent;
  let fixture: ComponentFixture<ReceitasListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceitasListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceitasListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
