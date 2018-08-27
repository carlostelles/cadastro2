import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {LoginPageComponent} from './login-page.component';
import {LoginRoutingModule} from './login-routing.module';

@NgModule({
  exports: [
  ],
  imports: [
    CommonModule,
    LoginRoutingModule,
    FormsModule
  ],
  declarations: [
    LoginPageComponent
  ]
})
export class LoginModule { }
