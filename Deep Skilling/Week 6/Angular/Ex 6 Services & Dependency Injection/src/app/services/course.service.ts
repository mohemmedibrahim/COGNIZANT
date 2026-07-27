import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Course } from '../models/course.model';

// HANDS-ON 6 Task 1 Step 58
@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS102', credits: 4, gradeStatus: 'pending' },
    { id: 3, name: 'Database Systems', code: 'CS103', credits: 3, gradeStatus: 'failed' },
    { id: 4, name: 'Computer Networks', code: 'CS104', credits: 3, gradeStatus: 'pending' },
    { id: 5, name: 'Web Technologies', code: 'CS105', credits: 2, gradeStatus: 'passed' },
  ];

  getCourses(): Observable<Course[]> {
    return of(this.courses);
  }

  getCourseById(id: number): Observable<Course | undefined> {
    return of(this.courses.find((c) => c.id === id));
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }
}