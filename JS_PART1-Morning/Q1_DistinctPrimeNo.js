function distinctPrimeFactors(no) {
    let distFact = new Set(); 
    let div = 2;

while(no>=2){
  if(no % div == 0){
     distFact.add(div); 
     no= no/ div;
  }
  else{
    div++;
  }     
}
return distFact;
}
console.log(distinctPrimeFactors(2));
console.log(distinctPrimeFactors(49));
console.log(distinctPrimeFactors(50));
console.log(distinctPrimeFactors(100));
console.log(distinctPrimeFactors(101));

