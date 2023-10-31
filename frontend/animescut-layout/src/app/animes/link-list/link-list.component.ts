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
  links: Observable<Anime[]>;

  //linkListService : LinkListService;
  constructor(
    private animesService: AnimesService,
    public dialog: MatDialog
    ){
    this.links = animesService.listAnimesLink()
    .pipe(
      catchError(error => {
        this.onError('Erro ao carregar animes');
        return of([])
      })
    );
  }
  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {
   
  }

}
