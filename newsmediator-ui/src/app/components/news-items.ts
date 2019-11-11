import { Component, Input } from '@angular/core';
import { Article } from '../interfaces/model/article';
import { NewsItem } from './news-item';

@Component({
    selector: 'news-items',
    template: `
        <news-item  *ngFor="let article of articles"
                    [article]="article"
        >
        </news-item>
    `,
    styles: [`
    `]
})
export class NewsItems {
    @Input()
    articles: Article[] = [];
}