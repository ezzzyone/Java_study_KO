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

let setyear = window.prompt("년을 입력해봐라");
for(i=1990;i<=setyear;i++){
   year.innerHTML+='<option>'+i+'</option>'
}

let setmonth = window.prompt("달을 입력해봐라");
for(i=1;i<=setmonth;i++){
   month.innerHTML+='<option>'+i+'</option>'
}

let setdate = window.prompt("일을 입력해봐라");
for(i=1;i<=setdate;i++){
   date.innerHTML+='<option>'+i+'</option>'
}

let rowcount = window.prompt("테이블 행을 입력해봐라");
let colcount = window.prompt("테이블 열을 입력해봐라");
const d4 = document.getElementById("d4");
for(i=0;i<rowcount;i++){
    d4.innerHTML += '<tr>'

    for(y=0;y<colcount;y++){
        d4.innerHTML += '<td>'+"d"+'</td>'

    }
    d4.innerHTML += '</tr>'
}




