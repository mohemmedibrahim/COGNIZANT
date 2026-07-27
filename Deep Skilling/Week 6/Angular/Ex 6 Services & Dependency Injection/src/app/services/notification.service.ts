import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {

  private messages: string[] = [];

  push(msg: string): void {
    this.messages.push(msg);
  }

  getAll(): string[] {
    return this.messages;
  }
}