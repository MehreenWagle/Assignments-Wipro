import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calc',
  standalone: true,   // ✅ important for standalone
  imports: [FormsModule],   // ✅ add FormsModule so ngModel works
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css']
})
export class CalcComponent {
  num1: number = 0;
  num2: number = 0;
  result: number | null = null;

  add() {
    this.result = this.num1 + this.num2;
  }

  subtract() {
    this.result = this.num1 - this.num2;
  }

  multiply() {
    this.result = this.num1 * this.num2;
  }

  divide() {
    this.result = this.num2 !== 0 ? this.num1 / this.num2 : NaN;
  }
}
