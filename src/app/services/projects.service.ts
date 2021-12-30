import { Injectable } from '@angular/core';
import { Project } from 'src/interfaces/project';
import { Observable,of } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  private apiUrl:string = 'http://localhost:5000/projects';
  constructor(private http:HttpClient) { }
  getProjects():Observable<Project[]>{
    return this.http.get<Project[]>(this.apiUrl);
  }
  getProjectWithId(id:number):Observable<Project>{
    return this.http.get<Project>(this.apiUrl+`/${id}`)
  }
}
