import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule, FormsModule}from '@angular/forms' //to handle reactive forms

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './components/signup/signup.component';
import { OverviewComponent } from './components/overview/overview.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { SearchComponent } from './components/search/search.component';
import { LoginComponent } from './components/login/login.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { ShowFlightsComponent } from './components/show-flights/show-flights.component';
import { HttpClientModule } from '@angular/common/http';
import { BookMessComponent } from './components/book-mess/book-mess.component';
import { BookingsComponent } from './components/bookings/bookings.component';
import { CancelComponent } from './components/cancel/cancel.component';
import { PaymentComponent } from './components/payment/payment.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    OverviewComponent,
    UserProfileComponent,
    SearchComponent,
    LoginComponent,
    FeedbackComponent,
    ShowFlightsComponent,
    BookMessComponent,
    BookingsComponent,
    CancelComponent,
  
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
