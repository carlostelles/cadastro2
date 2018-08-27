import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {FullLayoutComponent} from './layouts/full/full-layout.component';

import {AuthGuard} from './shared/auth/auth-guard.service';
import {AUTH_ROUTES} from './shared/routes/auth-layout.routes';
import {ContentLayoutComponent} from './layouts/content/content-layout.component';
import {NO_AUTH_ROUTES} from './shared/routes/no-auth-layout.routes';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'pessoas/pesquisar',
    pathMatch: 'full',
  },
  {
    path: '',
    component: ContentLayoutComponent,
    data: { title: 'content Views' },
    children: NO_AUTH_ROUTES
  },
  {
    path: '',
    component: FullLayoutComponent,
    data: { title: 'full Views' },
    children: AUTH_ROUTES,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
