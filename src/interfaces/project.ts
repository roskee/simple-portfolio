export interface Project {
    id?:number;
    title:string;
    short_description:string;
    github:string;
    playstore:string;
    video:string;
    made_with:Array<string>;
    platforms:Array<string>;
}