import { Component, OnInit } from '@angular/core';
import { NewsItems } from './news-items';
import { NewsService } from '../services/news/news-service.service';
import { catchError } from 'rxjs/operators';
import { of, BehaviorSubject } from 'rxjs';
import { Article } from '../interfaces/model/article';
import { News } from '../interfaces/model/news';

@Component({
    selector: 'news-app',
    template: `
        <news-items [articles]="articlesSubject | async"></news-items>
    `,
    styles: [`
        
    `]
})
export class NewsApp implements OnInit {

    private articlesSubject = new BehaviorSubject<Article[]>([]);

    constructor(private newsService: NewsService) {
    }

    ngOnInit(): void {
        this.newsService
            .getNews()
            .pipe(catchError(() => of([])))
            .subscribe((data: News) => {
                this.articlesSubject.next(data.articles);
            });
    }

}