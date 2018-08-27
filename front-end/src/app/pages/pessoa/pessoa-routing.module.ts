import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {PessoaSearchComponent} from './search/pessoa.search.component';
import {PessoaDetailComponent} from './detail/pessoa.detail.component';

const routes: Routes = [
  {
    path: ':id/editar',
    component: PessoaDetailComponent
  },
  {
    path: 'pesquisar',
    component: PessoaSearchComponent
  },
  {
    path: 'novo',
    component: PessoaDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PessoaRoutingModule { }
