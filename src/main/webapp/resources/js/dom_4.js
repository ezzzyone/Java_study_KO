const ch = document.getElementsByClassName("ch");
const cb = document.getElementsByClassName("cb");
const all = document.getElementById("all");

// for(let i=0;i<ch.length;i++){
//     ch[i].addEventListener("click", function(){
//         alert(ch[i].value);
//     })
// }


    all.addEventListener("click", function(){

        
        if(all.checked==true){
        for(let i=0;i<cb.length;i++){
            cb[i].checked=true;
        }
    }else {
        for(let y=0;y<cb.length;y++){
            cb[y].checked=false;
        }
    }
}    
    )
