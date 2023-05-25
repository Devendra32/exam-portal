import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms'
import { UserService } from '../../services/user.service'
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private userService: UserService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
  }

  userForm = this.fb.group({
    id: [""],
    username: [""],
    password: [""],
    firstName: [""],
    lastName: [""],
    email: [""],
    phone: [""]
  });


  formSubmit() {
    // alert(this.userForm.value);
    // console.log(this.userForm.value);
    this.saveUser(this.userForm.value)

  }

  public saveUser(user:any){
    this.userService.addUser(user).subscribe(data => {
      console.log(data, alert("User Registered Successfully..."));
    },
    error => console.log(error));
  }

}
