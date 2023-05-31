import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarDoadoresComponent } from './listar-doadores.component';

describe('ListarDoadoresComponent', () => {
  let component: ListarDoadoresComponent;
  let fixture: ComponentFixture<ListarDoadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarDoadoresComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarDoadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
