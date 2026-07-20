// // console.log(" ----------  Bank Manegament System   -------- ");

// // /// Task 1
// // let withdraw=(balance,amount)=>
// // {
// //     console.log("Currecnt Balance is :"+balance)
// // if(balance > 500)
// // {
// //     if(amount < balance)
// //     {
// //         console.log("Withdraw Successfully :"+balance -amount)
// //     }
// //     else{
// //         console.log("You Amount is more than balance ....");
// //         }
// //     }
// //     else{
// //         console.log("   Less    Balance   .....")
// //     }
// // }
// // withdraw(600,200);

// // // Task2 
// // let ecom=(amount)=>
// // {
// //     if(amount >=900)
// //     {
// //         console.log("free of cost delivery")
// //     }
// //     else{
// //         console.log("free delivery not avilable ...")
// //     }
// // }

// // ecom(900)


// let employee=()=>
// {
//     let scan = prompt("Enter yes if Id is scanned :");
//     if(scan==1)
//     {
//         console.log("Id scanned successfully ok!!")

//     }
//     else{
//         console.log("Your id is not scanned ok !!!!")
//     }
    
// }
// employee();


// let game=(score)=>
// {
//     if(score > 1000)
//     {
//         console.log("You can enter in the next level ...");

//     }
//     else{
//         console.log("you need to boost your level ")
//     }
// }
// game(900);



// let netfilx=()=>
// {
//     let sub = prompt("if subcription is active then enter the 1 other wise 0:");
//     if(sub ==1)
//     {
//         console.log("ACTIVE ...")
//     }
//     else{
//         console.log("Not Active ...")
//     }
// }
// netfilx();



// let restorent= (bill) =>
// {
//     if(bill >2000)
//     {
//         console.log("You can won Free Dessert ok..")
//     }
//     else{
//         console.log("Better Luck Next Time ....")
//     }
// }

// restorent(2100)


// let cinema= (age) =>
// {
//     if(age <18)
//     {
//         console.log("You can eligible for this cinema")
//     }
//     else{
//         console.log("you are not eligible cinema.")
//     }
// }


// cinema(23)


// let exam= (score) =>
// {
//     if(score > 35)
//     {
//         console.log("PASS ..")
//     }
//     else{
//         console.log("FAIL ....")
//     }
// }

// exam(56)


// let company= (target) =>
// {
//     if(target == 1)
//     {
//         console.log("PASS  BONUS Done..")
//     }
//     else{
//         console.log("Target is not Completed ....")
//     }
// }

// company(1)

// let discount=()=>
// {

//     let price = Number(prompt("Enter the product price:"));

// if(price >5000)
// {
// let discount50 = price * 50 / 100;
// let final50 = price - discount50;

// console.log("50% Discount Price =", final50);
// }

// if(price > 3000 && price<5000)
// {
// let discount30 = price * 30 / 100;
// let final30 = price - discount30;

// console.log("30% Discount Price =", final30);
// }

// if(price >2000 && price <3000 )
// {
// let discount20 = price * 20 / 100;
// let final20 = price - discount20;

// console.log("20% Discount Price =", final20);
// }
// }

// discount()


// let delivery=()=>
// {
//     let dis=Number(prompt("Entr the distance "))
//     if(dis >10)
//     {
//         console.log("charges id 200")
//     }
//     else if(dis >7 && dis<10)
    
//     {
//         console.log("charges id 150")
//     }

//     else if(dis >4 && dis<7)
    
//     {
//         console.log("charges id 100")
//     }
//     else
//     {
//         console.log("Free ....")
//     }
// }
// delivery()



//// ----------------- Switch statement =======================================

// let atm = (balance, amount) => {

//     console.log("Enter 1 for Withdraw");
//     console.log("Enter 2 for Deposit");
//     console.log("Enter 3 for Display Balance");
//     console.log("Enter 4 for Exit");

//     let ch = Number(prompt("Enter your choice:"));

//     switch (ch) {

//         case 1:
//             if (amount <= balance) {
//                 balance = balance - amount;
//                 console.log("Withdraw Successful");
//                 console.log("Remaining Balance: " + balance);
//             } else {
//                 console.log("Insufficient Balance");
//             }
//             break;

//         case 2:
//             balance = balance + amount;
//             console.log("Deposit Successful");
//             console.log("Updated Balance: " + balance);
//             break;

//         case 3:
//             console.log("Balance is: " + balance);
//             break;

//         case 4:
//             console.log("Exit...");
//             break;

//         default:
//             console.log("Invalid Choice");
//     }
// }

// atm(90000, 9000);


// let oredr=()=>
// {


//     console.log("Enter 1 for pizza :")
//     console.log("Enter 2 for Burger:")
//     console.log("Enter 3 for the SAndwich :")
//     console.log("Enter 4  code drnkl :")

//     let ch=Number(prompt("Enter your choice.."))

//     switch (ch) {
//     case 1:
//         console.log("Pizzza oredred successfullt ...")
//         break;

//     case 2:
//         console.log("Burger oredred successfullt ...")
//         break;

//     case 3:
//         console.log("Sandswitch oredred successfullt ...")
//         break;

//     case 4:
//         console.log("Cold Drink oredred successfullt ...")
//         break

//     default:
//         console.log("Invalide ....")
// }
// }

// oredr()


/// -------------  for loop --------------

// let for1=()=>
// {
//     for(let i=0;i<=50;i++)
//     {
//         console.log("Employee id :"+(i+58200));
//         console.log("Salary is : 25000.00")
//     }
// }

// for1()


// let for2=()=>
// {
//     for(let i=0;i<=30;i++)
//     {
//         if(i%2==0)
//         {
//         console.log("Student id is :"+ (i+120))
//         console.log("Present...");
//         }
//         else
//         {
//         console.log("Student id is :"+ (i+120))
//         console.log("Absent ...");
//         }
//     }
// }

// for2()



// let for3=()=>
// {
//     for(let i=0;i<=30;i++)
//     {
        
//         console.log("Invoice Number is :"+ (i+1000000120))
        
//     }
// }
// for3()


// let for2=()=>
// {
//     for(let i=0;i<=30;i++)
//     {
//         if(i%2==0)
//         {
//         console.log("Student id is :"+ (i+120))
//         console.log("Present...");
//         }
//         else
//         {
//         console.log("Student id is :"+ (i+120))
//         console.log("Absent ...");
//         }
//     }
// }
// for2()


// let for2=()=>
// {
//     for(let i=1000;i<=1050;i++)
//     {
//         console.log("Employee ID :"+i);    
//     }
// }
// for2()


// let for2=()=>
// {
//     for(let i=1000;i<=1050;i++)
//     {
//         console.log("Employee ID :"+i);    
//     }
// }
// for2()



// let while1=()=>
// {
//     for(let i=1000;i<=1050;i++)
//     {
//         console.log("Employee ID :"+i);    
//     }
// }
// while1()


// let while2=()=>
// {
//     while(true)
//     {
//         let pass=Number(prompt("Enter the Password .. :"))
//         if(pass == 1234)
//         {
//             console.log("Passowrd is Matched is Successfully ok !!");
//             break;
//         }
//         else{
//             console.log("Password is Not Matched Here ok ..")
//         }

//     }
// }

// while2();


let while2=()=>
{
    while(true)
    {
        let pass=Number(prompt("Enter the Password .. :"))
        if(pass == 1234)
        {
            console.log("Passowrd is Matched is Successfully ok !!");
            break;
        }
        else{
            console.log("Password is Not Matched Here ok ..")
        }

    }
}

while2();