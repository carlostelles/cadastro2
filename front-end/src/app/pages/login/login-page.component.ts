import {Component, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../../shared/auth/auth.service';

@Component({
    selector: 'app-login-page',
    templateUrl: './login-page.component.html'
})

export class LoginPageComponent {

    @ViewChild('f') loginForm: NgForm;

    constructor(private router: Router,
                private route: ActivatedRoute,
                private authService: AuthService) { }

    onSubmit() {
      const form = this.loginForm.form.value;
      if (this.authService.signinUser()) {
        this.router.navigate(['']);
      }
    }
}
