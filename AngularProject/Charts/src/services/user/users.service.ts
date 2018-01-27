import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {Observable} from 'rxjs/Observable'
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

@Injectable()
export class UsersService{

  private host = "http://localhost:9090"; 
  private users: Array<any>;

  constructor(private http: HttpClient) {
   
   }

  public getUsers():Observable<any[]>{
     return this.http.get<any[]>(this.host+"/users").do((data) =>{
       //console.log(data);
     });
  } 

}
