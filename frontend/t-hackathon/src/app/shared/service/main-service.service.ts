import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable, tap } from 'rxjs';
import { DataService } from 'src/app/core/service/data.service';
import { Post } from 'src/app/shared/model/post.model';
import { environment } from '../../../environments/environment';
import { Publisher } from '../model/publisher.model';

@Injectable({
  providedIn: 'root',
})
export class MainService {
  apiURL = environment.restApi;

  private readonly _postSource = new BehaviorSubject<Post[]>([]);
  readonly postState$ = this._postSource.asObservable();

  //current country
  private readonly _currentPost = new BehaviorSubject<Post>(null);
  readonly currentPostState$ = this._currentPost.asObservable();

  //current user
  private readonly _currentUser = new BehaviorSubject<Publisher>(null);
  readonly currentUserState$ = this._currentUser.asObservable();

  setPostState(state: Post[]): void {
    this._postSource.next(state);
  }

  setCurrentUser(user: Publisher): void {
    this._currentUser.next(user);
  }

  setCurrentPost(currentPost: Post): void {
    this._currentPost.next(currentPost);
  }

  constructor(private readonly dataService: DataService) {}

  getUser(): Observable<Publisher> {
    return this.dataService
      .get<Publisher>(
        `${this.apiURL}person/login?email=fazulka.peter@gmail.com&password=hackathon`
      )
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setCurrentUser(res);
        })
      );
  }

  getPublicPosts(): Observable<Post[]> {
    return this.dataService
      .get<Post[]>(`${this.apiURL}post/list?visibility=false&postType=true`)
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setPostState(res);
        })
      );
  }
  getAllPosts(): Observable<Post[]> {
    return this.dataService
      .get<Post[]>(`${this.apiURL}post/list?postType=true`)
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setPostState(res);
        })
      );
  }
}
