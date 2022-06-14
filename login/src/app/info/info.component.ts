import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { InfoService } from '../info.service';
import { User } from '../user';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  constructor(private router : ActivatedRoute,private infoService : InfoService) { }

  user : User = {
    id : 0,
    userName : "",
    passWord : "",
    sex : "",
    address : "",
    role : "",
  }

  ngOnInit(): void {
    this.router.params.subscribe(item=>{
     console.log("sdf");

      this.getUser(item['id'])
    })
  }

  getUser(id : String){
    this.infoService.getUser(id).subscribe({
      next:(a: any ) => {
       this.user = a
     },
     error:(err:any)=>{
       this.user.id = -1
     }
    })
  }

}
