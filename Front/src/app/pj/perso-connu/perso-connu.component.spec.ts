import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersoConnuComponent } from './perso-connu.component';

describe('PersoConnuComponent', () => {
  let component: PersoConnuComponent;
  let fixture: ComponentFixture<PersoConnuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersoConnuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersoConnuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
