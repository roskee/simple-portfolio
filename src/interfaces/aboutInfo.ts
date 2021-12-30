export interface Education {
    title: string;
    school: string;
    grade: number;
    gradeBase: number;
}
export interface Certificate {
    title: string;
    school: string;
}
export interface AboutInfo {
    name: string;
    age: number;
    nationality: string;
    residence: string;
    short_description: string;
    earlyLife: string;
    workHistory: string;
    passionAndGoal: string;
    education: Array<Education>;
    top_certificates: Array<Certificate>;
    phones: Array<string>;
    emails: Array<string>;
    github: string;
    linkedIn: string;
    calendy: string;
}