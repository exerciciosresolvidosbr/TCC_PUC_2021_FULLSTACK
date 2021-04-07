import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMultasComponent } from './update-multas.component';

describe('UpdateMultasComponent', () => {
  let component: UpdateMultasComponent;
  let fixture: ComponentFixture<UpdateMultasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateMultasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMultasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
