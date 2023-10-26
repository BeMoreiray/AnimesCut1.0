import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AnimesRoutingModule } from './animes-routing.module';
import { LinkListComponent } from './link-list/link-list.component';
import { MatCardModule } from '@angular/material/card';


@NgModule({
  declarations: [
    LinkListComponent
  ],
  imports: [
    CommonModule,
    AnimesRoutingModule,
    MatCardModule
  ]
})
export class AnimesModule { }
