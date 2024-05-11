import { Component } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, ValidationErrors, Validators } from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

interface IdType {

  name: String,

}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})

export class RegisterComponent {

  emailForm: FormControl;

  usernameForm: FormControl;
  passwordForm: FormControl;
  passwordRepeatForm: FormControl;
  samePassword: boolean = false;

  idTypeForm: FormControl;
  idTypes: IdType[] | undefined;
  selectedIdType: IdType | undefined;

  idForm: FormControl;

  validCredentials: boolean = false;

  matcher = new MyErrorStateMatcher();

  constructor() 
  {
    this.emailForm = new FormControl('', [Validators.required, this.noSpacesValidator, Validators.email]);

    this.usernameForm = new FormControl('', [Validators.required, this.noSpacesValidator]);
    this.passwordForm = new FormControl('', [Validators.required, this.noSpacesValidator]);
    this.passwordRepeatForm = new FormControl('', [Validators.required, this.noSpacesValidator]);

    this.idTypeForm = new FormControl('', [Validators.required]);
    this.idForm = new FormControl('', [Validators.required]);

    this.idTypes = [
      {
        name: "Cédula de ciudadanía",
      },
      {
        name: "Cédula de extranjería",
      },
      {
        name: "Número de identificación personal",
      },
    ]

    this.passwordRepeatForm.valueChanges.subscribe(()=>{
      this.samePassword = this.passwordRepeatForm.value == this.passwordForm.value
    })
  } 

  noSpacesValidator(control: FormControl): ValidationErrors | null {
    if (control.value && control.value.replace(' ','') !== control.value) {
      //console.log(`\"${control.value}\"`, control.value.trim());
      return { noSpaces: true };
    }
    return null;
  }

  onSubmit()
  { 
  }
}
