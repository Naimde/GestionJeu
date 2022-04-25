import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LieuConnuComponent } from './lieu-connu.component';

describe('LieuConnuComponent', () => {
  let component: LieuConnuComponent;
  let fixture: ComponentFixture<LieuConnuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LieuConnuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LieuConnuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
