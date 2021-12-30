interface Image {
    title: string;
    src: string;
    description: string;
}
export interface Project {
    id?: number;
    title: string;
    short_description: string;
    github: string;
    playstore: string;
    video: string;
    images: Array<Image>;
    made_with: Array<string>;
    platforms: Array<string>;
}