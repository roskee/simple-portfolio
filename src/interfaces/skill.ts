export interface Certificate {
    id?: number,
    title: string;
    date: Date;
    image: string;
    topCertificate?: boolean;
    school: string;
}
export interface Skill {
    title: string;
    since: number;
    description: string;
    certificates: Array<Certificate>;
}