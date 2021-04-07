import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateComunicadosComponent } from './update-comunicados.component';

describe('UpdateComunicadosComponent', () => {
  let component: UpdateComunicadosComponent;
  let fixture: ComponentFixture<UpdateComunicadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateComunicadosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateComunicadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
