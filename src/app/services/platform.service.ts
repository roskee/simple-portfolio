import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Platform } from 'src/interfaces/project';

@Injectable({
  providedIn: 'root'
})
export class PlatformService {
  apiUrl: string = "http://localhost:5000/projects/platforms";
  constructor(private http: HttpClient) { }
  getPlatforms(): Observable<Platform[]> {
    return this.http.get<Platform[]>(this.apiUrl);
  }
  getPlatform(id:number): Observable<Platform>{
    return this.http.get<Platform>(this.apiUrl + `/${id}`);
  }
}
