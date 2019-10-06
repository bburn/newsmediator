import { Component, OnInit, ViewChild } from '@angular/core';
import { NewsService } from 'src/app/services/news/news-service.service';
import { ArticlesDataSourceComponent } from '../articles-data-source/articles-data-source.component';

@Component({
  selector: 'app-news-table',
  templateUrl: './news-table.component.html',
  styleUrls: ['./news-table.component.scss']
})
export class NewsTableComponent implements OnInit {

  dataSource: ArticlesDataSourceComponent;
  displayedColumns= ['sourceName', 'author', 'title', 'description', 'articleUrl', 'imageUrl', 'date'];


  constructor(private newsService: NewsService) {}

  ngOnInit() {
      this.dataSource = new ArticlesDataSourceComponent(this.newsService);
      this.dataSource.loadArticles();
  }
}
