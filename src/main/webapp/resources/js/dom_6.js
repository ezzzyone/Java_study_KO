const btn = document.getElementById("btn");
const d1 = document.getElementById("d1");
const list = document.getElementById("list");
const add = document.getElementById("add");
const add2 = document.getElementById("add2");
const add3 = document.getElementById("add3");
const add4 = document.getElementById("add4");
const list2 = document.getElementById("list2");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");


btn.addEventListener("click", function(){

    d1.innerHTML='<img src="/resources/img/tiresome.jpg" alt="">'
 
})

add.addEventListener("click", function(){
        
        let li = document.createElement("li"); //<li></li> : 부모 element
        let t = document.createTextNode("TEST") //test : 자식 element
        list.append(li); //맨 아래 추가 
        li.appendChild(t);

})

add2.addEventListener("click", function(){

    let li = document.createElement("li");
    list2.prepend(li); //맨 위 추가
    
})

add3.addEventListener("click", function(){

    //체크박스 element 추가
    let input = document.createElement("input"); //<input>
    let ch = document.createAttribute("type"); //type= :속성은 부모자식관계가 아님
    ch.value="checkbox"; //type="checkbox"
    input.setAttributeNode(ch);
    d2.append(input);
})

add4.addEventListener("click", function(){

let h = document.createAttribute("h3");
let t = document.createTextNode("after");
h.appendChild(t);
d3.after(h);

})

