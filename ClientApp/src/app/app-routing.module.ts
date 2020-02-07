import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import {AuthGuardService} from './guards/auth-guard.service'

import { LoginComponent } from './authentication/login/login.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import { AuthComponent } from './authentication/auth/auth.component';
import { RegisterComponent } from './authentication/register/register.component';
import { FundraiserComponent } from './all-of-fundraiser/fundraiser/fundraiser.component';
import { FundraiserFormComponent } from './all-of-fundraiser/fundraiser-form/fundraiser-form.component';
import { CategoryComponent } from './category/category.component';
import { CompanyFormComponent } from './company-form/company-form.component';
import { FundraiserDetailsComponent } from './all-of-fundraiser/fundraiser-details/fundraiser-details.component';
import {VoucherFormComponent} from './all-of-voucher/voucher-form/voucher-form.component';
import {VoucherDetailsComponent} from './all-of-voucher/voucher-details/voucher-details.component';
import {VoucherComponent} from './all-of-voucher/voucher/voucher.component';
import { DonationFormComponent } from './donation-form/donation-form.component';
import { MyFundraisersComponent } from './all-of-fundraiser/my-fundraisers/my-fundraisers.component';
const routes: Route[] = [
  { path: '', component: DashboardComponent, canActivate: [AuthGuardService], children: [
    {
      path: "categories",
      component: CategoryComponent,
      data: { roles: ['FUNDRAISER', 'USER','ADMIN']}
    }
  ]},
  {
    path:"fundraisers",
    component: FundraiserComponent,
    canActivate: [AuthGuardService],
    data: { roles: ['FUNDRAISER', 'USER', 'COMPANY','ADMIN']}
  },
  {
    path:"my_fundraisers",
    component: MyFundraisersComponent,
    canActivate:[AuthGuardService],
    data: {roles: ['FUNDRAISER']}
  },
  {
    path:"fundraisers/:id",
    component: FundraiserDetailsComponent,
    canActivate: [AuthGuardService],
    data: { roles: ['FUNDRAISER', 'USER', 'COMPANY','ADMIN']},
  },
  {
    path:"fundraisers/:id/vouchers",
    component: VoucherFormComponent,
    canActivate: [AuthGuardService],
    data: { roles: ['COMPANY']}
  },
  {
    path:"fundraisers/:id/donations",
    component: DonationFormComponent,
    canActivate: [AuthGuardService],
    data: { roles: ['USER', 'COMPANY']}
  },
  {
    path:"fundraisers-form",
    component: FundraiserFormComponent,
    data: { roles: ['FUNDRAISER', 'USER']}
  },
  {
    path: "company-form",
    component: CompanyFormComponent,
    data: {roles : ['USER']}
  },
  {
    path:"vouchers",
    component: VoucherComponent,
    canActivate: [AuthGuardService],
    data: { roles: ['COMPANY', 'FUNDRAISER', 'USER']}
  },
  {
    path:"vouchers/:id",
    component: VoucherDetailsComponent,
    canActivate: [AuthGuardService],
    data: { roles: ['COMPANY', 'FUNDRAISER', 'USER']}
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
