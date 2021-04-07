import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateReceitasComponent } from './update-receitas.component';

describe('UpdateReceitasComponent', () => {
  let component: UpdateReceitasComponent;
  let fixture: ComponentFixture<UpdateReceitasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateReceitasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateReceitasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
