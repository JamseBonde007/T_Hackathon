import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { Post } from '../shared/model/post.model';
import {  MainService } from '../shared/service/main-service.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {
  posts$: Observable<Post[]> = this.loginService.postState$;

  postsSubs: Subscription;

  constructor(private loginService: MainService ) { }

  ngOnInit(): void {
    this.postsSubs = this.loginService.getAllPosts().subscribe();
  }

}
