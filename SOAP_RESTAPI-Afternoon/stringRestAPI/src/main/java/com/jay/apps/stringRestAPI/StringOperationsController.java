package com.jay.apps.stringRestAPI;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/string")
public class StringOperationsController {


    @GetMapping("/concat/{string1}/{string2}")
    public String generate(@PathVariable("string1")String string1
            ,@PathVariable("string2") String string2){
        return string1+" "+string2;
    }

    @GetMapping("/contains/{string1}/{string2}")
    public Boolean contains(@PathVariable("string1")String string1
            ,@PathVariable("string2") String string2){
        return string1.contains(string2);
    }

    @GetMapping("/split/{string1}")
    public String[] split(@PathVariable("string1") String string1){
        return string1.split(" ");
    }

    @GetMapping("/toLowerCase/{string1}")
    public String  toLowerCase(@PathVariable("string1")String string1){
        return string1.toLowerCase();
    }

    @GetMapping("/toUpperCase/{string1}")
    public String  toUpperCase(@PathVariable("string1")String string1){
        return string1.toUpperCase();
    }


}
