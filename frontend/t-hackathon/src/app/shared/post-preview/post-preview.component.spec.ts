import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginPostComponent } from './post-preview.component';

describe('LoginPostComponent', () => {
  let component: LoginPostComponent;
  let fixture: ComponentFixture<LoginPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoginPostComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(LoginPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
