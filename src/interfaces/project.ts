interface Image {
    title: string;
    src: string;
    description: string;
}
interface Platform{
    platform: string;
}
interface Tool{
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
}