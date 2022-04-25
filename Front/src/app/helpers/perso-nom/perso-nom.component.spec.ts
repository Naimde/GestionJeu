import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersoNomComponent } from './perso-nom.component';

describe('PersoNomComponent', () => {
  let component: PersoNomComponent;
  let fixture: ComponentFixture<PersoNomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersoNomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersoNomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
