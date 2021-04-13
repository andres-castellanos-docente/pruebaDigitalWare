import {Component, Injectable, OnInit} from '@angular/core';
import {derAIzAnimation, messagesAnimation, subirAnimation} from '../../animations/listanim.animations';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AppCargandoService} from '../../appBase/cargando/app.cargando.service';
import {LoginService} from '../../services/login.service';
import {LoginModel} from '../../models/login.model';
import {Router} from '@angular/router';
import {LoginResponse} from '../../responses/listResponses';


@Component({
  templateUrl: './login.component.html', styleUrls: ['./login.scss'],
  animations: [subirAnimation, derAIzAnimation, messagesAnimation]
})

@Injectable()
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginSubmited: boolean;
  tituloerr: string;
  messageerr: string;
  viewMessages = false;
  darken: boolean;

  constructor(private router: Router, private builder: FormBuilder, private loginService: LoginService,
              private cargServ: AppCargandoService) {

  }

  ngOnInit(): void {
    /* this.loginForm = this.builder.group({
       username: [null, [Validators.required, Validators.maxLength(255)]],
       password: [null, [Validators.required, Validators.maxLength(255)]]
     });*/
    this.loginForm = this.builder.group({
      username: ['', [Validators.required, Validators.maxLength(255)]],
      password: ['', [Validators.required, Validators.maxLength(255)]]
    });


    if (localStorage.getItem('dark') === 'S') {
      this.refrescar(true);
    } else if (localStorage.getItem('dark') === 'N') {
      this.refrescar(false);
    } else {
      const modo = window.matchMedia('(prefers-color-scheme: dark)').matches;
      this.refrescar(modo);
    }


    const mql = window.matchMedia('(prefers-color-scheme: dark)');
    mql.addEventListener('change', (e) => {
      this.refrescar(e.matches);
    });

  }

  onChange(enable: boolean): void {
    if (enable) {
      this.darken = true;
      localStorage.setItem('dark', 'S');
      this.changeStyleSheetUrl('layout-css', 'blue-dark', 'layout');
    } else {
      this.darken = false;
      localStorage.setItem('dark', 'N');
      this.changeStyleSheetUrl('layout-css', 'blue-light', 'layout');
    }
  }

  cerrarMensaje(): void {
    this.viewMessages = false;
    this.tituloerr = '';
    this.messageerr = '';
  }

  onSubmitIniciar(): void {
    this.loginSubmited = true;
    if (this.loginForm.invalid) {
      return;
    }
    const loginModelEnv = new LoginModel(this.loginForm.value);
    this.loginService.iniciarSesion(loginModelEnv).subscribe((res: Response) => {
      const response: LoginResponse = res as any;
      this.cargServ.detenCargando();
      if (response.accessToken.trim().length > 0) {
        sessionStorage.setItem('token', response.accessToken);
        this.router.navigate(['/modules/blank']);
      } else {
        alert('Ocurrio un Error al Setear el Token');
      }
    }, (err) => {
      if (err.status === 401) {
        this.viewMessages = false;
        const self = this;
        setTimeout(() => {
          self.viewMessages = true;
          self.tituloerr = 'Upps Ocurrio un Error ' + '😅';
          self.messageerr = 'Credenciales Incorrectas';
          self.loginForm.controls.password.setValue(null);
        }, 250);
      }
    });
  }

  refrescar(turnOn: boolean): void {
    if (turnOn === true) {
      this.onChange(true);
    } else {
      this.onChange(false);
    }
  }

  changeStyleSheetUrl(id, value, prefix): void {
    const element = document.getElementById(id);
    const urlTokens = element.getAttribute('href').split('/');
    urlTokens[urlTokens.length - 1] = prefix + '-' + value + '.css';
    const newURL = urlTokens.join('/');
    element.setAttribute('href', newURL);
  }
}

