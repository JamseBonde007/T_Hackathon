import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from '../model/post.model';
import { MainService } from '../service/main-service.service';

@Component({
  selector: 'app-post-preview',
  templateUrl: './post-preview.component.html',
  styleUrls: ['./post-preview.component.scss'],
})
export class LoginPostComponent implements OnInit {
  @Input() post: Post;
  constructor(private mainService: MainService, private router: Router) {}

  ngOnInit(): void {}

  setCurrentPost(): void {
    this.mainService.setCurrentPost(this.post);
    this.router.navigateByUrl('/mainPage/postDetail');
  }

  changeLike(): void{
    const element = <HTMLElement> document.getElementsByClassName('fa-heart-o')[0];
    
    element.classList.remove("fa-heart-o"); 
    element.classList.add("fa-heart"); 

   }
  

}

