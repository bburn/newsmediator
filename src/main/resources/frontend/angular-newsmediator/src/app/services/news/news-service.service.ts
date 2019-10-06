import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: "root"
})
export class NewsService {
  constructor(private http: HttpClient) {}

  getNews(): Observable<News> { 
    return this.http.get('http://localhost:8080/news/pl/technology/').pipe(map(result => <News>result));
  }
}

export interface News {
  country: string;
  category: string;
  articles: Article[];
}

export interface Article {

  articleUrl: string;
  author: string;
  date: Date;
  description: string;
  imageUrl: string;
  sourceName: string;
  title: string;
}
