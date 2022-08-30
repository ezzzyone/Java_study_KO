const d1 = document.getElementById("d1");
const btn1 = document.getElementById("btn1");
d1.innerHTML='strawberries &Cigarettes';

function test(){
    alert("클릭이벤트실행");
    let result = test2(1,2);
    console.log(result);
}

function test2(num1, num2){
    let result = num1+num2;
    return result;
}

let f1 = function(){
    console.log("익명함수실행")
}
//event 적용 1
// 이름 뒤 () 작성안함
// d1.onclick =f1;

//event 적용 2
// d1.onclick = function(){
//     console.log("여기서만 사용하는 함수. click 콜백함수 실행.")
// }


// //event 적용 3 자주 사용 ㅋ
// btn1.addEventListener("click", f1);

btn1.addEventListener("click", function(){

    console.log("addEventListener 실행")
});

