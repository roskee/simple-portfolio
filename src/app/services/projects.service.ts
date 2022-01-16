import { Injectable } from '@angular/core';
import { Project } from 'src/interfaces/project';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  private apiUrl: string = 'http://localhost:5000/projects';
  constructor(private http: HttpClient) { }
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(this.apiUrl);
  }
  getFeaturedProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(this.apiUrl + "?featured=true");
  }
  getProjectWithId(id: number): Observable<Project> {
    return this.http.get<Project>(this.apiUrl + `/${id}`)
  }
  postProject(project: Project): Observable<Project> {
    var formData = new FormData();
    formData.append("title", project.title);
    formData.append("shortDescription", project.shortDescription),
      formData.append("github", project.github);
    formData.append("playStore", project.playstore),
      formData.append("platforms", JSON.stringify(project.platforms)),
      formData.append("tools", JSON.stringify(project.madeWith));
    formData.append("images", JSON.stringify(project.images))
    formData.append("video", project.video);
    formData.append("featured", JSON.stringify(project.featured))

    return this.http.post<Project>(this.apiUrl, project, {
      headers: new HttpHeaders({
        'Content-Type':'multipart/form-data'
      })
    });
  }
}
