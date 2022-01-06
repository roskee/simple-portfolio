import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProjectsService } from 'src/app/services/projects.service';
import { Project } from 'src/interfaces/project';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  project: Project = {} as Project;
  projects: Project[] = [];
  currentRoute: string = 'addProject';
  constructor(private projectsService:ProjectsService) { }

  ngOnInit(): void {
    this.projectsService.getProjects().subscribe((projects) => this.projects = projects);

    
  }
  routeTo(route: string, project?: Project): void{
    this.currentRoute = route;
    if (project != null) this.project = project;
    else this.project = {} as Project;
  }

}
