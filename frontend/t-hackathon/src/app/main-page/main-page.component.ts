import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { Post } from '../shared/model/post.model';
import { Publisher } from '../shared/model/publisher.model';
import { MainService } from '../shared/service/main-service.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss'],
})
export class MainPageComponent implements OnInit {
  posts$: Observable<Post[]> = this.loginService.postState$;
  postsSubs: Subscription;

  user$: Publisher;
  userSubs: Subscription;

  constructor(private loginService: MainService, private router: Router) {}

  ngOnInit(): void {
    this.postsSubs = this.loginService.getAllPosts().subscribe();
    this.userSubs = this.loginService.currentUserState$.subscribe((user) => {
      this.user$ = user;
      console.log(user);
    });
  }

  openPostDetail() {
    this.router.navigateByUrl('/mainPage/postDetail');
  }

  onLogout() {
    this.router.navigateByUrl('/login');
    
  }
}
