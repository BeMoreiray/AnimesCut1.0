import { Injectable } from '@angular/core';

import { Anime } from '../model/anime';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnimesService {

  constructor(private httpClient: HttpClient) { }

  listAnimesLink(): Anime[]{
    return[
      {_id: '1', title: 'Shingueki no Kyojin', link: 'https://www.youtube.com/embed/JGwWNGJdvx8?si=D-GMWiztL9FEFTBN'}
    ];
  }
}
