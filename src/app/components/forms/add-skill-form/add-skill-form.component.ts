import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Certificate, Skill } from 'src/interfaces/skill';

@Component({
  selector: 'app-add-skill-form',
  templateUrl: './add-skill-form.component.html',
  styleUrls: ['./add-skill-form.component.css']
})
export class AddSkillFormComponent implements OnInit {
  form: FormGroup = {} as FormGroup;
  certificateForm: FormGroup = {} as FormGroup;
  @Input() skill: Skill = {} as Skill;
  certificate: Certificate = {} as Certificate;
  addedCertificates: Certificate[] = [];
  certificatesValidate: boolean = true;
  onSubmitCertificateForm(): void {
    this.addedCertificates.push({
      title: this.certTitle!.value,
      date: this.certDate!.value,
      image: this.certImage!.value,
      school: this.certSchool!.value,
    });
    this.validate();
  }
  onSubmitForm(): void {
    this.skill = {
      title: this.title!.value,
      description: this.description!.value,
      since: this.since!.value,
      certificates: this.addedCertificates
    }
    console.log(this.skill);
  }
  constructor() {

  }

  ngOnInit(): void {
    if (Object.entries(this.skill).length > 0) {
      this.addedCertificates = [...this.skill.certificates];
    }
    this.validate();
    this.form = new FormGroup({
      title: new FormControl(this.skill?.title, [
        Validators.required,
        Validators.maxLength(40)
      ]),
      description: new FormControl(this.skill?.description, [
        Validators.required,
        Validators.maxLength(150)
      ]),
      since: new FormControl(this.skill?.since, [
        Validators.required,
      ]),
    });
    this.certificateForm = new FormGroup({
      certTitle: new FormControl(this.certificate.title, [
        Validators.required,
        Validators.maxLength(40)
      ]),
      certDate: new FormControl(this.certificate.date, [
        Validators.required
      ]),
      certImage: new FormControl(this.certificate.image, [
        Validators.required
      ]),
      certSchool: new FormControl(this.certificate.school, [
        Validators.required,
        Validators.maxLength(40)
      ])
    })
  }
  validate(): void {
    // if (Object.entries(this.skill).length == 0) return;
    this.certificatesValidate = this.addedCertificates.length == 0;
  }
  addCertificate(certificate: Certificate): void {
    this.skill?.certificates.push(certificate);
    this.validate();
  }
  removeCertificate(certificate: Certificate): void {
    this.skill?.certificates.splice(this.skill?.certificates.indexOf(certificate), 1);
    this.validate();
  }
  get title() { return this.form.get('title') }
  get description() { return this.form.get('description') }
  get since() { return this.form.get('since') }

  get certTitle() { return this.certificateForm.get('certTitle') }
  get certDate() { return this.certificateForm.get('certDate') }
  get certImage() { return this.certificateForm.get('certImage') }
  get certSchool() { return this.certificateForm.get('certSchool') }
}
