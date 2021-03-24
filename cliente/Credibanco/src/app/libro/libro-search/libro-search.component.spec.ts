import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroSearchComponent } from './libro-search.component';

describe('LibroSearchComponent', () => {
  let component: LibroSearchComponent;
  let fixture: ComponentFixture<LibroSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibroSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibroSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
