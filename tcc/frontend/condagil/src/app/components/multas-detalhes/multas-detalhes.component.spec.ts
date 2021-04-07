import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MultasDetalhesComponent } from './multas-detalhes.component';

describe('MultasDetalhesComponent', () => {
  let component: MultasDetalhesComponent;
  let fixture: ComponentFixture<MultasDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MultasDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MultasDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
