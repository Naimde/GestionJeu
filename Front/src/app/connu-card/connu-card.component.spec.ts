import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnuCardComponent } from './connu-card.component';

describe('ConnuCardComponent', () => {
  let component: ConnuCardComponent;
  let fixture: ComponentFixture<ConnuCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnuCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnuCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
