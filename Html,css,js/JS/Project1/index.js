let wrapper =document.getElementById('wrapper')

async function fetchData() {
    let getData=fetch('https://fakestoreapi.com/products')
    
    let res=await getData;
    let data=await res.json();
    console.log(data);

    data.map((item)=>{
        wrapper.innerHTML += `<div class="cart">
        <img src=${item.image}
        height="300px" width="200px" />
        <h1>${item.title.slice(0,20)}</h1>
        <h2>$ ${item.price}</h2>
        <div>
        <button class="btn-buy">Buy now</button>
        <button class="btn-add">Add to cart</button>
        </div>
        </div>`  
    })

}

fetchData()

