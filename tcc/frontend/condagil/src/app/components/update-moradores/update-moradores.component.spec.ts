import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMoradoresComponent } from './update-moradores.component';

describe('UpdateMoradoresComponent', () => {
  let component: UpdateMoradoresComponent;
  let fixture: ComponentFixture<UpdateMoradoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateMoradoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMoradoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
