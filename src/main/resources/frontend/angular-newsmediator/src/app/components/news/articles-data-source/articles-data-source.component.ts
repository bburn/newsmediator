import { Component, OnInit } from "@angular/core";
import { DataSource } from "@angular/cdk/table";
import { Article } from "src/app/interfaces/model/article";
import { NewsService } from "src/app/services/news/news-service.service";
import { BehaviorSubject, Observable, of } from "rxjs";
import { CollectionViewer } from "@angular/cdk/collections";
import { catchError, finalize } from "rxjs/operators";
import { News } from "src/app/interfaces/model/news";
import { MatTableDataSource, MatSort } from '@angular/material';

@Component({
  selector: "app-articles-data-source",
  templateUrl: "./articles-data-source.component.html",
  styleUrls: ["./articles-data-source.component.scss"]
})
export class ArticlesDataSourceComponent implements DataSource<Article> {
  private articlesSubject = new BehaviorSubject<Article[]>([]);

  constructor(private newsService: NewsService) {}

  connect(collectionViewer: CollectionViewer): Observable<Article[]> {
    return this.articlesSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.articlesSubject.complete();
  }

  loadArticles() {
    this.newsService
      .getNews()
      .pipe(catchError(() => of([])))
      .subscribe((data: News) => {
        console.log(data);
        const articles = data.articles;
        articles => this.articlesSubject.next(articles);
      });
  }
}
