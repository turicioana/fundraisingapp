import { Component, OnInit } from '@angular/core';
import { User } from '../models/user'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  user: User = {
    email: 'pampam',
    password: 'parola',
    token: 'token'
  }

  constructor() { }

  ngOnInit() {
  }
}
