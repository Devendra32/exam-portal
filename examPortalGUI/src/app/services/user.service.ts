import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http' 
import { baseURL } from './Helper'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  //add user
  public addUser(user:any){
    return this.http.post(`${baseURL}`+"/api/user", user);
  }
}
