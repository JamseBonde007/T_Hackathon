import { Component, Input, OnInit } from '@angular/core';
import { Post } from '../model/post.model';

@Component({
  selector: 'app-post-preview',
  templateUrl: './post-preview.component.html',
  styleUrls: ['./post-preview.component.scss'],
})
export class LoginPostComponent implements OnInit {
  @Input() post: Post;
  constructor() {}

  ngOnInit(): void {}
}
