import { Component, OnInit } from '@angular/core';
import { LoginService } from './service/login-service.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

   loginForm?: FormGroup;
   userName: String;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({ 
      userName: new FormControl("Meno"), 
      pass: new FormControl("")
   }); 
  }

  onClickLogin(data: any): void {
    console.log(data.userName);
    
  }

}
