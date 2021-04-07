import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFornecedoresComponent } from './update-fornecedores.component';

describe('UpdateFornecedoresComponent', () => {
  let component: UpdateFornecedoresComponent;
  let fixture: ComponentFixture<UpdateFornecedoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFornecedoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFornecedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
