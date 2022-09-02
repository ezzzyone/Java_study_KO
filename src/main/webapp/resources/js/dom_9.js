const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");

const btn = document.querySelector("#btn");



//parent

console.log(d1_2_1_2.parentNode);

btn.addEventListener("click", function(){
    d1_2_1_2.parentNode.parentNode.remove();
})

//child

console.log(d1.children);

console.log(d1.children[1].children[0].children[0].innerHTML);

console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML);

d1.addEventListener("click", function(){

    //li모두삭제
    //console.log(d1.children);
    d1.children[1].remove();




})