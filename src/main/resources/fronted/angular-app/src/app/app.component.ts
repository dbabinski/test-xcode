import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';
  sortNum: string = "";
  constructor(private http: HttpClient) {
  }

  onSubmit(numbers: {numbers: string, desc: string, sortedNumbers: string}) {
    let numbersToArray = numbers.numbers.split(',').map(Number);
    let json = {
      "numbers": numbersToArray,
      "order": "ASC"
    }
    this.http.post('http://localhost:8080/numbers/sort-command', json)
      .subscribe((res) => {
        this.sortNum = res.toString();
      });

  }
}
