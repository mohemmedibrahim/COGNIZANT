import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CourseCardComponent } from './course-card.component';
import { Course } from '../../models/course.model';

// HANDS-ON 10 Task 1
describe('CourseCardComponent', () => {

  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;

  const mockCourse: Course = {
    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        CourseCardComponent,
        HttpClientTestingModule
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    component.course = mockCourse;
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  it('should render the course name as an @Input', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    const h3 = fixture.debugElement.query(By.css('h3'))
      .nativeElement as HTMLElement;

    expect(h3.textContent).toContain('Data Structures');
  });

  it('should emit enrollRequested with the course id on Enroll click', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    spyOn(component.enrollRequested, 'emit');

    const enrollButton = fixture.debugElement.query(
      By.css('.actions button')
    ).nativeElement as HTMLButtonElement;

    enrollButton.click();
    fixture.detectChanges();

    expect(component.enrollRequested.emit)
      .toHaveBeenCalledWith(1);
  });

  it('should log previous and current value on ngOnChanges', () => {
    spyOn(console, 'log');

    component.course = mockCourse;

    component.ngOnChanges({
      course: {
        previousValue: undefined,
        currentValue: mockCourse,
        firstChange: true,
        isFirstChange: () => true,
      },
    });

    expect(console.log).toHaveBeenCalled();
  });

  it('should toggle isExpanded when Show Details is clicked', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    const detailsButton = fixture.debugElement.queryAll(
      By.css('.actions button')
    )[1].nativeElement as HTMLButtonElement;

    expect(component.isExpanded).toBeFalse();

    detailsButton.click();

    expect(component.isExpanded).toBeTrue();
  });

});