import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  providers: [NotificationService],
  template: `
    <ul>
      <li *ngFor="let m of notificationService.getAll()">
        {{ m }}
      </li>
    </ul>
  `,
})
export class NotificationComponent {

  constructor(public notificationService: NotificationService) {
    this.notificationService.push(
      'Welcome to the Student Course Portal!'
    );
  }
}