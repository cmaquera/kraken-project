import { Component, ChangeDetectionStrategy } from '@angular/core';

import { ApiService } from '../service/api.service';

import { lyl, ThemeVariables, StyleRenderer, ThemeRef } from '@alyle/ui';
import { STYLES as STYLES_BUTTON } from '@alyle/ui/button';

const STYLES = (theme: ThemeVariables, ref: ThemeRef) => {
  // Make sure button styles have been rendered
  ref.renderStyleSheet(STYLES_BUTTON);
  // Get selectors
  const button = ref.selectorsOf(STYLES_BUTTON);
  const { after } = theme;
  return {
    root: lyl `{
      ${button.root} {
        margin-${after}: 1em
        margin-top: .5em
        margin-bottom: .5em
      }
    }`,
    row: lyl `{
      display: flex
      flex-wrap: wrap
      margin-bottom: .5em
      align-items: center
    }`
  };
};

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  providers: [
    StyleRenderer
  ]
})
export class HomeComponent {

  readonly classes = this.sRenderer.renderSheet(STYLES, true);
  data : any;

  constructor(
    private apiService: ApiService, 
    readonly sRenderer: StyleRenderer
  ) {  }

  ngOnInit():void {
    this.llenarData();
  }

  llenarData() {
    this.apiService.getData().subscribe( data => {
      this.data = data;
      console.log(this.data);
    })
  }

}
