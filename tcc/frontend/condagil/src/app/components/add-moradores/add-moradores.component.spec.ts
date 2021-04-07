import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMoradoresComponent } from './add-moradores.component';

describe('AddMoradoresComponent', () => {
  let component: AddMoradoresComponent;
  let fixture: ComponentFixture<AddMoradoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMoradoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMoradoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
