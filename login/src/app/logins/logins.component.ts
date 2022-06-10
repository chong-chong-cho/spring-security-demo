import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css']
})
export class LoginsComponent implements OnInit {

  validateForm!: FormGroup;
  message : String = ""

  constructor(private loginService : LoginService,private router : Router,private fb: FormBuilder) { }


  login(){
     this.loginService
     .login(this.validateForm.value.username,this.validateForm.value.password)
     .subscribe({
       next:(a: any ) => {
        console.log(a)
        if(a == "用户名或密码错误"){
          this.message = a
        }else{
          this.router.navigateByUrl("/list")
        }
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
