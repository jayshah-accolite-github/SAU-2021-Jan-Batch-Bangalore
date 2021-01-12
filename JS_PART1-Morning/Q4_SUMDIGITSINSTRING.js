function sumDigitString(digitString) {
    let digitStringArray = Array.from(digitString); 
    let i;
    let sum=0;
    for(i=0;i<digitStringArray.length;i++) {

       if(digitStringArray[i]>='0' && digitStringArray[i]<='9'){
        sum=sum+parseInt(digitStringArray[i]);
       }
    }
    return sum;
}
console.log(sumDigitString("my name is 1 2 4 jay 4 2 1"));
console.log(sumDigitString("hii my 1 2 adc kds 454 023i29 d "));