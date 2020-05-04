import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { OverviewComponent } from './components/overview/overview.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { SearchComponent } from './components/search/search.component';
import { LoginComponent } from './components/login/login.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { ShowFlightsComponent } from './components/show-flights/show-flights.component';
import { BookMessComponent } from './components/book-mess/book-mess.component';
import { BookingsComponent } from './components/bookings/bookings.component';
import { CancelComponent } from './components/cancel/cancel.component';

import { PaymentComponent } from './components/payment/payment.component';



const routes: Routes = [
  {path:'', component:OverviewComponent},
  {path:'signup', component:SignupComponent},
  {path:'profile', component:UserProfileComponent},
  {path:'search', component:SearchComponent},
  {path:'login', component:LoginComponent},
  {path:'feedback', component:FeedbackComponent},
  {path:'showflights', component:ShowFlightsComponent},
  {path:'success', component:BookMessComponent},
  {path:'bookings', component:BookingsComponent},
  {path:'cancel', component:CancelComponent},
  {path:'payment', component:PaymentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
