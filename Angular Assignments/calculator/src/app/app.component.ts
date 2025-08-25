import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CalcComponent } from './calc/calc.component';

@Component({
  selector: 'app-root',
  standalone: true,   // ✅ Needed for standalone component
  imports: [RouterOutlet, CalcComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']   // ✅ should be styleUrls (plural)
})
export class AppComponent {
  title = 'calculator';
}
