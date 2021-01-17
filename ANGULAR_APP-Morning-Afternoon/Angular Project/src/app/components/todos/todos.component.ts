import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TodoModel } from 'src/app/models/TodoModel';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit {

  todosList!:TodoModel[];
  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getTodos();

  }
  getTodos(){
    this.httpClient.get<any>('https://jsonplaceholder.typicode.com/todos/').subscribe(
      response => {
        console.log(response);
        this.todosList = response.slice(0,20);
      }
    );
  }
  getTodosInfo(id:string){
    this.httpClient.get<any>('https://jsonplaceholder.typicode.com/todos/'+id).subscribe(
      response => {
      
        alert("Fetch details from api:"+
        "\nId :"+response.id+
        "\nUserId :"+response.userId+
        "\nTitle :"+response.title+
        "\nCompleted :"+response.completed);
      }
    );
  }
  toggleDetails(id:number){
    this.getTodosInfo(id+"");
 
      }
}
