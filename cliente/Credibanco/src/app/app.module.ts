import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { LibroSearchComponent } from './libro/libro-search/libro-search.component';
import { EditorialCreateComponent } from './editorial/editorial-create/editorial-create.component';
import { AutorCreateComponent } from './autor/autor-create/autor-create.component';
import { LibroCreateComponent } from './libro/libro-create/libro-create.component';


@NgModule({
  declarations: [
    AppComponent,
    LibroSearchComponent,
    EditorialCreateComponent,
    AutorCreateComponent,
    LibroCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
