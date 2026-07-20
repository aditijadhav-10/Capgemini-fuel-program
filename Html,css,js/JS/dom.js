console.log(document)
console.log(document.body)

let heading1= document.getElementById('heading1')
console.log(heading1)

heading1.innerHTML="Batman"
heading1.style.backgroundColor="yellow"


//? Event:
//? html attribute

let change=document.getElementById('change')
console.log(change)

function dname1(){
    heading1.innerHTML="Batman"
    heading1.style.backgroundColor="red"

}
function dname2(){
    heading1.innerHTML="javascript"
    heading1.style.backgroundColor="yellow"

}