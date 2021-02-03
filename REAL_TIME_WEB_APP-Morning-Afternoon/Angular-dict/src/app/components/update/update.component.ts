import { Component, Input, OnChanges, OnInit, Output,EventEmitter, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
// import * as EventEmitter from 'events';
import { Word } from 'src/app/models/Word';
import { WordService } from 'src/app/word.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit ,OnChanges{

  @Input("action") buttonLabel: any;
  @Input('editableData') editableData!: Word;
  @Output() updateWord = new EventEmitter<any>();


  wordForm!: FormGroup;
  addWordPayLoad!:Word;
  id !: Number;

  constructor(private wordService : WordService,private router: Router) {   
    }
    ngOnChanges(changes: any) {

      if (changes.editableData && changes.editableData.currentValue != changes.editableData.previousValue) {
        this.wordForm = new FormGroup({
          word: new FormControl(this.editableData.word, (Validators.required, Validators.minLength(2), Validators.maxLength(50))),
          meaning: new FormControl(this.editableData.meaning, (Validators.required, Validators.maxLength(150), Validators.minLength(10))),
          partOfSpeech: new FormControl(this.editableData.partOfSpeech, (Validators.required)),
          example: new FormControl(this.editableData.example, (Validators.required)),
        });
        this.id = this.editableData.id;
 
      }
    }

  ngOnInit(): void {
    this.wordForm=new FormGroup({
  
      word: new FormControl(null,[Validators.required,Validators.minLength(2),Validators.maxLength(50)]),
      meaning:new FormControl(null,[Validators.required,Validators.minLength(10),Validators.maxLength(150)]),
      partOfSpeech:new FormControl(null,[Validators.required]),
      example:new FormControl(null,[Validators.required]),
    });

  }
  addWord():void{

    this.addWordPayLoad=this.wordForm.value;
    this.wordService.save(this.addWordPayLoad).subscribe(resp=>{
        console.log(resp);
    });
    // this.addWordPayLoad.id = null;
    //console.log(this.addWordPayLoad)
  }
  addOrUpdateWord(): void {
    console.log("add or update word")
    console.log(this.wordForm);
    this.addWordPayLoad = this.wordForm.value;
    if (this.buttonLabel.includes("Update")) {
      console.log("in update if");
      this.updateWord.emit({
        ...this.wordForm.value,
        id: this.id,
      })
    } else {
      this.wordService.save(this.addWordPayLoad).subscribe(resp => {
        console.log(resp);
        this.router.navigate(['/home']);
      });
      
    }

  }
}
