const remove1 = document.getElementById("remove1");
const remove2 = document.getElementById("remove2");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d2_1 = document.getElementById("d2_1");
const rm = document.getElementsByClassName("rm");

remove1.addEventListener("click", function(){

    //자식만 지우고 부모는 남기기

    d2.remove(rm);

})