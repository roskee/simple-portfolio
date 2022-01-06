import { Certificate } from "./skill";

export interface Education {
    title: string;
    school: string;
    grade: number;
    gradeBase: number;
}
export interface Phone {
    phone: string;
}
export interface Email {
    email: string;
}
export interface AboutInfo {
    name: string;
    age: number;
    nationality: string;
    residence: string;
    shortDescription: string;
    earlyLife: string;
    workHistory: string;
    passionAndGoal: string;
    educations: Array<Education>;
    topCertificates: Array<Certificate>;
    phones: Array<Phone>;
    emails: Array<Email>;
    github: string;
    linkedIn: string;
    calendy: string;
}