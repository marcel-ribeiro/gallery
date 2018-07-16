import {NgModule} from '@angular/core';

import {
  MatButtonModule,
  MatCardModule,
  MatGridListModule,
  MatIconModule,
  MatProgressSpinnerModule
} from '@angular/material';

@NgModule({
  imports: [
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatGridListModule
  ],
  exports: [
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatGridListModule
  ]
})
export class MaterialModule {}
