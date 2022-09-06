const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");

getCommentList();

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
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result); //json형태로 변경
            writer.value="";
            contents.value="";
            

            if(result.result == 1){
                alert("댓글 성공 야호!");
            }else(alert("뭔가 이상하데요?"));
        }
    }




}) //click 이벤트 끝

function getCommentList(){

    //1 xml http requset 하나 만들어줌 
    
    cosnt xhttp = new XMLHttpRequest();

    //2. method, url

    xhttp.open("GET","./commentList?page=1");
    
    //3.요청 전송
    xhttp.send();

    //4.응답 처리
    xhttp.addEventListener("readystatechange", function(){

        if(this.readyState==4&&this.status==200){

            console.log(this.responseText);
        }
    })


}