const result = document.getElementById("result");
const btn = document.getElementById("btn");
const count = document.getElementById("count");
const c1 =document.getElementsByClassName("c1");
const d1 = document.getElementById("d1");
const d1_1 = document.getElementById("d1_1");
const d1_1_1 = document.getElementById("d1_1_1");
const google = document.getElementById("google");

google.addEventListener("click", function(event){

    alert("go google!! !! !! !! !! !! ")
    event.preventDefault();
})

//중첩된 이벤트 자식부터 실행 =이벤트 버블링 false
d1.addEventListener("click", function(event){
    console.log(d1);
    console.log(event);
    console.log(event.currentTarget); //부모영역
    console.log(event.target); //실제로 클릭한 곳

    if(event.target.className=='buttons'){
        alert("button");
        console.log("this=",this); //this = 부모영역
        alert(event.target.innerHTML);
        }

},false)

//부모로 받은 event를 자식으로 전달 : event 위임방식
result.addEventListener("click", function(event){
    if(event.target.className=='c1'){
        alert(event.target.innerHTML);
    }




})
// d1_1.addEventListener("click", function(){
//     console.log(d1_1);
// },false)

// d1_1_1.addEventListener("click", function(event){
//     console.log(d1_1_1);
//     event.stopPropagation();
// },false)




btn.addEventListener("click", function(){

    for(let i=0;i<count.value;i++){
        let button= document.createElement("button");
        let t = document.createTextNode("CLICK"+i);
        button.appendChild(t);

        let attr = document.createAttribute("class");
        attr.value="c1";
        button.setAttributeNode(attr);

        result.append(button);



    }

    for(c of c1) {

    c1.addEventListener("click", function(){
        alert(c.innerHTML);
     
    })

}
})