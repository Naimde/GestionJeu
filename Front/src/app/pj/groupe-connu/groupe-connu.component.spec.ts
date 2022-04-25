import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupeConnuComponent } from './groupe-connu.component';

describe('GroupeConnuComponent', () => {
  let component: GroupeConnuComponent;
  let fixture: ComponentFixture<GroupeConnuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroupeConnuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupeConnuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
