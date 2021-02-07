import {Component} from '@angular/core';
import {HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  subText = '';
  mainText = '';
  op1: number;
  op2: number;
  operator = '';
  result = '';
  answered = false;
  operatorSet = false;

  constructor(private http: HttpClient ) {
  // constructor() {
    this.op1 = 0;
    this.op2 = 0;
  }

  pressKey(key: string) {
    if (key === '/' || key === 'x' || key === '-' || key === '+') {
      const lastKey = this.mainText[this.mainText.length - 1];
      if (lastKey === '/' || lastKey === 'x' || lastKey === '-' || lastKey === '+') {
        this.operatorSet = true;
      }
      if ((this.operatorSet) || (this.mainText === '')) {
        return;
      }
      this.op1 = parseFloat(this.mainText);
      this.operator = key;
      this.operatorSet = true;
    }
    if (this.mainText.length === 10) {
      return;
    }
    this.mainText += key;
  }

  allClear() {
    this.mainText = '';
    this.subText = '';
    this.operatorSet = false;
  }

  getAnswer() {
    this.result = this.mainText;
    this.op2 = parseFloat(this.mainText.split(this.operator)[1]);
    if (this.operator === '/') {
      this.subText = this.mainText;
      this.http.post<any>("//localhost:8080/api/divide?op1=" + this.op1 + "&op2=" + this.op2, {}, ).subscribe(data => {
        this.mainText = data;
      })
      this.subText = this.result;
      if (this.mainText.length > 9) {
        this.mainText = this.mainText.substr(0, 9);
      }
    } else if (this.operator === 'x') {
      this.subText = this.mainText;
      this.http.post<any>("//localhost:8080/api/multiply?op1=" + this.op1 + "&op2=" + this.op2, {}, ).subscribe(data => {
        this.mainText = data;
      })
      this.subText = this.result;
      if (this.mainText.length > 9) {
        this.mainText = 'ERROR';
        this.subText = 'Range Exceeded';
      }
    } else if (this.operator === '-') {
      this.subText = this.mainText;
      this.http.post<any>("//localhost:8080/api/subtract?op1=" + this.op1 + "&op2=" + this.op2, {}, ).subscribe(data => {
        this.mainText = data;
      })
      this.subText = this.result;
    } else if (this.operator === '+') {
      this.subText = this.mainText;
      this.http.post<any>("//localhost:8080/api/add?op1=" + this.op1 + "&op2=" + this.op2, {}, ).subscribe(data => {
        this.mainText = data;
      })
      this.subText = this.result;
      if (this.mainText.length > 9) {
        this.mainText = 'ERROR';
        this.subText = 'Range Exceeded';
      }
    } else {
      this.subText = 'ERROR: Invalid Operation';
    }
    this.answered = true;
  }
}
