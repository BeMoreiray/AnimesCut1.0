import { Injectable } from '@angular/core';

import { Anime } from '../model/anime';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnimesService {
  private readonly baseUrl = "api/animes";
  private searchResultsSource = new BehaviorSubject<Anime[]>([]);
  searchResults$ = this.searchResultsSource.asObservable();

  constructor(private httpClient: HttpClient) { }

  listAnimesLink(){
    const endpoint = "getAllAnimesLinkDTO";
    const url = `${this.baseUrl}/${endpoint}`;

    return this.httpClient.get<Anime[]>(url)
    .pipe(
      first(),
      tap(animes => console.log(animes))
    );
  }

  searchAnimesByTitle(title: string): void{
      const endpoint = "searchForAnimesNames";
      const url  = `${this.baseUrl}/${endpoint}`;
      const params = new HttpParams().set('title', title.toLowerCase().trim());

      this.httpClient.get<Anime[]>(url, { params }).subscribe((results) =>{
        this.searchResultsSource.next(results);
      });
  }

  searchAnimesByCategory(category : string): void {
    const ednpoint = "searchAnimesByCategory";
    const url = `${this.baseUrl}/${ednpoint}`;
    const params = new HttpParams().set('typesTitle', category.toLowerCase().trim());

    this.httpClient.get<Anime[]>(url, { params }).subscribe(results =>{
      console.log(results);

    });
  }


}
