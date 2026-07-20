// console.log("object in javascript")

// //! object: it is a represntation of real world entities

// let brand="hp"

// let laptop={
//     color: 'grey',
//     model: 'G50',
//     price:85000,
//     display:'144HZ',
//     storage:"512GB",
//     [brand]:"50% discount",
//     1:"warranty",
// }
// console.log(laptop)

// //? Dot Notation
// console.log(laptop.price)
// console.log(laptop.storage)

// //? bracket Notation: key dyanamic
// console.log(laptop["color"])
// console.log(laptop[1])
// console.log(laptop[brand])

// //? keys, values, entries
// console.log(Object.keys(laptop))
// console.log(Object.values(laptop))
// console.log(Object.entries(laptop))


let data=[

    {
        ename:"Aditi",
        age:21,
        skills:["java","python","cooking"],
        address:{
            hno:423,
            street:"gondavle road",
            city:"satara",
            state:"maharashtra"
            }
    },
    {
        ename:"shruti",
        age:23,
        skills:["java","swimimg","cooking"],
        address:{
            hno:42,
            street:"yektanagar",
            city:"pune",
            state:"maharashtra"
            }
    },
    {
        ename:"sanika",
        age:26,
        skills:["sql","python","javascript"],
        address:{
            hno:25,
            street:"baramati",
            city:"pune",
            state:"maharashtra"
            }
    }
]
console.log(data.ename)

for(item of data){
    console.log(item)
}

let brand="hp"
let laptop={
    color: 'grey',
    model: 'G50',
    price:85000,
    display:'144HZ',
    storage:"512GB",
    [brand]:"50% discount",
    1:"warranty",
}
for(i in laptop){
    console.log(laptop[i])
}