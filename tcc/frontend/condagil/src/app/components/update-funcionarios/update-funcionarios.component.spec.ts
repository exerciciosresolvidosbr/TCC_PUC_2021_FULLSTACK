import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFuncionariosComponent } from './update-funcionarios.component';

describe('UpdateFuncionariosComponent', () => {
  let component: UpdateFuncionariosComponent;
  let fixture: ComponentFixture<UpdateFuncionariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFuncionariosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFuncionariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
