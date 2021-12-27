import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ButtonComponent } from './components/button/button.component';
import { ProjectCardComponent } from './components/project-card/project-card.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectListComponent } from './components/project-list/project-list.component';
import { SkillsComponent } from './components/skills/skills.component';
import { AboutCardComponent } from './components/about-card/about-card.component';
import { AboutPageComponent } from './components/about-page/about-page.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProjectsPageComponent } from './components/projects-page/projects-page.component';
import { ProjectViewComponent } from './components/project-view/project-view.component';
import { OpinionsPageComponent } from './components/opinions-page/opinions-page.component';
import { SearchViewComponent } from './components/search-view/search-view.component';
import { SkillsPageComponent } from './components/skills-page/skills-page.component';

const appRoutes: Routes = [
  {
    path:'',component:HomeComponent
  },
  {
    path:'about',component:AboutPageComponent
  }
]
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ButtonComponent,
    ProjectCardComponent,
    ProjectListComponent,
    SkillsComponent,
    AboutCardComponent,
    AboutPageComponent,
    HomeComponent,
    ProjectsPageComponent,
    ProjectViewComponent,
    OpinionsPageComponent,
    SearchViewComponent,
    SkillsPageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,RouterModule.forRoot(appRoutes,{enableTracing:true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
