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
            cb[i].checked=all.checked;
        }
        }
}    
    )

    

    //----------------------------------------
    for(let i =0;i<cb.length;i++){
        // cb[i].addEventListener("click", function(){
        //     check(1)
        // });//매개변수를 이름있는 함수에 던질 수 없으니 임시함수 안에서 실행하여 매개변수던져야함.

        cb[i].addEventListener("click", check);


    }
    
    function check(){

        for(let i =0;i<cb.length;i++){
            if (!cb[i].checked){
                result =false;
                break;
            }
        }
        all.checked=result;
    }
