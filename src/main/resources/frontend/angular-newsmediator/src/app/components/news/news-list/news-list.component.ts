import { Component, OnInit } from '@angular/core';
import { NewsService } from 'src/app/services/news/news-service.service';
import { News } from 'src/app/interfaces/model/news';
import { MatTableDataSource, MatSort } from '@angular/material';

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.scss']
})
export class NewsListComponent implements OnInit {

  public news: News;

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getNews().subscribe((data: News) => {
      // console.log(data);
      this.news = data;
    })
  }

}
