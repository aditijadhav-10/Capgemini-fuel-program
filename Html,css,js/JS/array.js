//? Advance loop
let country=["france","Hinenberg","Neterland","Singapur","Swizerland","pakisthan","uganda","Austrilia"];
// console.log(country);

// //for in
// for(let i in country){
//     console.log(i)
// }
// //for of
// for(let i in country){
//     console.log(i)
// }

// //for each
// country.forEach((item, index) =>{
//     console.log(item,index)
// })


//? push
country.push("japan");

//? pop
country.pop()

//? unshift
country.unshift("USA")

//? shift
country.shift()

//indexOf
console.log(country.indexOf("Swizerland"))

//? lastIndexof
console.log(country.lastIndexOf("Swiz"))

//? join
let fullName=["aditi","jadhav"]
console.log(fullName)
console.log(fullName.join(" "))

//? map
let salary=[50000,200000,40000,500000,300000];

let updatedsalary= salary.map((Value,index)=>{
    return Value+11000
})
console.log(updatedsalary)
console.log(salary)

//filter
let data= salary.filters(s=>s <500000);
console.log(data)

//reduce.
let expence= salary.reduce(i, Value)={
   return i+Value
}
console.log(expence);