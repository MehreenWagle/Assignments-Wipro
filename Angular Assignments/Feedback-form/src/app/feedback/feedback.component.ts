import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-feedback',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule
  ],
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  feedbackForm: FormGroup;

  constructor(private fb: FormBuilder, private snackBar: MatSnackBar) {
    this.feedbackForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.minLength(4)]],
      message: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  onSubmit() {
    if (this.feedbackForm.valid) {
      console.log('✅ Feedback Submitted:', this.feedbackForm.value);
      this.snackBar.open('Feedback submitted successfully!', 'Close', {
        duration: 3000,
        panelClass: ['snackbar-success']
      });
      this.feedbackForm.reset();
    } else {
      console.log('❌ Invalid Form:', this.feedbackForm.value);
      this.snackBar.open('Please fix the errors before submitting.', 'Close', {
        duration: 3000,
      panelClass: ['snackbar-error']
      });
    }
  }
}