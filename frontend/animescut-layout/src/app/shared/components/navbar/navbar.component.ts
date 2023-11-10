import {Component, ViewChild} from '@angular/core';
import { AnimesService } from '../../../animes/service/animes.service';
import { LinkListComponent } from 'src/app/animes/link-list/link-list.component';


@Component({
  selector: 'app-navbar',
  templateUrl: '././navbar.component.html',
  styleUrls: ['././navbar.component.scss'],

})
export class NavbarComponent{
  anime: {title: string} = {title: ''};
  @ViewChild(LinkListComponent) linkListComponent!: LinkListComponent;

  constructor(private animesService: AnimesService){}

  searchAnimes(title : string){
    this.linkListComponent.clearSearchResults();
    this.animesService.searchAnimesByTitle(title);
  }
}

