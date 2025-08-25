

import { Routes } from '@angular/router';
import { FeedbackComponent } from './feedback/feedback.component';

export const routes: Routes = [
  { path: '', redirectTo: 'feedback', pathMatch: 'full' },
  { path: 'feedback', component: FeedbackComponent }
];
