const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
getCommentList();

commentAdd.addEventListener("click", function(){

    let booknum = commentAdd.getAttribute("data-book-num");

    let wv = writer.value;
    let cv = contents.value;

    //console.log("")

    //ajax
    //jsp전체를 호출하지 않고 부분을 가져올수있음
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
    
    const xhttp = new XMLHttpRequest();
    //2. method, url

    xhttp.open("GET", "./commentList?page=1&bookNum=" + commentAdd.getAttribute("data-book-num")); 
    //detail.jsp에서 bookNum을 받아오는게 data-bookNum이기때문에 속성을 받아오면 댓글작성한 bookNum의 댓글표가 아래 나옴
    
     //3. 요청 전송
     xhttp.send();

    //4.응답 처리
    xhttp.addEventListener("readystatechange", function(){

        if(xhttp.readyState==4&&xhttp.status==200){

            console.log(xhttp.responseText);
            // //1.jsp 사용한 결과물
            // commentList.innerHTML=xhttp.responseText.trim();

            //2.json 결과물
             let ar = JSON.parse(xhttp.responseText.trim());
             let result = document.createElement("table");
             let resultAttr = document.createAttribute("class");
             resultAttr.value="table table-dark table-striped";
             result.setAttributeNode(resultAttr);
             for(let i=0; i<ar.length;i++){
                let tr= document.createElement("tr");
                let td =document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);

                td.appendChild(tdText);

                tr.appendChild(td);

                td =document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);

                tr.appendChild(td);

                td =document.createElement("td");
                tdText = document.createTextNode(ar[i].regdate);
                td.appendChild(tdText);

                tr.appendChild(td);

                result.appendChild(tr);
             }
             commentList.append(result);

        }
    });


}