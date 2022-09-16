//board_files.js

const fileAdd = document.getElementById("fileAdd");//add button
const addFiles = document.getElementById("addFiles"); // div#addFiles
const fileDelete = document.querySelectorAll(".fileDelete");//forEach 가능
//const fileDelete = document.getElementsByClassName("fileDelete");//forEach 불가능

//------------------ Update시 file Delete ----------------------------
try{
    fileDelete.forEach(function(f){
        f.addEventListener("click", function(){

            let check = window.confirm("진짜 삭제할거야8??");

            if(!check){
                return;
            }

            let fileNum = f.getAttribute("data-file-num");

            //ajax
            const xhttp = new XMLHttpRequest();

            xhttp.open("POST", "fileDelete");

            //요청 header 정보
             xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

             xhttp.send("fileNum="+fileNum);


             xhttp.onreadystatechange=function(){
                if(xhttp.readyState==4&&xhttp.status==200){
                    let result = xhttp.responseText.trim();
                    if(result==1){
                        console.log(result);
                        f.parentNode.remove();
                    }else{
                        console.log(result);
                    }
                }
            }

            

        });
    });
}catch(e){

}

// for(fi of fileDelete){
//     console.log(fi);
// }

//--------------------- Add시 file add -------------------------------


let count = 0;
let idx=0;

function setCount(c){
    if(c>=0)
    count=c;
}

try{

    fileAdd.addEventListener("click", function(){
    
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

    let button = event.target;

    if(button.classList[0]=='del'){
        document.getElementById("file"+button.title).remove();
        count--;
    }

       // let v = event.target.title;
    })
}catch(e){

}


        
        

  

    


    





