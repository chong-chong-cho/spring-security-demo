import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  constructor(private httpClient:HttpClient) { }

  getUser(id: String) : any{
    return this.httpClient.get<User>("/api/user/query/" + id)
  }
}
