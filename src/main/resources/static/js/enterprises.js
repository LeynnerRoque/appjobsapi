// $(document).ready(function(){
//     $("button").click(function(){
//         $("p").hide();
//     });
// });

    const consume = new XMLHttpRequest();
    const url = "http://localhost:8080/enterprise/api/all";
    consume.open("GET", url);
    consume.send();


consume.onload = function (){
        if (consume.status === 200){

            data = JSON.parse(consume.responseText)

            console.log(data)
            data.forEach(function (item){
                $("#enterprises").append('<tr><td>'+item.foundationName+'</td></tr>')
            })
        }
    }






