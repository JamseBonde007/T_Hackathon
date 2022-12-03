import { Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable, tap } from 'rxjs';
import { DataService } from 'src/app/core/service/data.service';
import { Post } from 'src/app/shared/model/post.model';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class MainService {
  apiURL = environment.restApi;

  private readonly _postSource = new BehaviorSubject<Post[]>([]);
  readonly postState$ = this._postSource.asObservable();

  setPostState(state: Post[]): void {
    this._postSource.next(state);
  }

  constructor(private readonly dataService: DataService) {}

  getPublicPosts(): Observable<Post[]> {
    return this.dataService.get<Post[]>(`${this.apiURL}post/list?visibility=false`).pipe(
      map((res) => {
         console.log(res);
        return res;
      }),
      tap((res) => {
        this.setPostState(res);
      })
    );
  }
}
