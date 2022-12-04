import { Component, OnInit } from '@angular/core';
import { CheckboxControlValueAccessor } from '@angular/forms';
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

  createPost(){
    this.nonActive(3);
    
  }
 

  home() {
    this.router.navigateByUrl('/mainPage/allPosts');
    this.nonActive(0);
   
  }

 
  findExpert() {
    this.router.navigateByUrl('/mainPage/findExpert');
    this.nonActive(1);
    
  }

  findJob() {
    this.router.navigateByUrl('/mainPage/findJob');
    this.nonActive(2);
    
  }

  nonActive(num){
    
    const box1 = document.getElementsByClassName('btn')[0];
    box1.classList.remove('active');
    if (num ==0){
      box1.classList.add('active');
    }
    const box2 = document.getElementsByClassName('btn')[1];
    box2.classList.remove('active');
    if(num ==1){
      box2.classList.add('active');
    }
    
    const box3 = document.getElementsByClassName('btn')[2];
    box3.classList.remove('active');
    if(num ==2){
      box3.classList.add('active');
    }
    const box4 = document.getElementsByClassName('btn')[3];
    
    box4.classList.remove('active');
    if(num ==3){
      box4.classList.add('active');
    }

  }
}
