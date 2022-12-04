import { _isNumberValue } from '@angular/cdk/coercion';
import { PortalHostDirective } from '@angular/cdk/portal';
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

  onLikeClicked(id){
    this.mainService.getLikeInterested().subscribe();
    const like = document.getElementById(id);
    console.log(like.ariaHidden);

    if(like.ariaHidden == undefined){ 
      like.classList.remove('fa-heart-o');
      like.classList.add('fa-heart');
      const likeComp = document.getElementsByClassName(id)[0];
      let pocet=likeComp.textContent;
      let num = Number(pocet);
      num++;
      let str = String(num);
      likeComp.textContent=str;
      like.setAttribute('aria-hidden', 'false');
      like.ariaHidden = 'true'
    }
    else if(like.ariaHidden != undefined){ 
      like.classList.remove('fa-heart');
      like.classList.add('fa-heart-o');
      const likeComp = document.getElementsByClassName(id)[0];
      let pocet=likeComp.textContent;
      let num = Number(pocet);
      num--;
      let str = String(num);
      likeComp.textContent=str;
      like.setAttribute('aria-hidden', 'true');
      like.ariaHidden = undefined;
    }
    

    

  }
}
