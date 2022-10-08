import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrgaLieuComponent } from './orga-lieu.component';

describe('OrgaLieuComponent', () => {
  let component: OrgaLieuComponent;
  let fixture: ComponentFixture<OrgaLieuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrgaLieuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrgaLieuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
