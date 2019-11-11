import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NewsTableComponent } from './components/news/news-table/news-table.component';
import { ArticlesDataSourceComponent } from './components/news/articles-data-source/articles-data-source.component';
import { NewsItem } from './components/news-item';
import { NewsItems } from './components/news-items';
import { NewsApp } from './components/news-app';


@NgModule({
  declarations: [
    AppComponent,
    NewsTableComponent,
    ArticlesDataSourceComponent,
    NewsItem,
    NewsItems,
    NewsApp
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
