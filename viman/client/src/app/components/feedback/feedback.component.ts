import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  addForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      feed: ['', [Validators.required ]]
    });
  }


submitf(){
  this.submitted=true;
  if(this.addForm.invalid){
    return;

  }
  alert(`You've submitted sucessfully`);
  this.router.navigate(['profile']);
  

}
}
