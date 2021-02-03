import { Word } from './models/Word';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WordService {

  GET_ALL = "/word/getAll";
  constructor(private http:HttpClient) { }

  getAll():Observable<any>{
    return this.http.get(this.GET_ALL);
  }
  SAVE_WORD = "/word/save";

  save(payLoad: Word):Observable<any>{
    return this.http.post(this.SAVE_WORD,payLoad);
  }

  DELETE_WORD = "/word/delete/";

  delete(id: Number):Observable<any>{
    return this.http.get(this.DELETE_WORD+id);
  }
  UPDATE_WORD = "/word/update/";

  update(payLoad: Word):Observable<any>{
    return this.http.post(this.UPDATE_WORD,payLoad);
  }
  MATCHING_WORDS = "/word/getMatching/";
  getMatching(str: String):Observable<any>{
    return this.http.get(this.MATCHING_WORDS+str);
  }
}