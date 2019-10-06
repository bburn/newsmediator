import { Component, OnInit } from '@angular/core';
import { NewsService, News } from 'src/app/services/news/news-service.service';

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
      console.log(data);
      this.news = data;
    })
  }

}
