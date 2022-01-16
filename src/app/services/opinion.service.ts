import { HttpClient, HttpContext, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Opinion } from 'src/interfaces/opinion';

@Injectable({
  providedIn: 'root'
})
export class OpinionService {
  private apiUrl: string = "http://localhost:5000";
  constructor(private http: HttpClient) { }
  getOpinions(): Observable<Opinion[]> {
    return this.http.get<Opinion[]>(this.apiUrl + "/opinions");
  }
  getOpinionWithId(id: number): Observable<Opinion> {
    return this.http.get<Opinion>(this.apiUrl + "/opinions/" + id);
  }
  updateOpinion(id: number, title: string | null, content: string | null): Observable<HttpResponse<Opinion>> {

    var params = new HttpParams({
      fromObject: {
        title: title!,
        content: content!
      }
    });
    return this.http.post<Opinion>(this.apiUrl + "/opinions" + `/${id}`, new FormData(

    ), {
      params: params,
      observe: 'response',
    });
  }
  postOpinion(opinion: Opinion): Observable<HttpResponse<Opinion>> {
    var formData = new FormData();
    formData.append('title', opinion.title);
    formData.append('content', opinion.content);
    return this.http.post<Opinion>(this.apiUrl + "/opinions", formData, { observe: 'response' });
  }
}
