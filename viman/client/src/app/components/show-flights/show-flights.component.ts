import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../../models/flight.model';
import { FlightService } from '../../service/flight.service';

@Component({
  selector: 'app-show-flights',
  templateUrl: './show-flights.component.html',
  styleUrls: ['./show-flights.component.css']
})
export class ShowFlightsComponent implements OnInit {
  flights: Flight[];
  source: String;
  destination: String;
  fdate:String
  emptyy:number=1;
   temp:boolean;
  

  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit() {
    this.getFlights();
  }
  getFlights(){
    this.source = localStorage.getItem('from');
    this.destination = localStorage.getItem('to');
    this.fdate = localStorage.getItem('date');
    
    this.flightService.getList(this.source,this.destination,this.fdate).subscribe(data => {
      this.flights = data;
      console.log(this.flights);
      this.emptyy=this.flights.length;
    
      
      if(this.emptyy==0)
      {
        
        this.temp=false;
      }
      else{
        this.temp=true;
      }
    
      })

      
     
  }
  buynow(flight:any) {
    
    this.flightService.setFlight(flight);
    this.router.navigate(['/success']);
  }
}
