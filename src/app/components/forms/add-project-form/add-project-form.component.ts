import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, ValidationErrors, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
import { PlatformService } from 'src/app/services/platform.service';
import { ToolsService } from 'src/app/services/tools.service';
import { Image, Platform, Project, Tool } from 'src/interfaces/project';

@Component({
  selector: 'app-add-project-form',
  templateUrl: './add-project-form.component.html',
  styleUrls: ['./add-project-form.component.css']
})
export class AddProjectFormComponent implements OnInit {
  @Input() project: Project = {} as Project;
  form: FormGroup = {} as FormGroup;
  platforms: Platform[] = [];
  platformsValidate: boolean = false;
  tools: Tool[] = [];
  toolsValidate: boolean = false;
  selectedTools: Tool[] = [];
  selectedPlatforms: Platform[] = [];
  // for form data
  addedImages!: FileList | null;
  addedVideo!: FileList | null;
  constructor(private platformService: PlatformService,
    private toolsService: ToolsService) { }
  onSubmitForm(): void {
    this.project = {
      title: this.title!.value,
      shortDescription: this.description!.value,
      github: this.github!.value,
      playstore: this.playStore!.value,
      images: this.images!.value,
      video: this.video!.value,
      platforms: this.selectedPlatforms,
      madeWith: this.selectedTools,
      featured: this.featured!.value
    }
    console.log(this.project);
  }
  imagesValueChanged(event: Event): void {
    this.addedImages = (event.currentTarget as HTMLInputElement).files;
  }
  videoValueChanged(event: Event): void {
    this.addedVideo = (event.currentTarget as HTMLInputElement).files;
  }
  ngOnInit(): void {
    if (Object.entries(this.project).length > 0) {
      this.selectedTools = this.project.madeWith;
      this.selectedPlatforms = this.project.platforms;
    }
    this.platformService.getPlatforms().subscribe((platforms) => this.platforms = platforms);
    this.toolsService.getTools().subscribe((tools) => this.tools = tools);
    this.form = new FormGroup({
      title: new FormControl(this.project.title, [
        Validators.required,
        Validators.maxLength(50)
      ]),
      description: new FormControl(this.project.shortDescription, [
        Validators.required,
        Validators.maxLength(150)
      ]),
      github: new FormControl(this.project.github, [
        Validators.required,
        Validators.pattern("www.github.com\/.+")
      ]),
      playStore: new FormControl(this.project.playstore, [
        Validators.required,
      ]),
      video: new FormControl(this.project.video, [
        Validators.required
      ]),
      images: new FormControl(this.project.images, [
        Validators.required
      ]),
      featured: new FormControl(this.project.featured)
    })
    this.validate();
  }
  selectTool(tool: Tool): void {
    if (this.selectedToolContains(tool))
      this.selectedTools.splice(this.findToolIndex(tool), 1);
    else
      this.selectedTools.push(tool);
    this.validate();
  }
  selectedToolContains(tool: Tool): boolean {
    return (this.selectedTools.find((a) => a.tool == tool.tool) != undefined);
  }
  findToolIndex(tool: Tool): number {
    return this.selectedTools.findIndex((a) => a.tool == tool.tool)
  }
  validate(): void {
    this.toolsValidate = this.selectedTools.length > 0;
    this.platformsValidate = this.selectedPlatforms.length > 0;
  }
  selectPlatform(platform: Platform): void {
    if (this.selectedPlatformContains(platform))
      this.selectedPlatforms.splice(this.findPlatformIndex(platform), 1);
    else
      this.selectedPlatforms.push(platform);
    this.validate();
  }
  selectedPlatformContains(platform: Platform): boolean {
    return this.selectedPlatforms.find((a) => a.platform == platform.platform) != undefined;
  }
  findPlatformIndex(platform: Platform): number {
    return this.selectedPlatforms.findIndex((a) => a.platform == platform.platform);
  }

  get title() { return this.form.get('title') }
  get description() { return this.form.get('description') }
  get github() { return this.form.get('github') }
  get playStore() { return this.form.get('playStore') }
  get video() { return this.form.get('video') }
  get images() { return this.form.get('images') }
  get featured() { return this.form.get('featured') }
}

