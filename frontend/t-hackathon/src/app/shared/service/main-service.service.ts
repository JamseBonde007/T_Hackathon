import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable, tap } from 'rxjs';
import { DataService } from 'src/app/core/service/data.service';
import { Post } from 'src/app/shared/model/post.model';
import { environment } from '../../../environments/environment';
import { Job } from '../model/job.model';
import { Publisher } from '../model/publisher.model';

@Injectable({
  providedIn: 'root',
})
export class MainService {
  apiURL = environment.restApi;

  private readonly _postSource = new BehaviorSubject<Post[]>([]);
  readonly postState$ = this._postSource.asObservable();
  // all jobs
  private readonly _jobSource = new BehaviorSubject<Job[]>([]);
  readonly jobState$ = this._jobSource.asObservable();

  //current country
  private readonly _currentPost = new BehaviorSubject<Post>(null);
  readonly currentPostState$ = this._currentPost.asObservable();

  //current user
  private readonly _currentUser = new BehaviorSubject<Publisher>(null);
  readonly currentUserState$ = this._currentUser.asObservable();

  //current user
  private readonly _likeSource = new BehaviorSubject<any>(null);
  readonly likeState$ = this._likeSource.asObservable();

  //current experts
  private readonly _expertsSource = new BehaviorSubject<any>(null);
  readonly expertsState$ = this._expertsSource.asObservable();

  setPostState(state: Post[]): void {
    this._postSource.next(state);
  }

  setExpertState(state: Publisher[]): void {
    this._expertsSource.next(state);
  }

  setJobState(state: Job[]): void {
    this._jobSource.next(state);
  }

  setCurrentUser(user: Publisher): void {
    this._currentUser.next(user);
  }

  setCurrentPost(currentPost: Post): void {
    this._currentPost.next(currentPost);
  }

  setLikeState(like: any): void {
    this._likeSource.next(like);
  }

  constructor(private readonly dataService: DataService) {}

  getUser(email: string): Observable<Publisher> {
    return this.dataService
      .get<Publisher>(
        `${this.apiURL}person/login?email=${email}&password=hackathon`
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

  getAllJobs(): Observable<Job[]> {
    return this.dataService
      .get<Job[]>(`${this.apiURL}job/find?person_id=3`)
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setJobState(res);
        })
      );
  }

  getInterestedJob(jobType: String): Observable<Job[]> {
    return this.dataService
      .get<Job[]>(`${this.apiURL}job/find?person_id=3&jobType=${jobType}`)
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setJobState(res);
        })
      );
  }

  getLikeInterested(): Observable<any> {
    return this.dataService.get<any>(
      `${this.apiURL}post/like?person_id=3&post_id=2&like=true`
    );
  }

  getAllExperts(): Observable<Publisher[]> {
    return this.dataService
      .get<Publisher[]>(`${this.apiURL}person/findExperts`)
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setExpertState(res);
        })
      );
  }

  getInterestedExperts(interests: string): Observable<Publisher[]> {
    return this.dataService
      .get<Publisher[]>(`${this.apiURL}person/findExperts?skills=${interests}`)
      .pipe(
        map((res) => {
          // console.log(res);
          return res;
        }),
        tap((res) => {
          this.setExpertState(res);
        })
      );
  }
}
