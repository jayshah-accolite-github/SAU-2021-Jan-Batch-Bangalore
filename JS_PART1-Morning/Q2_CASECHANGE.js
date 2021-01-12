function caseChange(sentence) {
    let sentArray = Array.from(sentence); 
    let i;
    for(i=0;i<sentArray.length;i++) {

        if(sentArray[i]>='a' && sentArray[i]<='z'){
            sentArray[i]=sentArray[i].toUpperCase();
        }
        else if(sentArray[i]>='A' && sentArray[i]<='Z'){
            sentArray[i]=sentArray[i].toLowerCase();
        }else{
            //nothing just a space :(
        }
    }
return sentArray.join('');
}
console.log(caseChange("AasscGdsw adreWWWW"));
console.log(caseChange("JaY ShAh"));
console.log(caseChange("javaSCRIPT"));
