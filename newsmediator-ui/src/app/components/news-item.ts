import { Component, Input } from '@angular/core';
import { Article } from '../interfaces/model/article';

@Component({
    selector: 'news-item',
    template: `
        <div class="news-item">
            <div class="item-summary" (click)="onSummaryClick()">
                <div class="item-element item-source">{{article.sourceName}}</div>
                <div class="item-element item-author">{{article.author}}</div>
                <div class="item-element item-title">{{article.title}}</div>
                <div class="item-element item-date">{{article.date}}</div>
            </div>
            <div *ngIf="expanded" class="item-description">
                {{article.description}}
            </div>
        </div>
    `,
    styles: [`
        .news-item {
            display: flex;
            flex-direction: column;
            border: 1px solid green;
        }
        @media (max-width: 768px) {
            .item-summary {
                flex-direction: column;
            }
        }
        .item-summary {
            display: flex;
            border: 1px solid red;
        }
        .item-element {
            border: 1px solid black;
            flex: 1;
            padding: 5px;
        }
        .item-title {
            flex-grow: 2;
        }
    `]
})
export class NewsItem {

    @Input()
    article: Article;
    expanded: boolean = false;

    onSummaryClick(): void {
        this.expanded = !this.expanded;
    }

}