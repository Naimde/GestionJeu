import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgaGroupeComponent } from './orga-groupe.component';

describe('OrgaGroupeComponent', () => {
  let component: OrgaGroupeComponent;
  let fixture: ComponentFixture<OrgaGroupeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrgaGroupeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrgaGroupeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
