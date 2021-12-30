import { Component, OnInit } from '@angular/core';
import { ProjectsService } from 'src/app/services/projects.service';
import { Project } from 'src/interfaces/project';

@Component({
  selector: 'app-projects-page',
  templateUrl: './projects-page.component.html',
  styleUrls: ['./projects-page.component.css']
})
export class ProjectsPageComponent implements OnInit {
  projects:Project[]=[];
  constructor(private projectsService:ProjectsService) { }

  ngOnInit(): void {
    this.projectsService.getProjects().subscribe((projects)=>(this.projects = projects));
  }

}
