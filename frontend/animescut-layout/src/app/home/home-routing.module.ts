
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'animes'},
  {
    path: '',
    loadChildren: () => import('../animes/animes.module').then(m => m.AnimesModule)
  }
];

export const HomeRoutes = RouterModule.forChild(routes);
