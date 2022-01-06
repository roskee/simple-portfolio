export interface Certificate {
    title: string;
    date: Date;
    image: string;
}
export interface Skill {
    title: string;
    since: number;
    description: string;
    certificates: Array<Certificate>;
}