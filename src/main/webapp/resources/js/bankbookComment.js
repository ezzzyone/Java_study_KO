const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");

const more = document.querySelector("#more");

const del= document.getElementsByClassName("delete");
const sel= document.getElementsByClassName("select");

let page=1;
const bookNum = commentAdd.getAttribute("data-book-num");

getCommentList(page, bookNum);

commentAdd.addEventListener("click", function(){

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
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

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
               
             if(commentList.children.length != 0){
                for(let i=0;i<commentList.children.length;)
                commentList.children[0].remove();
                page=1;
                getCommentList(page, bookNum);
             }
            }else(alert("뭔가 이상하데요?"));
        }
    }

    

 




}) //click 이벤트 끝



commentList.addEventListener("click", function(event){
 //-----------------update-------------------
 if(event.target.className == "update"){
    let check = window.confirm("수정 하고싶어??");

    // let contents = event.target.previousSibling.previousSibling.previousSibling;
    // console.log(contents);
    // let v = contents.innerHTML;
    // contents.innerHTML = "<textarea>"+v+"</textarea>";

    let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
    let writer =event.target.previousSibling.previousSibling.innerHTML;
    let num = event.target.getAttribute("data-comment-num");

    console.log(contents);
    document.querySelector("#updateContents").innerHTML=contents;
    document.querySelector("#updateWriter").value=writer;
    document.querySelector("#num").value=num;
    document.getElementById("up").click();   //수정 영역을 클릭하면 강제로 up 버튼이벤트를 발생시킴

                

 }











    //---------------------------------------------delete

    let num = event.target.getAttribute("data-comment-num");

    console.log(event.target);

    if(event.target.className=="delete"){
        let check = window.confirm("지짜 삭제할거야?")
        if(check){
        
            console.log(num);
        }

        //ajax
    //jsp전체를 호출하지 않고 부분을 가져올수있음
    //1.XMLHTTPRequst 생성
    const xhttp = new XMLHttpRequest();

    //url 준비
    xhttp.open("POST","commentDelete");

    //3.Enctype

     //요청 header 정보
     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

     //4. 요청발생 (post일 경우 파라미터 추가)
    xhttp.send("num="+num);

    //5.응답처리
    xhttp.onreadystatechange=function(){
        if(xhttp.readyState==4&&xhttp.status==200){
            let result = xhttp.responseText.trim();
            if(result==1){
                alert("삭제 성공");
                page=1;
                for(let i=0;i<commentList.children.length;){
                    commentList.children[0].remove();
                }

                getCommentList(page, bookNum);
            }else {
                alert("삭제 실패");
            }
        }
    
    }
    }


    

})

function getCommentList(page, bookNum){

    //1 xml http requset 하나 만들어줌 
    
    const xhttp = new XMLHttpRequest();
    //2. method, url

    xhttp.open("GET", "./commentList?page="+ page+"&bookNum=" + bookNum); 
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
             let result = JSON.parse(xhttp.responseText.trim());
            //  let result = document.createElement("table");
            //  let resultAttr = document.createAttribute("class");
            //  resultAttr.value="table table-dark table-striped";
            //  result.setAttributeNode(resultAttr);

            let ar = result.list; //commentpager
            let pager = result.pager; //댓글리스트

             for(let i=0; i<ar.length;i++){
                let tbody= document.createElement("tbody");
                let tr= document.createElement("tr");
                let td =document.createElement("td");
                let tdText = document.createTextNode(ar[i].contents);

                td.appendChild(tdText);

                tr.appendChild(td);

                tbody.appendChild(tr);

                td =document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);

                tr.appendChild(td);

                td =document.createElement("td");
                //dto에서 날짜 포맷변경해줌
                //다른 서버에서 밀리세컨즈 type의 날짜data 가져올때는 직접변경해줘야함 
                // const d = new Date(ar[i].regdate);
                // let year = d.getFullYear();
                // let month = d.getMonth();
                // let day = d.getDate();
                // tdText = document.createTextNode(year+"년 "+month+1+"월 "+day+"일");
                
                tdText = document.createTextNode(ar[i].regdate);
                td.appendChild(tdText);

                tr.appendChild(td);

                td =document.createElement("td");
                let tdAttr = document.createAttribute("class");
                tdAttr.value="update";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tdText = document.createTextNode("수정");
                td.appendChild(tdText);
                tr.appendChild(td);


                td =document.createElement("td");
                tdAttr = document.createAttribute("class");
                tdAttr.value="delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tdText = document.createTextNode("삭제");
                td.appendChild(tdText);
                tr.appendChild(td);


                commentList.append(tbody);

                if(page >= pager.totalPage){
                    more.classList.add("disabled");
                }else {
                    more.classList.remove("disabled");
                }
             }
             
           

            //  let t= commentList.children;
            //  if(t.length != 0){
            //     commentList.children[0].remove();
            //  }

             //commentList.append(result);
             
            //  commentList.append(result);
            //  commentList.children[0].remove();
            //  try{
            //     console.log(commentList.children);
            //     throw new Error("에러메세지");
            //  }catch(exeception){

            //  }finally{


            //  }
        }
    });


}

//------------------------냐옹 더보기! ---------------

more.addEventListener("click", function(){

    
    page++;
   
    getCommentList(page, bookNum);

    console.log(page);
  

})


//---------------------modal update button-----------------------

const update = document.querySelector("#update");
update.addEventListener("click", function(){

    console.log("업데이트 하이하이")

    let num = document.getElementById("num").value;
    let contents = document.querySelector("#updateContents").value;



    //modal에서 num, contents 
 //ajax
    //jsp전체를 호출하지 않고 부분을 가져올수있음
    //1.XMLHTTPRequst 생성
    const xhttp = new XMLHttpRequest();

    //url 준비
    xhttp.open("POST","commentUpdate");

    //3.Enctype

     //요청 header 정보
     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

     //4. 요청발생 (post일 경우 파라미터 추가)
    xhttp.send("num="+num+"&contents="+contents);

    //5.응답처리
    xhttp.onreadystatechange=function(){
        if(xhttp.readyState==4&&xhttp.status==200){
            let result = xhttp.responseText.trim();
            
            if(result>0){
            alert("댓글 수정 성공!!");
            
                page=1;
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }

                getCommentList(page, bookNum);
            }else{
                alert("댓글 수정 실패..")
            }
        }
    }
    })




