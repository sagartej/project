import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../../models/booking.model';
import { FlightService } from '../../service/flight.service';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {
  tickets: Booking[];
  emptyy:number=1;
  temp:boolean;

  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit() {
    this.getTickets();
  }
  getTickets(){
    this.flightService.viewTickets(localStorage.userid).subscribe(data => {
      this.tickets = data;
    console.log(this.tickets);
    this.emptyy=this.tickets.length;
    if(this.emptyy==0)
    {
      
      this.temp=false;
    }
    else{
      this.temp=true;
    }
    },
      err => {
        console.log(err.stack);
      })
  }

}
