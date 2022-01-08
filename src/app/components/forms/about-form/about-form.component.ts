import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AboutService } from 'src/app/services/about.service';
import { AboutInfo, Email, Phone } from 'src/interfaces/aboutInfo';
import { Certificate } from 'src/interfaces/skill';

@Component({
  selector: 'app-about-form',
  templateUrl: './about-form.component.html',
  styleUrls: ['./about-form.component.css']
})
export class AboutFormComponent implements OnInit {
  isEditing: boolean = false;
  enableEditing() {
    if (this.isEditing = !this.isEditing)
      this.aboutForm.enable();
    else this.aboutForm.disable();
  }
  aboutForm: FormGroup = {} as FormGroup;
  certificates: Certificate[] = [];
  topCertificates: Certificate[] = [];
  @Input() aboutInfo: AboutInfo = {} as AboutInfo;
  phones: Phone[] = [];
  addPhone: Phone = {} as Phone;
  addEmail: Email = {} as Email;
  emails: Email[] = [];
  certificatesValidate: boolean = false;
  phonesValidate: boolean = false;
  emailsValidate: boolean = false;
  onSubmit(): void {
    console.log(this.aboutForm.value);
  }
  insertPhone(): void {
    this.phones.push({
      phone: this.phone!.value
    });
    this.validate();
  }
  removePhone(phone: Phone): void {
    this.phones.splice(this.phones.indexOf(phone), 1);
    this.validate();
  }
  insertEmail(): void {
    this.emails.push({ email: this.email!.value });
    this.validate();
  }
  removeEmail(email: Email): void {
    this.emails.splice(this.emails.indexOf(email), 1);
    this.validate();
  }
  constructor(private aboutService: AboutService) { }
  selectCertificate(certificate: Certificate): void {

    if (this.selectedCertificateContains(certificate))
      this.topCertificates.splice(this.findToolIndex(certificate), 1);
    else
      this.topCertificates.push(certificate);
    this.validate();

  }
  selectedCertificateContains(certificate: Certificate): boolean {
    return (this.topCertificates.find((a) => a.id == certificate.id) != undefined);
  }
  findToolIndex(certificate: Certificate): number {
    return this.topCertificates.findIndex((a) => a.id == certificate.id)
  }
  validate(): void {

    this.certificatesValidate = this.topCertificates.length > 0;
    this.phonesValidate = this.phones.length > 0;
    this.emailsValidate = this.emails.length > 0;
  }
  get name() { return this.aboutForm.get('name') }
  get age() { return this.aboutForm.get('age') }
  get nationality() { return this.aboutForm.get('nationality') }
  get residence() { return this.aboutForm.get('residence') }
  get description() { return this.aboutForm.get('description') }
  get earlyLife() { return this.aboutForm.get('earlyLife') }
  get workHistory() { return this.aboutForm.get('workHistory') }
  get passion() { return this.aboutForm.get('passion') }
  get github() { return this.aboutForm.get('github') }
  get linkedIn() { return this.aboutForm.get('linkedIn') }
  get calendly() { return this.aboutForm.get('calendly') }
  get phone() { return this.aboutForm.get('phone') }
  get email() { return this.aboutForm.get('email') }

  ngOnInit(): void {
    this.phones = this.aboutInfo.phones;
    this.emails = this.aboutInfo.emails;
    this.aboutForm = new FormGroup({
      name: new FormControl(this.aboutInfo.name, [
        Validators.required
      ]),
      age: new FormControl(this.aboutInfo.age, [
        Validators.required
      ]),
      nationality: new FormControl(this.aboutInfo.nationality, [
        Validators.required
      ]),
      residence: new FormControl(this.aboutInfo.residence, [
        Validators.required
      ]),
      description: new FormControl(this.aboutInfo.shortDescription, [
        Validators.required
      ]),
      earlyLife: new FormControl(this.aboutInfo.earlyLife, [
        Validators.required
      ]),
      workHistory: new FormControl(this.aboutInfo.workHistory, [
        Validators.required
      ]),
      passion: new FormControl(this.aboutInfo.passionAndGoal, [
        Validators.required
      ]),
      github: new FormControl(this.aboutInfo.github, [
        Validators.required
      ]),
      linkedIn: new FormControl(this.aboutInfo.linkedIn, [
        Validators.required
      ]),
      calendly: new FormControl(this.aboutInfo.calendy, [
        Validators.required
      ]),
      phone: new FormControl(this.addPhone.phone, [

        Validators.pattern("[+][1-9][0-9]+"),
        Validators.maxLength(15),
      ]),
      email: new FormControl(this.addEmail.email, [
        Validators.pattern(".+@.+[.].+"),
        Validators.maxLength(40),
      ])

    });
    // TODO: temporary
    this.aboutService.getSkills().subscribe((skills) => {
      for (let skill of skills) {
        for (let certi of skill.certificates) {
          this.certificates.push(certi);
          if (certi.topCertificate)
            this.topCertificates.push(certi);
        }
      }
      this.validate();
    });
    this.aboutForm.disable();
  }

}
