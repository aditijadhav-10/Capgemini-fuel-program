

let color = document.getElementById("color");

let isYellow = true;

function change() {
    setInterval(() => {
        if (isYellow) {
            color.style.backgroundColor = "yellow";
        } else {
            color.style.backgroundColor = "red";
        }

        isYellow = !isYellow;
    }, 1000);
}