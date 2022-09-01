const addfiles = document.getElementById("addfiles");
const btn = document.getElementById("btn");


let count = 0;
let idx=0;

btn.addEventListener("click", function(event){
    
    count++;
    idx++;

    if(count>5){
        alert("최대 5개까지 첨부가 가능합니다 ^^")
        return;
    }
    

    //div
    let d = document.createElement("div");
    let c = document.createAttribute("class");
    c.value ="mb-3";
    d.setAttributeNode(c);
    c = document.createAttribute("id");
    c.value ="file"+idx;

    d.setAttributeNode(c);
    
    
    //lable


    let l = document.createElement("lable");
    let f = document.createAttribute("for");
    f.value="files";
    l.setAttributeNode(f);

    let c2 = document.createAttribute("class");
    c2.value ="form-label";
    l.setAttributeNode(c2);

    let t = document.createTextNode("Photos");
    l.appendChild(t);

    
    d.appendChild(l); //자식추가

    //input

 

    let i = document.createElement("input");

    let ty = document.createAttribute("type");
    ty.value="file";
    i.setAttributeNode(ty);

    let n = document.createAttribute("name");
    n.value="files";
    i.setAttributeNode(n);

    let idd = document.createAttribute("id");
    idd.value="files";
    i.setAttributeNode(idd);

    let c3 = document.createAttribute("class");
    c3.value ="form-control";
    i.setAttributeNode(c3);

    d.appendChild(i); //자식추가

       //delete
       let b = document.createElement("button");

       let ty2 = document.createAttribute("type");
       ty2.value="button";
       b.setAttributeNode(ty2);
       
       let t2 = document.createTextNode("삭제");
        b.appendChild(t2);
   
       let c4 = document.createAttribute("class");
       c4.value ="del btn btn-danger";
       b.setAttributeNode(c4);

       c4 = document.createAttribute("title");
       c4.value =idx;
       b.setAttributeNode(c4);
   
       d.appendChild(b); //자식추가


    addfiles.append(d);

    

})

addfiles.addEventListener("click", function(event){

    if(event.target.classList[0]=='del'){
        alert(event.target.innerHTML);
    }

       // let v = event.target.title;
    })

        
        

  

    


    





