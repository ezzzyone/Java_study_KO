const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");

btn.addEventListener("click", function(){
    console.log(d1.value);
    console.log(d2.value);
    d3.value = d1.value*1%d2.value*1;
});

btn.addEventListener("click", function(){
    btn2.click();
})