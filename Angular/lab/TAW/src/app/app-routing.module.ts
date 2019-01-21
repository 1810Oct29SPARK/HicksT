import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProfileEditorComponent } from './profile-editor/profile-editor.component';
import { OpenCloseComponent } from './open-close/open-close.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'profile-editor', component: ProfileEditorComponent},
  {path: 'open-close', component: OpenCloseComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
