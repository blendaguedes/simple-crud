import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FindTranslatorComponent} from './find-translator/find-translator.component';


const routes: Routes = [
  { path: '', component: FindTranslatorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
