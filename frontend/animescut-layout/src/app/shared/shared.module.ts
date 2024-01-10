import { NgModule } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AnimesService } from '../animes/service/animes.service';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import {MatInputModule} from '@angular/material/input';



@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    ErrorDialogComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    NgFor,
    MatDialogModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  exports: [NavbarComponent, FooterComponent, ErrorDialogComponent],
  providers: [AnimesService]
})
export class SharedModule {}


