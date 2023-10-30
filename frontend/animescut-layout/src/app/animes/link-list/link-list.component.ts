import { AnimesService } from './../service/animes.service';
import { Component, OnInit } from '@angular/core';
import { Anime } from '../model/anime';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-link-list',
  templateUrl: './link-list.component.html',
  styleUrls: ['./link-list.component.scss']
})
export class LinkListComponent implements OnInit{
  links: Observable<Anime[]>;

  //linkListService : LinkListService;
  constructor(private animesService: AnimesService){
    //this.linkListService = new LinkListService();
    this.links = animesService.listAnimesLink();
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
