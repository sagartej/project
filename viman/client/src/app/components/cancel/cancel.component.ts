import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from '../../models/booking.model';
import { FlightService } from '../../service/flight.service';

@Component({
  selector: 'app-cancel',
  templateUrl: './cancel.component.html',
  styleUrls: ['./cancel.component.css']
})
export class CancelComponent implements OnInit {
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
  cancel(bookId,fare) {
   // localStorage.setItem('ticketprice', ticket.price);
    this.flightService.cancel(bookId).subscribe(data=>{
      console.log(data);
      alert(`Booking Cancelled ${fare} rs. will be refunded soon!`);
      this.flightService.viewTickets(localStorage.userid).subscribe(data=>{
        this.tickets = data;
        console.log(this.tickets);
      })
    })
    

 
  }

}
