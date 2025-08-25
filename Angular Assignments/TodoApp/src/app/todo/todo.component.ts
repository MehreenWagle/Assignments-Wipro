import { Component } from '@angular/core';

@Component({
  selector: 'app-todo',
  standalone: true,   // ✅ very important
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {}
