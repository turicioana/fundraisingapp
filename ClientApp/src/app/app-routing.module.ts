import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import {AuthGuardService} from './guards/auth-guard.service'

import { LoginComponent } from './authentication/login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './authentication/auth/auth.component';
import { RegisterComponent } from './authentication/register/register.component';
import { FundraiserComponent } from './fundraiser/fundraiser.component';
const routes: Route[] = [
  { path: '', component: HomeComponent, canActivate: [AuthGuardService], children: [
    {
      path:"fundraisers",
      component: FundraiserComponent,
      data: { roles: ['FUNDRAISER', 'USER']}
    }
  ] },
  { path: '**', redirectTo: '/auth', pathMatch: 'full' },
  {path: 'auth', component: AuthComponent, children: [
    {
      path: "login",
      component: LoginComponent
  },
  {
      path: "register",
      component: RegisterComponent
  },
  ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
