//const 변하지 않는 값
const d1 = document.getElementById("d1");
alert(d1.value);

const d2 = document.getElementById("d2");
d2.type="button";

const d3 = document.getElementById("d3");
let count = window.prompt("숫자를입력해봐라ㅋ");
let t=""

for(let i=0;i<count;i++){
    t=t+'<input type="text">';
} d3.innerHTML=t;


const year = document.getElementById("year");
const month = document.getElementById("month");
const date = document.getElementById("date");

for(i=2022;i>1990;i--){
   year.innerHTML+='<option>'+i+'</option>'
}

let rowcount = window.prompt("테이블 행을 입력해봐라");
let colcount = window.prompt("테이블 열을 입력해봐라");

let table ="";

for(let i=0;i<rowcount;i++){
   table += "<tr>";

    for(let y=0;y<colcount;y++){
        table+="<td>"+i+y+"</td>";

    }
    table +='</tr>'
}

d4.innerHTML = table;




