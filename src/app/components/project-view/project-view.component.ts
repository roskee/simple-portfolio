import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProjectsService } from 'src/app/services/projects.service';
import { Project } from 'src/interfaces/project';

@Component({
  selector: 'app-project-view',
  templateUrl: './project-view.component.html',
  styleUrls: ['./project-view.component.css']
})
export class ProjectViewComponent implements OnInit {
  project:Project={ } as Project;
  projectId:number = -1;
  constructor(private route:ActivatedRoute ,private projectService:ProjectsService) { }

  ngOnInit(): void {
    this.route.params.subscribe((params)=>{
      this.projectService.getProjectWithId(params['id']).subscribe((project)=>(this.project = project));
    });
  }

}
