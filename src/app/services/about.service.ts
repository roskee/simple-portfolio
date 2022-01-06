import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AboutInfo } from 'src/interfaces/aboutInfo';
import { Company } from 'src/interfaces/company';
import { Skill, Certificate } from 'src/interfaces/skill';

@Injectable({
  providedIn: 'root'
})
export class AboutService {
  private apiUrl = "http://localhost:5000";
  constructor(private http: HttpClient) { }
  getAboutInfo(): Observable<AboutInfo> {
    return this.http.get<AboutInfo>(this.apiUrl + "/about");// /about/one
  }
  getSkills(): Observable<Skill[]> {
    return this.http.get<Skill[]>(this.apiUrl + "/skills");
  }
  getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.apiUrl + "/companies");
  }
  getTopCertificates(): Observable<Certificate[]> {
    return this.http.get<Certificate[]>(this.apiUrl + "/skills/topCertificates")
  }
}
