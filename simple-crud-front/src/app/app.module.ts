import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {
  MatExpansionModule, MatInputModule, MatPaginatorModule, MatProgressSpinnerModule, MatSnackBar,
  MatSortModule, MatTableModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import { FindTranslatorComponent } from './find-translator/find-translator.component';

@NgModule({
  declarations: [
    AppComponent,
    FindTranslatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    BrowserModule,
    HttpClientModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    NgbPaginationModule,
    MatExpansionModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
