import {Routes} from '@angular/router';

export const AUTH_ROUTES: Routes = [
  {
    path: '',
    children: [
      {
        path: 'pessoas',
        loadChildren: './pages/pessoa/pessoa.module#PessoaModule'
      }
    ]
  }
];
