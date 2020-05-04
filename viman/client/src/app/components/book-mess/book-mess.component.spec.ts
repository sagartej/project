import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookMessComponent } from './book-mess.component';

describe('BookMessComponent', () => {
  let component: BookMessComponent;
  let fixture: ComponentFixture<BookMessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookMessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookMessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
