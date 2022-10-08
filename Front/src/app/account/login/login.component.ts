import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';

import { ConnectApiService } from 'src/app/api/connect-api.service';

@Component({
    selector: 'login',
    templateUrl: 'login.component.html',
    styleUrls: ['./login.component.scss']
  })
export class LoginComponent implements OnInit {
    loginForm!: UntypedFormGroup;
    returnUrl!: string;

    constructor(
        private formBuilder: UntypedFormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: ConnectApiService,
    ) {
        // redirect to home if already logged in
        if (
            localStorage.getItem("token")
            ) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    onSubmit() {
        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }
        this.authenticationService.getToken(this.loginForm.get("username")?.value, this.loginForm.get("password")?.value).subscribe(
                data => {
                    localStorage.setItem("token",data.accessToken);
                    localStorage.setItem("expiration",data.expiresAt);
                    this.router.navigate([this.returnUrl]);
                });
    }
}
