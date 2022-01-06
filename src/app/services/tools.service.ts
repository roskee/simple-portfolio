import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tool } from 'src/interfaces/project';

@Injectable({
  providedIn: 'root'
})
export class ToolsService {
  apiUrl: string = "http://localhost:5000/tools";
  constructor(private http: HttpClient) {
    
  }
  getTools(): Observable<Tool[]>{
    return this.http.get<Tool[]>(this.apiUrl);
  }
}
