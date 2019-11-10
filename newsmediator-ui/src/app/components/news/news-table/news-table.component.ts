import { Component, OnInit, ViewChild } from '@angular/core';
import { NewsService } from 'src/app/services/news/news-service.service';
import { ArticlesDataSourceComponent } from '../articles-data-source/articles-data-source.component';
import { MatTableDataSource, MatSort } from '@angular/material';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { Article } from 'src/app/interfaces/model/article';

@Component({
  selector: 'app-news-table',
  templateUrl: './news-table.component.html',
  styleUrls: ['./news-table.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class NewsTableComponent implements OnInit {

  dataSource: ArticlesDataSourceComponent;
  displayedColumns= ['sourceName', 'author', 'title', 'date']; 
  // 'description', 'articleUrl', 'imageUrl',
  expandedElement: Article | null;

  constructor(private newsService: NewsService) {}

  ngOnInit() {
      this.dataSource = new ArticlesDataSourceComponent(this.newsService);
      this.dataSource.loadArticles();
      // this.dataSource.loadNews();
      console.log(this.displayedColumns);
  }
}

