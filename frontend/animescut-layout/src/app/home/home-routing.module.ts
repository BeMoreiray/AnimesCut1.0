import { AnimesModule } from './../animes/animes.module';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'animes'},
  {
    path: 'animes',
    loadChildren: () => import('../animes/animes.module').then(m => m.AnimesModule)
  }
];

export const HomeRoutes = RouterModule.forChild(routes);
