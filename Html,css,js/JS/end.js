//? setTimeOut()

// setTimeout(() => {
//     console.log("i m asynchronous")
// },3000)

// console.log("i m synchronous")

//? featch()

// async function dummyData(){
//     let getdata= fetch('https://dummyjson.com/products')
//     let res= await getdata
//     let data = await res.json()
//     console.log(data);
// }
// dummyData()

// async function fakestoredata(){
//     let getdata= fetch('https://fakestoreapi.com/products')
//     let res= await getdata
//     let data= await res.json()
//     console.log(data)
// }
// fakestoredata()

async function mydata(){
    let getdata= fetch('./data.json')
    let res= await getdata;
    let data=await res.json()
    console.log(data)
}
mydata()

