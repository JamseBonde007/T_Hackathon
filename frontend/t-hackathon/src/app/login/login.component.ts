import { Component, OnDestroy, OnInit } from '@angular/core';
import { MainService } from '../shared/service/main-service.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { Post } from '../shared/model/post.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit, OnDestroy {
  loginForm?: FormGroup;
  userName: String;

  posts$: Observable<Post[]> = this.loginService.postState$;

  postsSubs: Subscription;

  constructor(private loginService: MainService, private router: Router) {}

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      userName: new FormControl(''),
      pass: new FormControl(''),
    });

    this.postsSubs = this.loginService.getPublicPosts().subscribe();
  }

  onClickLogin(data: any): void {
    this.router.navigateByUrl('/mainPage/allPosts');
    
  }

  ngOnDestroy(): void {
    this.postsSubs.unsubscribe();
  }
}
