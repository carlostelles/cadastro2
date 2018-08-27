import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {PessoaRoutingModule} from './pessoa-routing.module';

import {PessoaSearchComponent} from './search/pessoa.search.component';
import {PessoaDetailComponent} from './detail/pessoa.detail.component';
import {CurrencyFormatPipe} from '../../shared/pipe/currencyFormat.pipe';
import {CurrencyMaskModule} from 'ng2-currency-mask';

@NgModule({
  exports: [
  ],
  imports: [
    CommonModule,
    PessoaRoutingModule,
    FormsModule,
    CurrencyMaskModule
  ],
  declarations: [
    PessoaSearchComponent,
    PessoaDetailComponent,
    CurrencyFormatPipe
  ]
})
export class PessoaModule { }
