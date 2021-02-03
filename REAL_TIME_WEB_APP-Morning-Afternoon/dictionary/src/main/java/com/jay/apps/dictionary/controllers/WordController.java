package com.jay.apps.dictionary.controllers;

import com.jay.apps.dictionary.models.Word;
import com.jay.apps.dictionary.services.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("word")
public class WordController {

    @Autowired
    IWordService iWordService;


    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @PostMapping("/save")
    public Word save(@RequestBody Word word) {
        return iWordService.save(word);
    }
    @PostMapping("/update")
    public Word update(@RequestBody Word word) {
        return iWordService.update(word);
    }

    @GetMapping("/getAll")
    public List<Word> getAll(){
        return iWordService.getAll();
    }

    @GetMapping("/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        return iWordService.delete(id);
    }

    @GetMapping("/getMatching/{str}")
    public List<Word> getMatching(@PathVariable String str){
        return iWordService.getMatching(str);
    }


}
