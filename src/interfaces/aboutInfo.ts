interface Education {
    title:string;
    school:string;
    grade:string;
}
interface Certificate{
    title:string;
    school:string;
}
export interface AboutInfo{
    name:string;
    age:number;
    short_description:string;
    history:string;
    education:Array<Education>;
    top_certificates:Array<Certificate>;
    phones:Array<string>;
    emails:Array<string>;
    github:string;
    linkedIn:string;
    calendy:string;
}