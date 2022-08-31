function logincheck(){
const btn1 = document.getElementById("btn1");
const form1 = document.getElementById("form1")
const id = document.getElementById("userName");
const pw = document.getElementById("exampleInputPassword1");
const d1 = document.getElementById("d1");

btn1.addEventListener("click", function(){

    let u = id.value;
    let p = pw.value;
    console.log(u.length); 


    if(p.length==0){
        d1.innerHTML='비밀번호를 입력하세요ㅋ'
        return;
    }else if(u.length==0){
        d1.innerHTML='아이디를 입력하세요ㅋ'
    return; 
    }
    
    if(p.length>0 && u.length>0){form1.submit();}
});

}

function check(){

    const all = document.getElementById("all");
    const cb = document.getElementsByClassName("cb");
    const req = document.getElementsByClassName("req");
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");



    join.addEventListener("click", function(){

        let result =true;
        for(let j=0;j<req.length;j++){
            if(!req[j].checked){
                result = false;
                break;
            }
        }

        if (result){
            frm.submit();
        }else{
            alert("필수 약관동의하삼")
        }
            
    })


    all.addEventListener("click", function(){
    
        
            for(let i=0;i<cb.length;i++){
                cb[i].checked=all.checked;
            }
        })

    for(let i=0;i<i.length;i++){
        
        cb[i].addEventListener("click", function(){
            let result =true;
            for(let j=0;j<cb.length;j++){
                if(!cb[j].checked){
                    result = false;
                    break;
                }
            }
                all.checked=result;
        });
    }





}
