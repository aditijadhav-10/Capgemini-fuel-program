// console.log("========== ARITHMETIC OPERATORS ==========");

// // 1. Add two numbers
// let a = 10, b = 20;
// console.log("Sum:", a + b);


// // 2. Difference between two integers
// let x = 50, y = 23;
// console.log("Difference:", x - y);


// // 3. Multiply two decimal numbers
// let p = 4.5, q = 2.2;
// console.log("Product:", p * q);


// // 4. Divide two integers and print the quotient
// let m = 25, n = 4;
// console.log("Quotient:", Math.floor(m / n));

// // 5. Remainder when 29 is divided by 6
// console.log("Remainder:", 29 % 6);



// console.log("\n========== ASSIGNMENT OPERATORS ==========");

// // 1. Assign a value
// let num = 100;
// console.log("Assigned value:", num);

// // 2. Increase salary using +=
// let salary = 50000;
// salary += 5000;
// console.log("Increased Salary:", salary);

// // 3. Reduce stock using -=
// let stock = 200;
// stock -= 30;
// console.log("Remaining Stock:", stock);

// // 4. Multiply using *=
// let value = 10;
// value *= 5;
// console.log("After *=:", value);

// // 5. Divide using /=
// let total = 100;
// total /= 4;
// console.log("After /=:", total);



// console.log("\n========== RELATIONAL OPERATORS ==========");

// // 1. Check equal
// console.log("Are equal:", 10 == 10);

// // 2. Check different
// console.log("Are different:", 15 != 20);

// // 3. Greater of two
// let p1 = 45, q1 = 67;
// console.log("Greater number:", p1 > q1 ? p1 : q1);

// // 4. Student pass
// let marks = 55;
// console.log("Passed:", marks >= 40);

// // 5. Age >= 18
// let age = 20;
// console.log("Eligible for voting:", age >= 18);



// console.log("\n========== IF STATEMENT ==========");

// // 1. ATM withdrawal
// let balance = 800;
// if (balance > 500) console.log("ATM Withdrawal Allowed");

// // 2. Free delivery
// let order = 1200;
// if (order > 999) console.log("Free Delivery Available");

// // 3. Office entry
// let idScanned = true;
// if (idScanned) console.log("Office Entry Allowed");

// // 4. Game level
// let score = 1500;
// if (score > 1000) console.log("Next Level Unlocked");

// // 5. Netflix
// let subscriptionActive = true;
// if (subscriptionActive) console.log("Streaming Allowed");



// console.log("\n========== IF-ELSE STATEMENT ==========");

// // 1. Free dessert
// let bill = 2500;
// if (bill > 2000) console.log("Free Dessert");
// else console.log("No Dessert");

// // 2. Cinema entry
// let age2 = 16;
// if (age2 >= 18) console.log("Entry Allowed");
// else console.log("Entry Not Allowed");

// // 3. Pass/Fail
// let score2 = 35;
// if (score2 >= 40) console.log("Pass");
// else console.log("Fail");

// // 4. Bonus
// let targetCompleted = false;
// if (targetCompleted) console.log("Bonus Awarded");
// else console.log("No Bonus");

// // 5. Delivery status
// let isOnline = true;
// if (isOnline) console.log("Available");
// else console.log("Unavailable");



// console.log("\n========== ELSE-IF LADDER ==========");

// // 1. Shopping discount
// let amount = 3500;
// if (amount > 5000) console.log("20% Discount");
// else if (amount > 3000) console.log("15% Discount");
// else if (amount > 1000) console.log("10% Discount");
// else console.log("No Discount");

// // 2. Delivery fee
// let distance = 8;
// if (distance <= 3) console.log("Delivery Fee: ₹20");
// else if (distance <= 6) console.log("Delivery Fee: ₹40");
// else if (distance <= 10) console.log("Delivery Fee: ₹60");
// else console.log("Delivery Fee: ₹100");

// // 3. Cashback
// let recharge = 399;
// if (recharge >= 599) console.log("Cashback: ₹100");
// else if (recharge >= 399) console.log("Cashback: ₹50");
// else if (recharge >= 199) console.log("Cashback: ₹20");
// else console.log("No Cashback");

// // 4. Grade
// let cgpa = 8.5;
// if (cgpa >= 9) console.log("Grade: A+");
// else if (cgpa >= 8) console.log("Grade: A");
// else if (cgpa >= 7) console.log("Grade: B");
// else if (cgpa >= 6) console.log("Grade: C");
// else console.log("Grade: D");

// // 5. Electricity rate
// let units = 250;
// if (units <= 100) console.log("Rate: ₹3 per unit");
// else if (units <= 200) console.log("Rate: ₹5 per unit");
// else if (units <= 300) console.log("Rate: ₹7 per unit");
// else console.log("Rate: ₹10 per unit");



// console.log("\n========== SWITCH STATEMENT ==========");

// // 1. ATM Menu
// let choice = 2;
// switch(choice){
//     case 1: console.log("Check Balance"); break;
//     case 2: console.log("Withdraw"); break;
//     case 3: console.log("Deposit"); break;
//     case 4: console.log("Exit"); break;
//     default: console.log("Invalid Choice");
// }

// // 2. Food Ordering
// let food = 1;
// switch(food){
//     case 1: console.log("You ordered Pizza"); break;
//     case 2: console.log("You ordered Burger"); break;
//     case 3: console.log("You ordered Sandwich"); break;
//     case 4: console.log("You ordered Cold Drink"); break;
//     default: console.log("Invalid Option");
// }

// // 3. College Portal
// let option = 3;
// switch(option){
//     case 1: console.log("View Attendance"); break;
//     case 2: console.log("View Result"); break;
//     case 3: console.log("Pay Fees"); break;
//     case 4: console.log("Logout"); break;
//     default: console.log("Invalid Option");
// }

// // 4. Smart TV
// let app = 2;
// switch(app){
//     case 1: console.log("Opening Netflix"); break;
//     case 2: console.log("Opening YouTube"); break;
//     case 3: console.log("Opening Prime Video"); break;
//     case 4: console.log("Opening Settings"); break;
//     default: console.log("Invalid App");
// }

// // 5. Mobile Recharge
// let plan = 4;
// switch(plan){
//     case 1: console.log("Recharge: ₹199"); break;
//     case 2: console.log("Recharge: ₹299"); break;
//     case 3: console.log("Recharge: ₹399"); break;
//     case 4: console.log("Recharge: ₹599"); break;
//     default: console.log("Invalid Plan");
// }