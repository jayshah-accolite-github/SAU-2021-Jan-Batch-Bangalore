function digitNotSame(digit) {
    let digitArray = Array.from(digit.toString()); 
    let i;
    for(i=1;i<digitArray.length;i++) {

        if(digitArray[i]!=digitArray[i-1])
        {
            return "NOT SAME :(";
        }
    }
    return "SAME :)";
}
console.log(digitNotSame(2222));
console.log(digitNotSame(1122));
console.log(digitNotSame(333446));
console.log(digitNotSame(11111111111));