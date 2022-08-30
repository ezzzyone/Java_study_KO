const btn1 = document.getElementById("btn1");
const form1 = document.getElementById("form1")
const id = document.getElementById("userName");
const pw = document.getElementById("exampleInputPassword1");
const d1 = document.getElementById("d1");

btn1.addEventListener("click", function(){

    let u = id.value;
    let p = pw.value;
    console.log(u.length); 

    
    
    if(p.length=0){
        d1.innerHTML='비밀번호를 입력하세요ㅋ'
        return;
    }else if(u.length=0){
        d1.innerHTML='아이디를 입력하세요ㅋ'
    return; }
        else form1.submit();
});


