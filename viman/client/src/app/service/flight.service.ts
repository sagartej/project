import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Flight } from '../models/flight.model';
import { User } from '../models/user.model';
import { Booking } from '../models/booking.model';



@Injectable({
  providedIn: 'root'
})
export class FlightService {

  baseUrl: String ="http://localhost:9092";
  static plane :Flight;


  constructor(private http: HttpClient) { }
 


  addUser(user:User)
  {
    return this.http.post<User>(`${this.baseUrl}/addUser`,user);
  }
  verifyUser(email:String,password:string)
  {
    return this.http.get(`${this.baseUrl}/login/${email}/${password}`);
  }
  
  getList(from:String,to:String,fdate:String){
    return this.http.get<Flight[]>(`${this.baseUrl}/searchFlight/${from}/${to}/${fdate}`);
  }



  flightBook({ flightid, userId, fname, lname, dob }: { flightid: number; userId: number; fname: String; lname: String; dob: String; }){
    return this.http.get<Flight[]>(`${this.baseUrl}/book/${flightid}/${userId}/${fname}/${lname}/${dob}`);
  }
   
  setFlight(flight :Flight){
    FlightService.plane = flight;
   }
   getFlight(){
     return FlightService.plane;
   }

   viewTickets(userId:number){
    return this.http.get<Booking[]>(`${this.baseUrl}/view/${userId}`);
  }

  cancel(bookingId:number){
    return this.http.get(`${this.baseUrl}/cancel/${bookingId}`);
  }
}
