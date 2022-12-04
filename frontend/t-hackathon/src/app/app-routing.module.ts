import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AllPostsComponent } from './main-page/all-posts/all-posts.component';
import { FindExpertComponent } from './main-page/find-expert/find-expert.component';
import { FindJobComponent } from './main-page/find-job/find-job.component';
import { MainPageComponent } from './main-page/main-page.component';
import { PostDetailComponent } from './main-page/post-detail/post-detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent}, 
  {path: 'mainPage', component: MainPageComponent, 
    children: [
      {
      path: 'allPosts', component: AllPostsComponent
    },
    {
      path: 'postDetail', component: PostDetailComponent
    },
    {
      path: 'findJob', component: FindJobComponent
    },
    {
      path: 'findExpert', component: FindExpertComponent
    }
  ]   
}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
