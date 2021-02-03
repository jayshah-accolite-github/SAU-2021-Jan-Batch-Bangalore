
import { WordService } from "../../word.service";
import { Component, OnInit,Output, EventEmitter} from '@angular/core';
import { Word } from "src/app/models/Word";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  
  editableWord !: Word;
  wordsList: Word[]=[];
  constructor(private wordService:WordService) { }
  optionsList: any = [
    "Id",
    "Word",
    "Meaning",
    "Part Of Speech",
    "Example",
    "Last Modified Time",
  ];
  form = new FormGroup({
    sortBy: new FormControl('', Validators.required)
  })
  searchForm = new FormGroup({
    search: new FormControl('', Validators.required)
  })

  ngOnInit(): void {
    this.wordService.getAll().subscribe(resp=>{
     this.wordsList=resp;
      console.log(resp);
    });
  }
  delete(word:Word):void{
 console.log("delete");

 this.wordService.delete(word.id).subscribe(resp=>{
  if(resp==true)
  {
    console.log(resp);
  this.wordsList=this.wordsList.filter(oldWord=> word.id!=oldWord.id);
  }else{
    console.log(resp);
    
  }
 });
 
  
  }
  edit(word: Word): void {
    console.log("edit", word);
    this.editableWord = word;

  }

  updateWord($event: any): void {
    console.log($event);
    console.log("to be sent to update in backend");
    this.wordService.update($event).subscribe(resp => {
      console.log(resp);
     
     window.location.reload();
    });

}
reset() {
  this.wordService.getAll().subscribe(resp => {
    console.log(resp);
    this.wordsList = resp;
  });

}
searchMatch() {
  console.log(this.searchForm.value);
  this.wordService.getMatching(this.searchForm.value.search).subscribe(resp => {
    console.log(resp);
    if (resp) {
      this.wordsList = resp;
    }
  })
}

sort() {
  console.log(this.form.value);

  switch (this.form.value.sortBy) {
    case "Id":
      this.wordsList.sort(function (a, b) {
        return (a.id.valueOf() - b.id.valueOf());
      });
      break;
    case "Word":
      this.wordsList.sort((a, b) => a.word.localeCompare(b.word));
      break;
    case "Meaning":
      this.wordsList.sort((a, b) => a.meaning.localeCompare(b.meaning));
      break;
    case "Part Of Speech":
      this.wordsList.sort((a, b) => a.partOfSpeech.localeCompare(b.partOfSpeech));
      break;
    case "Example":
      this.wordsList.sort((a, b) => a.example.localeCompare(b.example));
      break;
    case "Last Modified Time":
      this.wordsList.sort(function (a, b) { return new Date(a.lastModifiedTm).valueOf() - new Date(b.lastModifiedTm).valueOf(); });
      break;
  }
}
}

