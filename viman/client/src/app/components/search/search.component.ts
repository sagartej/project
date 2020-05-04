import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router) {

   }

   ngOnInit() {
    
      this.searchForm = this.formBuilder.group({
        from: ['', [Validators.required, Validators.pattern("[a-z]{2,30}")]],
        to:['',[Validators.required, Validators.pattern("[a-z]{2,30}")]],
        date:['',[Validators.required]] 
    
       });
    }
    
  
  searchPlane(){
    this.submitted=true;
    if(this.searchForm.invalid){
      return;

    }
    localStorage.from=this.searchForm.value.from;
      localStorage.to=this.searchForm.value.to;
      localStorage.date=this.searchForm.value.date;
    console.log(this.searchForm.value);
    this.router.navigate(['showflights']);
    
 
  }

}
