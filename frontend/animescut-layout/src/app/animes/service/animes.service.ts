import { Injectable } from '@angular/core';

import { Anime } from '../model/anime';
import { HttpClient } from '@angular/common/http';
import { first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnimesService {
  private readonly API = "api/animes/getAllAnimesLinkDTO"

  constructor(private httpClient: HttpClient) { }

  listAnimesLink(){
    return this.httpClient.get<Anime[]>(this.API)
    .pipe(
      first(),
      tap(animes => console.log(animes))
    );
  }
}
