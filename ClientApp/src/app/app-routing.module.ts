import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import {AuthGuardService} from './guards/auth-guard.service'

import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './auth/auth.component';
import { RegisterComponent } from './register/register.component';
const routes: Route[] = [
  { path: '', component: HomeComponent, canActivate: [AuthGuardService] },
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
  },
  { path: 'users', component: UserComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
