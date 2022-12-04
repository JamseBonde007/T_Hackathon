import { Component, OnDestroy, OnInit } from '@angular/core';
import { MainService } from '../shared/service/main-service.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { Post } from '../shared/model/post.model';
import { Router } from '@angular/router';
import { Publisher } from '../shared/model/publisher.model';

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
  userSubs: Subscription;

  constructor(private loginService: MainService, private router: Router) {}

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      userName: new FormControl(''),
      pass: new FormControl(''),
    });

    this.postsSubs = this.loginService.getPublicPosts().subscribe();
    // console.log(this.posts$);
  }

  onClickLogin(data: any): void {
    this.userSubs = this.loginService
      .getUser(this.loginForm.value.userName)
      .subscribe();
    this.router.navigateByUrl('/mainPage/allPosts');
    // console.log(this.loginForm.value.userName);
  }

  ngOnDestroy(): void {
    this.postsSubs.unsubscribe();
  }
}
