import { Component, OnInit } from '@angular/core';
import { Anime } from '../model/anime';

@Component({
  selector: 'app-link-list',
  templateUrl: './link-list.component.html',
  styleUrls: ['./link-list.component.scss']
})
export class LinkListComponent implements OnInit{
  links: Anime[] = [];

  constructor(){
    this.links = [
      {_id: '1', title: 'Shingueki', link: 'https://www.youtube.com/watch?v=ZLAVlaQPHgY'}
    ];
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
