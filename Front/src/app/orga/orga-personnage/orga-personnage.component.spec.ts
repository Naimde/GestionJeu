import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgaPersonnageComponent } from './orga-personnage.component';

describe('OrgaPersonnageComponent', () => {
  let component: OrgaPersonnageComponent;
  let fixture: ComponentFixture<OrgaPersonnageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrgaPersonnageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrgaPersonnageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
