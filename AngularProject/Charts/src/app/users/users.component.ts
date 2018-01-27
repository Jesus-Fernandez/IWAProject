import { Component, OnInit } from '@angular/core';
import { UsersService } from '../../services/user/users.service'

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
  providers: [UsersService]
})
export class UsersComponent implements OnInit {

  public users: any;

  constructor(private userService: UsersService) { 
  }

  ngOnInit() {
    this.userService.getUsers().subscribe(data=>{
      this.users = data;
    },
    error=>{
      console.log(error);
    }
  );
  }

}
