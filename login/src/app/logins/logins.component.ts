import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css']
})
export class LoginsComponent implements OnInit {

  validateForm!: FormGroup;

  constructor(private loginService : LoginService,private router : Router,private fb: FormBuilder) { }


  login(){
     this.loginService
     .login(this.validateForm.value.username,this.validateForm.value.password)
     .subscribe({
       next:(a: any ) => {
        console.log(a)
         this.router.navigateByUrl("/list")
      },
       error:(error : HttpErrorResponse) => {
         alert(error.error)
         console.log(error.error)
       }
     })
  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [true]
    });
  }

}
