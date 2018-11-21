window.onload = function(){
    document.getElementById('getSchedule').addEventListener('click',getSchedule);
    document.getElementById('getSchedule2').addEventListener('click',getSchedule2);
    document.getElementById('getSchedule3').addEventListener('click',getSchedule3);
    
    document.getElementById('getMovie').addEventListener('click',getMovie);
}

function getMovie(){
    
        
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
                        <div >
                            <table >
                                    <thead>
                                        <th id="nas-li">${event.name}</th>
                                    </thead>
                                    <tbody>
                                        
                                        <td id="nas-li">${event.start_date}</td>
                                    </tbody>
                            </table>
                        </div>
                    `;
                })
                console.log(response);
                $('#output').html(output);
            })

            
    }

    function getSchedule2(){
        var proxyUrl2 = 'https://cors-anywhere.herokuapp.com/',
        targetUrl2 = 'http://api.sportradar.us/nascar-t3/xf/2019/races/schedule.json?api_key=95j8gvhwcvkhkaq7wx8vkbe2';        
        axios.get(proxyUrl2 + targetUrl2)
            .then((response) => {
                let schedule = response.data.events;
                let output = '';
                $.each(schedule,(index,event)=>{
                    console.log(event);
                    output+=`
                        <div id="nas-li">
                            <table>
                                    <thead>
                                        <th id="nas-li">${event.name}</th>
                                    </thead>
                                    <tbody>
                                        <td id="nas-li">${event.start_date}</td>
                                    </tbody>
                            </table>
                        </div>
                    `;
                })
                console.log(response);
                $('#output').html(output);
            })

            
    }

    function getSchedule3(){
        var proxyUrl2 = 'https://cors-anywhere.herokuapp.com/',
        targetUrl2 = 'http://api.sportradar.us/nascar-t3/cw/2019/races/schedule.json?api_key=95j8gvhwcvkhkaq7wx8vkbe2';        
        axios.get(proxyUrl2 + targetUrl2)
            .then((response) => {
                let schedule = response.data.events;
                let output = '';
                $.each(schedule,(index,event)=>{
                    console.log(event);
                    output+=`
                        <div id="nas-li">
                            <table>
                                    <thead>
                                        <th id="nas-li">${event.name}</th>
                                    </thead>
                                    <tbody>
                                        <td id="nas-li">${event.start_date}</td>
                                    </tbody>
                            </table>
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