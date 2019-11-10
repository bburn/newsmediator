import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticlesDataSourceComponent } from './articles-data-source.component';

describe('ArticlesDataSourceComponent', () => {
  let component: ArticlesDataSourceComponent;
  let fixture: ComponentFixture<ArticlesDataSourceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticlesDataSourceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticlesDataSourceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
