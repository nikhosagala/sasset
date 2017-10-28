import {Injector, ModuleWithProviders, NgModule} from '@angular/core';
import {LoginComponent} from './login/login.component';
import {AuthRoutingModule} from './auth-routing.module';
import {AuthComponent} from './auth.component';
import {NbCardModule, NbCheckboxModule, NbLayoutModule} from '@nebular/theme';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {AuthBlockComponent} from './auth-block/auth-block.component';
import {
  NB_AUTH_INTERCEPTOR_HEADER,
  NB_AUTH_OPTIONS_TOKEN,
  NB_AUTH_PROVIDERS_TOKEN,
  NB_AUTH_TOKEN_WRAPPER_TOKEN,
  NB_AUTH_USER_OPTIONS_TOKEN,
  NbAuthOptions,
  NbAuthService,
  NbAuthSimpleToken,
  NbDummyAuthProvider,
  NbEmailPassAuthProvider,
  nbOptionsFactory,
  NbTokenService,
} from '@nebular/auth';
import {RegisterComponent} from './register/register.component';
import {LogoutComponent} from './logout/logout.component';
import {RequestPasswordComponent} from './request-password/request-password.component';
import {ResetPasswordComponent} from './reset-password/reset-password.component';


export function nbAuthServiceFactory(config: any, tokenService: NbTokenService, injector: Injector) {
  const providers = config.providers || {};

  for (const key in providers) {
    if (providers.hasOwnProperty(key)) {
      const provider = providers[key];
      const object = injector.get(provider.service);
      object.setConfig(provider.config || {});
    }
  }

  return new NbAuthService(tokenService, injector, providers);
}

@NgModule({
  imports: [
    AuthRoutingModule,
    NbCardModule,
    NbLayoutModule,
    NbCheckboxModule,
    FormsModule,
    CommonModule,
  ],
  declarations: [
    AuthComponent,
    AuthBlockComponent,
    LoginComponent,
    RegisterComponent,
    LogoutComponent,
    RequestPasswordComponent,
    ResetPasswordComponent,
  ],
})
export class AuthModule {
  static forRoot(nbAuthOptions?: NbAuthOptions): ModuleWithProviders {
    return <ModuleWithProviders> {
      ngModule: AuthModule,
      providers: [
        {provide: NB_AUTH_USER_OPTIONS_TOKEN, useValue: nbAuthOptions},
        {provide: NB_AUTH_OPTIONS_TOKEN, useFactory: nbOptionsFactory, deps: [NB_AUTH_USER_OPTIONS_TOKEN]},
        {provide: NB_AUTH_PROVIDERS_TOKEN, useValue: {}},
        {provide: NB_AUTH_TOKEN_WRAPPER_TOKEN, useClass: NbAuthSimpleToken},
        {provide: NB_AUTH_INTERCEPTOR_HEADER, useValue: 'Authorization'},
        {
          provide: NbAuthService,
          useFactory: nbAuthServiceFactory,
          deps: [NB_AUTH_OPTIONS_TOKEN, NbTokenService, Injector],
        },
        NbTokenService,
        NbDummyAuthProvider,
        NbEmailPassAuthProvider,
      ],
    };
  }
}
