import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOpinionFormComponent } from './add-opinion-form.component';

describe('AddOpinionFormComponent', () => {
  let component: AddOpinionFormComponent;
  let fixture: ComponentFixture<AddOpinionFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddOpinionFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOpinionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
