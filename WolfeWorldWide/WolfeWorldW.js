window.onload = function(){
    document.getElementById('getSchedule').addEventListener
    ('click',getSchedule);

}


    function getSchedule(){
        var proxyUrl2 = 'https://cors-anywhere.herokuapp.com/',
        targetUrl2 = 'http://api.sportradar.us/nascar-t3/mc/2019/races/schedule.json?api_key=95j8gvhwcvkhkaq7wx8vkbe2';        
        axios.get(proxyUrl2 + targetUrl2)
            .then((response) => {
                let schedule = response.data.events;
                let output = '';
                $.each(schedule,(index,event)=>{
                    console.log(event);
                    output+=`
                        <div class="container">
                            <ul>
                                <li>${event.name}</li>
                                <li>${event.start_date}</li>
                            </ul>
                        </div>
                    `;
                })
                console.log(response);
                $('#output').html(output);
            })

            
    }

//     <script>
// var txt = '{"name":"John", "age":30, "city":"New York"}'
// var obj = JSON.parse(txt);
// document.getElementById("demo").innerHTML = obj.name + ", " + obj.age;
// </script>