import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficheMembreComponent } from './affiche-membre.component';

describe('AfficheMembreComponent', () => {
  let component: AfficheMembreComponent;
  let fixture: ComponentFixture<AfficheMembreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AfficheMembreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficheMembreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
