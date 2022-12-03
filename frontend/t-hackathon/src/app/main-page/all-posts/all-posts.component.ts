import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { Post } from 'src/app/shared/model/post.model';
import { MainService } from 'src/app/shared/service/main-service.service';

@Component({
  selector: 'app-all-posts',
  templateUrl: './all-posts.component.html',
  styleUrls: ['./all-posts.component.scss']
})
export class AllPostsComponent implements OnInit {

  posts$: Observable<Post[]> = this.loginService.postState$;

  postsSubs: Subscription;

  constructor(private loginService: MainService, private router: Router) { }

  ngOnInit(): void {
    this.postsSubs = this.loginService.getAllPosts().subscribe();
    // console.log(this.posts$);
    
  }

  openPostDetail(){
    // console.log("ahoj");
    // this.router.navigateByUrl('/mainPage/postDetail');
  }

}
