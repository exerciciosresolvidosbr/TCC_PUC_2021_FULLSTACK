import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoradoresDetalhesComponent } from './moradores-detalhes.component';

describe('MoradoresDetalhesComponent', () => {
  let component: MoradoresDetalhesComponent;
  let fixture: ComponentFixture<MoradoresDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoradoresDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoradoresDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
