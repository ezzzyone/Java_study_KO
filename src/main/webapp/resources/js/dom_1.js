console.log("dom_1 js파일");

let result = window.confirm("확인?");
console.log(result);

let result1 = window.prompt("확인?");
console.log(result1);
// d1.innerHTML='<h1>'+result+'</h1>'
d1.innerText='<h1>'+result+'</h1>'

//id별 텍스트와 html소스 가져오기
let d2 = document.getElementById("d2");
console.log(d2.innerHTML);
console.log(d2.innerText);

//id d4 html가져오기
let d3 = document.getElementById("d3");
let d4 = document.getElementById("d4");
d4.innerHTML = d3.innerHTML;

