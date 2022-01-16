import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { timer } from 'rxjs';
import { OpinionService } from 'src/app/services/opinion.service';
import { Opinion } from 'src/interfaces/opinion';

@Component({
  selector: 'app-add-opinion-form',
  templateUrl: './add-opinion-form.component.html',
  styleUrls: ['./add-opinion-form.component.css']
})
export class AddOpinionFormComponent implements OnInit {
  @Input() opinion: Opinion = {} as Opinion;
  form: FormGroup = {} as FormGroup;
  saved: boolean = false;
  error: boolean = false;
  constructor(private opinionService: OpinionService) { }
  onSubmitForm(): void {
    if (Object.entries(this.opinion).length <= 0) {
      this.opinion = {
        title: this.title!.value,
        content: this.content!.value,
        date: new Date(Date.now())
      };
      this.opinionService.postOpinion(this.opinion).subscribe({
        next: response => {
          if (response.ok) {
            this.saved = true;
            this.form.reset();
            setInterval(() => {
              this.saved = false;
            }, 3000);
          } else {
            this.error = true;
            setInterval(() => {
              this.error = false;
            }, 3000)
          }
        },
        error: error => {
          this.error = true;
          setInterval(() => {
            this.error = false;
          }, 3000)
        }
      });
    } else {
      this.opinionService.updateOpinion(this.opinion.id!, this.title!.value, this.content!.value).subscribe({
        next: response => {
          if (response.ok) {
            this.saved = true;
            this.form.reset();
            setInterval(() => {
              this.saved = false;
            }, 3000);
          } else {
            this.error = true;
            setInterval(() => {
              this.error = false;
            }, 3000)
          }
        },
        error: error => {
          this.error = true;
          setInterval(() => {
            this.error = false;
          }, 3000)
        }
      });
    }
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
