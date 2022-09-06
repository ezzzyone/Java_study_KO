const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");

commentAdd.addEventListener("click", function(){

    let booknum = commentAdd.getAttribute("data-book-num");

    let wv = writer.value;
    let cv = contents.value;

    //console.log("")

    //ajax
    //1.XMLHTTPRequst 생성
    const xhttp = new XMLHttpRequest();

    //url 준비
    xhttp.open("POST","./commentAdd");

    //3.Enctype

     //요청 header 정보
     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

     //4. 요청발생 (post일 경우 파라미터 추가)
    xhttp.send("bookNum="+booknum+"&writer="+wv+"&contents="+cv);

    //5.응답처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4&&this.status==200){
            let result = xhttp.responseText;
            console.log(result);

            if(result==1){
                alert("댓글 성공 야호!");
            }else(alert("뭔가 이상하데요?"));
        }
    }


})