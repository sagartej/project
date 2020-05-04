import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import  {FlightService}from '../../service/flight.service'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted: boolean= false;

   constructor(private formBuilder: FormBuilder,private router: Router, private flightService : FlightService) { }
  //lifeCyclehook
   ngOnInit() {
      this.loginForm =this.formBuilder.group({
        email:['',Validators.required],
        password:['',Validators.required]
      });
   }
 
   verifyLogin()
   {
     this.submitted=true;
     if(this.loginForm.invalid)
     {
       return;
     }
     let username = this.loginForm.controls.email.value;
     let password= this.loginForm.controls.password.value;

     console.log(username + password);
     this.flightService.verifyUser(username,password).subscribe(data =>{
      console.log(data);
      if(data>0)
      {
     alert(`you've logged in sucessfully`);
      localStorage.userid=data;
      sessionStorage.userid=data;
    this.router.navigate(['profile']);
      }
      else{
        this.invalidLogin=true;
        return;
      }
    })
  }
    
 
 invalidLogin:boolean=false;
 }
