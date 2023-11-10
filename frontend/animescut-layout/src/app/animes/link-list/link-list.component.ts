import { AnimesService } from './../service/animes.service';
import { Component, OnInit } from '@angular/core';
import { Anime } from '../model/anime';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-link-list',
  templateUrl: './link-list.component.html',
  styleUrls: ['./link-list.component.scss']
})
export class LinkListComponent implements OnInit{
  links!: Observable<Anime[]>;
  searchResults: Anime[] = [];
  noResultsMessage: string = '';


  //linkListService : LinkListService;
  constructor(
    private animesService: AnimesService,
    public dialog: MatDialog
    ){}

  ngOnInit(): void {
    this.animesService.listAnimesLink()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar animes');
        return of([])
      })
    ).subscribe(anime => {
      this.links = of(anime);
    });
}

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }
  
  clearSearchResults(): void {
    this.searchResults = [];
    this.noResultsMessage = '';
  }

  showSearchResults(results: Anime[]){
    this.searchResults = results;
    if(results.length === 0){
      this.noResultsMessage = 'Nenhuma anime foi encontrado';
    }else{
      this.noResultsMessage = '';
    }
  }


}
