import { NgModule } from '@angular/core';
import { HomeComponent } from './home.component';
import { LyButtonModule } from '@alyle/ui/button';
import { LyIconModule } from '@alyle/ui/icon';
import { LyTypographyModule } from '@alyle/ui/typography';

@NgModule({
  imports: [
    LyButtonModule,
    LyIconModule,
    LyTypographyModule
  ],
  exports: [HomeComponent],
  declarations: [HomeComponent]
})
export class HomeModule { }