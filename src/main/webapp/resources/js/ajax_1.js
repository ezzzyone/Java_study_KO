const d1 = document.querySelector("#d1");
const v1 = document.querySelector("#v1");
const result = document.querySelector("#result");


d1.addEventListener("click", function(){
    console.log("하하하 ");
    let v = v1.value;

    //1. ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2.요청정보
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+v);

    //3.요청발생
    xhttp.send();

    //4.응답결과 처리
    xhttp.onreadystatechange = function(){
        //this는 http 객체임
        console.log(this.status);
        console.log(this.readyState);
        console.log("---------------------------------");

        if(this.readyState==4 && this.status==200){
            //console.log(this.responseText);
            let response = this.response.trim();
            response = JSON.parse(response); //문자열을 객체로 바꿈

            console.log("response.userId: "+response.userId);
            console.log("response.id: "+response.id);
            console.log("response.title: "+response.title);
            console.log("response.body: "+response.body);

            let h3 = document.createElement("h3");
            let h3_text = document.createTextNode(response.userId);
            h3.appendChild(h3_text);
            result.append(h3);

            let h3_text1 = document.createTextNode(response.title);
            h3.appendChild(h3_text1);
            result.append(h3);


            
        }
        
    }
    console.log("AJAX 발생!!!!")




})


