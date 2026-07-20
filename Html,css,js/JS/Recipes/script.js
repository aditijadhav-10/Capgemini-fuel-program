let wrapper =document.getElementById('wrapper')

async function fetchData() {
    let getData=fetch('https://dummyjson.com/recipes')
    
    let res=await getData;
    let data=await res.json();
    console.log(data);

    data.map((item)=>{
        wrapper.innerHTML += `<div class="cart">
       
        </div>
        </div>`  
    })

}

fetchData()

