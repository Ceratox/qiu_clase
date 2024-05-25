import { CUSTOM_ELEMENTS_SCHEMA, Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroupDirective, NgForm, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';

import { users } from '../../../assets/users';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
}) 

export class LoginComponent {

  usernameForm: FormControl; 
  passwordForm: FormControl;

  matcher = new MyErrorStateMatcher();

  constructor(private formBuilder: FormBuilder) 
  {
    this.usernameForm = new FormControl('', [Validators.required, this.noSpacesValidator]);
    this.passwordForm = new FormControl('', [Validators.required, this.noSpacesValidator]);
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
    let foundUser = false;
    
    for (let i=0; i<users.length && !foundUser; i++)
    {
      const currentUser = users[i];

      foundUser = currentUser.username === this.usernameForm.value && currentUser.password === this.passwordForm.value
    }

    if (foundUser)
    {
      alert("Inicio de sesión exitoso.");
    }
  }
}
