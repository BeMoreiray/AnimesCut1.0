import { Injectable } from '@angular/core';

import { Anime } from '../model/anime';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnimesService {
  private readonly baseUrl = "api/animes"

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

  searchAnimesByTitle(title: string): Observable<Anime[]>{
      const endpoint = "searchForAnimesNames";
      const url  = `${this.baseUrl}/${endpoint}`;
      const params = new HttpParams().set('title', title.toLowerCase().trim());

      return this.httpClient.get<Anime[]>(url, { params });
  }


}
