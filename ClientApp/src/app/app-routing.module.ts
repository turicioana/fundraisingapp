import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import {AuthGuardService} from './guards/auth-guard.service'

import { LoginComponent } from './authentication/login/login.component';
import { HomeComponent } from './home/home.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import { AuthComponent } from './authentication/auth/auth.component';
import { RegisterComponent } from './authentication/register/register.component';
import { FundraiserComponent } from './fundraiser/fundraiser.component';
import { FundraiserFormComponent } from './fundraiser-form/fundraiser-form.component';
const routes: Route[] = [
  { path: '', component: DashboardComponent, canActivate: [AuthGuardService]},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuardService], children:[
    {
      path:"fundraisers",
      component: FundraiserComponent,
      data: { roles: ['FUNDRAISER', 'USER']}
    }
  ]},
  {
    path:"fundraisers-form",
    component: FundraiserFormComponent,
    data: { roles: ['FUNDRAISER', 'USER']}
  },
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
