import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoradoresListagemComponent } from './moradores-listagem.component';

describe('MoradoresListagemComponent', () => {
  let component: MoradoresListagemComponent;
  let fixture: ComponentFixture<MoradoresListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoradoresListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoradoresListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
