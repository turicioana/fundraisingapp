import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material';
import { FlexLayoutModule } from "@angular/flex-layout";
import {MatSelectModule} from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { MaterialFileInputModule } from 'ngx-material-file-input';
import { FileUploadModule } from "ng2-file-upload";

import {ToastrModule} from 'ngx-toastr';
import {InterceptorService} from './interceptor.service';
import {UserService} from './authentication/user.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './authentication/login/login.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './authentication/register/register.component';
import { AuthComponent } from './authentication/auth/auth.component';
import { FundraiserComponent } from './all-of-fundraiser/fundraiser/fundraiser.component';
import { HeaderComponent } from './shared/header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CategoryComponent } from './category/category.component';
import { FundraiserFormComponent } from './all-of-fundraiser/fundraiser-form/fundraiser-form.component';
import { CompanyFormComponent } from './company-form/company-form.component';
import { FundraiserDetailsComponent } from './all-of-fundraiser/fundraiser-details/fundraiser-details.component';
import { VoucherFormComponent } from './all-of-voucher/voucher-form/voucher-form.component';
import { VoucherComponent } from './all-of-voucher/voucher/voucher.component';
import { VoucherDetailsComponent } from './all-of-voucher/voucher-details/voucher-details.component';
import { DonationFormComponent } from './donation-form/donation-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    AuthComponent,
    FundraiserComponent,
    HeaderComponent,
    DashboardComponent,
    CategoryComponent,
    FundraiserFormComponent,
    CompanyFormComponent,
    FundraiserDetailsComponent,
    VoucherFormComponent,
    VoucherComponent,
    VoucherDetailsComponent,
    DonationFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    MatCardModule,
    MatIconModule,
    FlexLayoutModule,
    MatSelectModule,
    FormsModule, 
    ReactiveFormsModule,
    MatInputModule, 
    MatFormFieldModule, 
    MatButtonModule,
    MaterialFileInputModule,
    FileUploadModule
  ],
  providers: [
    UserService,
    { provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
