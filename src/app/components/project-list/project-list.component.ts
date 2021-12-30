import { Component, OnInit } from '@angular/core';
import { ProjectsService } from 'src/app/services/projects.service';
import { Project } from 'src/interfaces/project';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects:Project[] = [];
  constructor(private projectService: ProjectsService) { }

  ngOnInit(): void {
    this.projectService.getFeaturedProjects().subscribe((projects)=>(this.projects = projects));
  }

}
