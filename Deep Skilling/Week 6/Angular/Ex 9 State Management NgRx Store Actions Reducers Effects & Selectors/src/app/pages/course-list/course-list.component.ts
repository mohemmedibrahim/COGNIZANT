import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Course } from '../../models/course.model';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { loadCourses } from '../../store/course/course.actions';
import {
  selectAllCourses,
  selectCoursesLoading,
  selectCoursesError
} from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, FormsModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
})
export class CourseListComponent implements OnInit {

  private store = inject(Store);
  private router = inject(Router);

  courses$: Observable<Course[]> =
    this.store.select(selectAllCourses);

  isLoading$: Observable<boolean> =
    this.store.select(selectCoursesLoading);

  error$: Observable<string | null> =
    this.store.select(selectCoursesError);

  selectedCourseId: number | null = null;

  ngOnInit(): void {
    this.store.dispatch(loadCourses());
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;
  }

  goToDetail(courseId: number): void {
    this.router.navigate(['courses', courseId]);
  }
}