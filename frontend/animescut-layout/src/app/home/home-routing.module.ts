
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../shared/auth/login/login.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'animes'},
  {
    path: '',
    loadChildren: () => import('../animes/animes.module').then(m => m.AnimesModule)
  },
  { path: 'login', component: LoginComponent }

];

export const HomeRoutes = RouterModule.forChild(routes);
