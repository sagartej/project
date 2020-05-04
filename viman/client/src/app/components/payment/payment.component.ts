import { Component, OnInit } from '@angular/core';
import { FlightService } from '../../service/flight.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from '../../models/flight.model';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  addForm: FormGroup;
  submitted:boolean=false;
  flight: Flight;
  amount:number;
  fee:number;
  gst:number;
  totalAmount:number;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
    
    this.flight = this.flightService.getFlight();
    console.log(this.flight);
    this.amount=this.flight.fare;
    this.fee=this.amount*0.18;
    this.gst=this.amount*0.05;
    this.totalAmount=this.amount+this.fee+this.gst;
    console.log(this.amount)
    console.log(this.totalAmount)
    this.addForm = this.formBuilder.group({
      fname: ['', [Validators.required]],
      month:['',[Validators.required]],
      year:['',[Validators.required]],
      cvv:['',[Validators.required]],
      card:['',[Validators.required]]
      
    
    
     });
  
  }

  paynow()
  {
    this.submitted=true;
    
    if(this.addForm.invalid){
      return;

    }
    this.flightService.flightBook({ flightid: this.flight.flightId, userId: localStorage.userid, fname: localStorage.fname, lname: localStorage.lname, dob: localStorage.dob }).subscribe(data => {
      console.log(data);
      alert(`Payment Successful `);
      this.router.navigate(['/profile']);

    }, err => {
      console.log(err.stack())
    })
  }
 

}
