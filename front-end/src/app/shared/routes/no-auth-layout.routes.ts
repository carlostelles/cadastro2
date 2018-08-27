import {Routes} from '@angular/router';

export const NO_AUTH_ROUTES: Routes = [
  {
    path: '',
    children: [
      {
        path: 'login',
        loadChildren: './pages/login/login.module#LoginModule'
      }
    ]
  }
];
