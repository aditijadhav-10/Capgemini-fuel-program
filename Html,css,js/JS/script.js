// ! var
//? Declaration
// var a;

// //? Iitialization
// a =20;
// console.log(a);

// //? Redeclaration
// var a;
// console.log(a);

// //? ReInitialization
// a=30;
// console.log(a);

// //!let
// //? Declaration
// let b;

// //?initialization
// b="Aditi";
// console.log(b);

// //? reDeclaration
// //let b;

// //? reinitialization
// b="praddep";
// console.log(b);

// //!const
// const c = 50;
// console.log(c);

//~ Data types
//* Primitive :- string , number. bigInt ,boolean, null,underdefined,symbol

// let ename="Aditi";
// console.log(typeof ename);

// let age=20;
// console.log(typeof age);

// let bankBalance=6777365576897897987n;
// console.log(typeof bankBalance);

// let isplaced=true;
// console.log(typeof isplaced);

// console.log(typeof null);
// console.log(typeof undefined)

// let logo=symbol("TATA");
// console.log(typeof logo);

// let a=10;
// let b=10;

// let n=Symbol(10);
// let m=Symbol(10);
// console.log(n==m);



//* Non-Primitive : Array, object, functions

// letsdata["Aditi",22,"female",true,"10-03-2004"];
// console.log(typeof sdata);

// let students=["priya",45,85,23,34,89,78];
// let students={
//     sname:"priya",
//     age:25,
//     tenth:45,
//     twelth:87,
//     bca:96,
//     mca:75,
//     bal:15
// }

// console.log(students)

// function sayHello(){
//     console.log("good Morning")
// }
// sayHello()
// console.log(typeof sayHello)

//!Hosting

// console.log(a);
// var a=20;
// console.log(a);

// //! TDZ:
// console.log(b);
// let b=30;

//! Types of function
//? named fuction: A fn which has a specific name.

// function mca(){
//     return "names fuction"
// }
// console.log(mca())

//? Anoynymouse fn:a fn without name
// (function(){
//     console.log("Anoymous fn")
// }())

//?function with Expression :storing a fn inside a variable
// let fun=function(){
//     return "i am a function with expression"
// }
// console.log(fun())
// let fun2=function abc(){
//     return "i am a function with expression fun 2"
// }
// console.log(fun2())

//? Arrow Function:it is a Advance Function
//? it will reduce the fn syntax
//? it has implicit and explicit return

//~ case 1
// let arrow = ()=>{
//     return("I am a Arrow fn")
// }
// console.log(arrow());

// //~ case 2- Implicit return
// let arrow2 = (a,b)=>(a+b);
// console.log(arrow2(5,2))

// //~ case3- Explicit return 
// let arrow3 = (a,b)=>{
//     return(a-b);
// }
// console.log(arrow(8,9))

// //~ case-4 shorter syntax
// let arrow4=a=> a*a;
//     console.log(arrow4(6));

    //? cf: callback fn: it is an a fn will become argument of an HOF
    
    
// console.log("hi")
//     let cf=(a,b)=>{
//         return(a+b);
//     }

//     //? HOF:Higher order fn: it is a function that will accept another fn as an argument
// let hof=(a,b,cf)=>{
//     return cf(a,b)
// }
// console.log(hof(8,4,cf))


let sname = (b)=> (b + "Good Morning");
let greet = (b,a)=>a(b)
console.log(greet("Aditi",sname))