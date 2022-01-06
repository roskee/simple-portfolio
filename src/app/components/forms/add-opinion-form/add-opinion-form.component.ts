import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Opinion } from 'src/interfaces/opinion';

@Component({
  selector: 'app-add-opinion-form',
  templateUrl: './add-opinion-form.component.html',
  styleUrls: ['./add-opinion-form.component.css']
})
export class AddOpinionFormComponent implements OnInit {
  @Input() opinion: Opinion = {} as Opinion;
  form: FormGroup = {} as FormGroup;
  constructor() { }
  onSubmitForm(): void {
    this.opinion = {
      title: this.title!.value,
      content: this.content!.value,
      date: new Date(Date.now())
    };
  }
  ngOnInit(): void {
    this.form = new FormGroup({
      title: new FormControl(this.opinion.title, [
        Validators.required,
        Validators.maxLength(40)
      ]),
      content: new FormControl(this.opinion.content, [
        Validators.required,
      ])
    });
  }
  get title() { return this.form.get('title') };
  get content() { return this.form.get('content') }
}
