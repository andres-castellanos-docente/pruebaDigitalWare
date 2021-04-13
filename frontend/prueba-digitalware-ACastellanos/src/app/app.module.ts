import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ServiceWorkerModule} from '@angular/service-worker';
import {environment} from '../environments/environment';
import {AppTopBarComponent} from './appBase/topbar/app.topbar.component';
import {AppBreadCrumbComponent} from './appBase/breadcrumb/app.breadcrumb.component';
import {AppMenuComponent, AppSubMenuComponent} from './appBase/menu/app.menu.component';
import {AppFooterComponent} from './appBase/footer/app.footer.component';
import {AppprincComponent} from './appBase/princ/appprinc.component';
import {AppCargandoComponent} from './appBase/cargando/app.cargando.component';
import {SharedModule} from './SharedModule';
import {LoginComponent} from './formas/login';
import {HomeGuard, LoginGuard} from './guards';
import {BlankComponent} from './formas/blank';
import {XsegundoService} from './appBase/breadcrumb/xsegundo.service';
import {AppCargandoService} from './appBase/cargando/app.cargando.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {HttpConfigInterceptor} from './interceptors/httpconfig.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    AppCargandoComponent,
    AppTopBarComponent,
    AppBreadCrumbComponent,
    AppMenuComponent,
    AppSubMenuComponent,
    AppFooterComponent,
    AppprincComponent,
    LoginComponent,
    BlankComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      // Register the ServiceWorker as soon as the app is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    }),
    SharedModule
  ],
  providers: [LoginGuard, HomeGuard, XsegundoService, AppCargandoService, {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpConfigInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
