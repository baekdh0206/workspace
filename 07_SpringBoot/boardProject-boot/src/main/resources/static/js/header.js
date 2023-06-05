// 문서가 모두 로딩된 후 수행
document.addEventListener("DOMContentLoaded", () => {

    const query = document.querySelector("#query"); // 헤더 검색창

    const searchResult = document.querySelector("#searchResult"); // 검색창 자동 완성 영역


    query.addEventListener("input", e => {

        if(query.value.trim().length > 0){ // 입력된 내용이 있을 때
            fetch("/board/headerSearch?query=" + query.value.trim())
            .then(resp => resp.json())
            .then(list => {
                console.log(list);

                if(list.length > 0){ // 검색 결과가 있을 때
                    searchResult.classList.remove("close");
                    
                    // BOARD_NO, BOARD_TITLE, READ_COUNT, BOARD_CODE, BOARD_NAME 

                    searchResult.innerHTML = ""; // 이전 검색 내역 삭제

                    for(let map of list){
                        const li = document.createElement("li");
                        li.setAttribute("path", `${map.BOARD_CODE}/${map.BOARD_NO}`);


                        const a = document.createElement("a");

                        map.BOARD_TITLE = map.BOARD_TITLE.replace(query.value, `<mark>${query.value}</mark>`);
                        map.BOARD_TITLE = `<b>${map.BOARD_TITLE}</b>`;

                        a.innerHTML = `${map.BOARD_TITLE} - ${map.BOARD_NAME}`;
                        
                        a.setAttribute("href", "#");

                        a.addEventListener("click", e => {
                            e.preventDefault();
                            
                            const path = e.currentTarget.parentElement.getAttribute("path");

                            location.href = "/board/" + path;
                            

                        });

                        li.append(a)
                        searchResult.append(li);


                    }

                }else{ // 검색 결과가 없다면
                    searchResult.classList.add("close");
                }
            })
            .catch(err => console.log(err));


        }else{ // 입력된 내용이 없을 때
            searchResult.classList.add("close");
        }


    })
    
});


document.addEventListener("click", e => {
    const elementList = document.querySelectorAll(".search-area, .search-area *");
    const searchResult = document.querySelector("#searchResult"); // 검색창 자동 완성 영역

    let flag = true;
    for(let element of elementList){

        if(element == e.target){
           
            flag = false;
            break;
        }
    }

    if(flag){
        searchResult.classList.add("close");
        // searchResult.innerHTML = ""; 
    }

});