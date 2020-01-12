import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindTranslatorComponent } from './find-translator.component';

describe('FindTranslatorComponent', () => {
  let component: FindTranslatorComponent;
  let fixture: ComponentFixture<FindTranslatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindTranslatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindTranslatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
