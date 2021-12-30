import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Opinion } from 'src/interfaces/opinion';

@Injectable({
  providedIn: 'root'
})
export class OpinionService {
  private apiUrl:string = "http://localhost:5000";
  constructor(private http:HttpClient) { }
  getOpinions():Observable<Opinion[]>{
    return this.http.get<Opinion[]>(this.apiUrl+"/opinions");
  }
  getOpinionWithId(id:number):Observable<Opinion>{
    return this.http.get<Opinion>(this.apiUrl+"/opinions/"+id);
  }
}
