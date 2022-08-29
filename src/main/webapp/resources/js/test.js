alert("welcome");


//int num = 1;
var num=1;
num = 'abc';

let num2=1;

console.log(num==num2);
console.log(num===num2);

for(let i=0;i<10;i++){
    console.log(i);
}

let ar = [1, '2', 3.12, true];
console.log(ar[0]);

ar.forEach(function(v,i,ar)){
    console.log("i="+i)
    console.log("v="+v)
}