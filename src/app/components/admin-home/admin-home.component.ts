import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AboutService } from 'src/app/services/about.service';
import { ProjectsService } from 'src/app/services/projects.service';
import { Project } from 'src/interfaces/project';
import { Skill } from 'src/interfaces/skill';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  project: Project = {} as Project;
  projects: Project[] = [];
  skill: Skill = {} as Skill;
  skills: Skill[] = [];
  currentRoute: string = 'addProject';
  constructor(private projectsService: ProjectsService, private skillService: AboutService) { }

  ngOnInit(): void {
    this.projectsService.getProjects().subscribe((projects) => this.projects = projects);
    this.skillService.getSkills().subscribe((skills) => this.skills = skills);


  }
  routeTo(route: string, project?: Project): void {
    this.currentRoute = route;
    if (project != null) this.project = project;
    else this.project = {} as Project;
  }
  routeToSkill(route: string, skill?: Skill): void {
    this.currentRoute = route;
    if (skill != null) this.skill = skill;
    else this.skill = {} as Skill;
  }

}
