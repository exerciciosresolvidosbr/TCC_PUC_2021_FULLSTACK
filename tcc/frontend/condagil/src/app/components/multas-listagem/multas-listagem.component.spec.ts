import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MultasListagemComponent } from './multas-listagem.component';

describe('MultasListagemComponent', () => {
  let component: MultasListagemComponent;
  let fixture: ComponentFixture<MultasListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MultasListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MultasListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
