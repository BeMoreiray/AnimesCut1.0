import {Component} from '@angular/core';
import { AnimesService } from '../../../animes/service/animes.service';


@Component({
  selector: 'app-navbar',
  templateUrl: '././navbar.component.html',
  styleUrls: ['././navbar.component.scss'],

})
export class NavbarComponent{
  anime: {title: string} = {title: ''};

  constructor(private animesService: AnimesService){}

  searchAnimes(title: string){
      this.animesService.searchAnimesByTitle(title).subscribe(data =>{
        console.log(data);
      });
  }
}
