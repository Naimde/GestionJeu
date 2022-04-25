import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AdminApiService } from 'src/app/api/admin-api.service';

@Component({
  selector: 'register',
  templateUrl: 'register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
    registerForm!: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private userService: AdminApiService,
    ) {
        // redirect to home if already logged in
        if (localStorage.getItem("token")) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.registerForm = this.formBuilder.group({
            email: ['', Validators.required],
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;
        console.log("envois");
        // stop here if form is invalid
        if (this.registerForm.invalid) {
            console.log("envois");

            return;
        }

        this.loading = true;
        this.userService.createUser(this.registerForm.value).subscribe(data => 
          {
            this.router.navigate(['/login']);
          });
    }
}
