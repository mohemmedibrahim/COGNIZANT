import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges
} from '@angular/core';

export interface Course {
  id: number;
  name: string;
  code: string;
  credits: number;
  gradeStatus: 'passed' | 'failed' | 'pending';
}

@Component({
  selector: 'app-course-card',
  standalone: true,
  templateUrl: './course-card.component.html',
  styleUrls: ['./course-card.component.css'],
})
export class CourseCardComponent implements OnInit, OnChanges {

  @Input() course!: Course;

  @Output()
  enrollRequested = new EventEmitter<number>();

  ngOnInit(): void {
    console.log(
      'CourseCardComponent initialised for',
      this.course?.name
    );
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log(
        'course changed:',
        changes['course'].previousValue,
        '->',
        changes['course'].currentValue
      );
    }
  }

  onEnroll(): void {
    this.enrollRequested.emit(this.course.id);
  }
}