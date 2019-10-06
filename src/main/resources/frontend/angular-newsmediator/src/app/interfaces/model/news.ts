import { Article } from './article';

export interface News {
    country: string;
    category: string;
    articles: Article[];
  }