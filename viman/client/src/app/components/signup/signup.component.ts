import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import  {FlightService}from '../../service/flight.service'
import { MustMatch } from '../../service/match';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  addForm: FormGroup;
  submitted:boolean=false;
 

  constructor(private formBuilder: FormBuilder, private router: Router,private flightService : FlightService) {

   }

   ngOnInit() {
    
    
      this.addForm = this.formBuilder.group({
        fname: ['', [Validators.required, Validators.pattern("[a-zA-Z]{2,30}")]],
         phone:['',[Validators.required,Validators.pattern("[6-9][0-9]{9}")]],
        email:['',[Validators.required,Validators.email]], 
        password: ['', [Validators.required]],
        cpassword: ['', [Validators.required]]
      }, {
        validator: MustMatch('password', 'cpassword')
       });
    
  }
    
  
  addUser(){
    this.submitted=true;
    
    if(this.addForm.invalid){
      return;

    }
    
    console.log(this.addForm.value);

    this.flightService.addUser(this.addForm.value).subscribe(data =>{
      console.log(data);
      alert(`${this.addForm.controls.fname.value} you've registred sucessfully`);
    this.router.navigate(['login']);
    },
    err =>{
      console.log(err.stack);

    })
    
    
    
 
  }

}
