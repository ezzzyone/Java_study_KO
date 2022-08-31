const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const d4 = document.getElementById("d4");
const d5 = document.getElementById("d5");
const sp = document.getElementById("sp");

d2.addEventListener("focus",function(){

    console.log("포커스갔다 ㅋㅋ")
})

d2.addEventListener("blur", function(){
    console.log("오늘은 블러 ㅋㅋ ")
})

//d1 3글자 이하면 다시 포커스 돌아가게

d1.addEventListener("blur", function(){

   
    let v =d1.value;
    console.log(v.length);

     if(v.length<3){
        d1.focus();
    }

})

d4.addEventListener("keyup", function(){

    let v = 1000;
    sp.innerHTML += v*1;

})

//change:값 변경될 때 이벤트 적용
d5.addEventListener("change", function(){

    console.log("select변경")

})






