import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgaObjetComponent } from './orga-objet.component';

describe('OrgaObjetComponent', () => {
  let component: OrgaObjetComponent;
  let fixture: ComponentFixture<OrgaObjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrgaObjetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrgaObjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
