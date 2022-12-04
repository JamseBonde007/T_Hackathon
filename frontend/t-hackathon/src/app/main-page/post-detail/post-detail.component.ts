import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Post } from 'src/app/shared/model/post.model';
import { MainService } from 'src/app/shared/service/main-service.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss']
})
export class PostDetailComponent implements OnInit, OnDestroy {
  currentPost$: Post ;
  currentPostSubs: Subscription;

  constructor(private mainService: MainService) { }

  ngOnInit(): void {
    this.currentPostSubs = this.mainService.currentPostState$.subscribe(post => {
      this.currentPost$ = post;
      // console.log(this.currentPost$.publisher.skills);
    })
  }

  ngOnDestroy(): void {
      this.currentPostSubs.unsubscribe();
  }

}
