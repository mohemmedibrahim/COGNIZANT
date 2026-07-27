import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  CourseCardComponent,
  Course
} from '../../components/course-card/course-card.component';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
})
export class CourseListComponent implements OnInit {

  isLoading = true;

  courses: Course[] = [
    {
      id: 1,
      name: 'Data Structures',
      code: 'CS101',
      credits: 4,
      gradeStatus: 'passed'
    },
    {
      id: 2,
      name: 'Operating Systems',
      code: 'CS102',
      credits: 4,
      gradeStatus: 'pending'
    },
    {
      id: 3,
      name: 'Database Systems',
      code: 'CS103',
      credits: 3,
      gradeStatus: 'failed'
    },
    {
      id: 4,
      name: 'Computer Networks',
      code: 'CS104',
      credits: 3,
      gradeStatus: 'pending'
    },
    {
      id: 5,
      name: 'Web Technologies',
      code: 'CS105',
      credits: 2