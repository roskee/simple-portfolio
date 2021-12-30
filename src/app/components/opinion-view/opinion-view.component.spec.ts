import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpinionViewComponent } from './opinion-view.component';

describe('OpinionViewComponent', () => {
  let component: OpinionViewComponent;
  let fixture: ComponentFixture<OpinionViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpinionViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpinionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
