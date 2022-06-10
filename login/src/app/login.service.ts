import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { User } from './user';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient : HttpClient) { }

  login(username:string,password:string) :any{
    var params= new HttpParams().append("username",username).append("password",password)
    return this.httpClient.post<User>('/api/user/login',params)
  }
}



export interface ILoginData {
  msg: string
}