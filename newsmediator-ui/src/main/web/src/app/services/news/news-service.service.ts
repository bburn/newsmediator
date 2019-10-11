import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { News } from 'src/app/interfaces/model/news';

@Injectable({
  providedIn: "root"
})
export class NewsService {
  constructor(private http: HttpClient) {}

  getNews(): Observable<News> {
    return this.http.get('http://localhost:8090/news/pl/technology/').pipe(map(result => <News>result));
  }
}
