import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserListService } from '../user-list.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor(private listservice : UserListService,private router : Router) { }

  listOfData: User[] = [];

  list(){
    this.listservice.list()
    .subscribe({
      next:(a: any ) => {
       this.listOfData = a
     },
     err:(err:any) => {
       console.log(err.error.message)
     }
    })
  }

  ngOnInit(): void {
    this.list()
  }

}
