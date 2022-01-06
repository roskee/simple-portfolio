export interface Image {
    id: number;
    title: string;
    src: string;
    description: string;
}
export interface Platform{
    id: number;
    platform: string;
}
export interface Tool{
    id: number;
    tool: string;
}
export interface Project {
    id?: number;
    title: string;
    shortDescription: string;
    github: string;
    playstore: string;
    video: string;
    images: Array<Image>;
    madeWith: Array<Tool>;
    platforms: Array<Platform>;
    featured:boolean
}