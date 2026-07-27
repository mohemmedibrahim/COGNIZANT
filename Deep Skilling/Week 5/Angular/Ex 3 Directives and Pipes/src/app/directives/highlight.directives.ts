import { Directive, HostListener, Input, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {

  @Input() appHighlight = 'yellow';

  constructor(private el: ElementRef<HTMLElement>) {}

  @HostListener('mouseenter')
  onEnter(): void {
    this.el.nativeElement.style.backgroundColor =
      this.appHighlight || 'yellow';
  }

  @HostListener('mouseleave')
  onLeave(): void {
    this.el.nativeElement.style.backgroundColor = '';
  }
}