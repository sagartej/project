import { Component, OnInit } from '@angular/core';
import { FlightService } from '../../service/flight.service';
import { Router } from '@angular/router';
import { Flight } from '../../models/flight.model';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-book-mess',
  templateUrl: './book-mess.component.html',
  styleUrls: ['./book-mess.component.css']
})
export class BookMessComponent implements OnInit {
  flight: Flight;
  passForm: FormGroup;
  submitted: boolean = false;
  fname:String;
  lname:String;
  dob:String;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private flightService: FlightService) { }

  ngOnInit() {
  this.flight = this.flightService.getFlight();
  console.log(this.flight);
  
  this.passForm = this.formBuilder.group({
    fname: ['', [Validators.required]],
    lname:['',[Validators.required]],
    dob:['',[Validators.required]] 
   
   });
   
  }
  pay() {
    this.submitted=true;
    if(this.passForm.invalid){
      return;

    }
    this.fname=this.passForm.value.fname;
    this.lname=this.passForm.value.lname;
    this.dob=this.passForm.value.dob;
    localStorage.fname=this.fname;
    localStorage.lname=this.lname;
    localStorage.dob=this.dob;
    
    console.log(this.passForm.value);
    this.router.navigate(['payment']);

    
  }

}
