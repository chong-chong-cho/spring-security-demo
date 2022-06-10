import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserListService {
  constructor(private httpClient : HttpClient) { }

  list() :any{
    return this.httpClient.get<User>('/api/user/list')
  }
}
