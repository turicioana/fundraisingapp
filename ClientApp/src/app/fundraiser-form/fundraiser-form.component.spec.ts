import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundraiserFormComponent } from './fundraiser-form.component';

describe('FundraiserFormComponent', () => {
  let component: FundraiserFormComponent;
  let fixture: ComponentFixture<FundraiserFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundraiserFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundraiserFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
