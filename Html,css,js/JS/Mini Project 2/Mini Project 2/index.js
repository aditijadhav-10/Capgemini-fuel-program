let wrapper = document.getElementById("wrapper");

async function fetchData() {
    const res = await fetch("https://dummyjson.com/recipes");
    const data = await res.json();

    data.recipes.forEach((item) => {
        wrapper.innerHTML += `
            <div class="stock">
            <img src=${item.image} height="500px" width="600px"/>
            <div class="information">

                <h1>${item.name.slice(0, 30)}</h1>
                
                <h3>Ingredients</h3>
                <p>${item.ingredients.join(", ")}</p>

                <h3>Instructions</h3>
                <p>${item.instructions.join("<br>")}</p>
            
                </div>
            </div>
        `;
    });
}

fetchData();

/*
                <h3>prepTimeMinutes</h3>
                <p>${item.prepTimeMinutes}</p>

                <h3>cookTimeMinutes</h3>
                <p>${item.cookTimeMinutes}</p>

                <h3>servings</h3>
                <p>${item.servings}</p>

                <h3>difficulty</h3>
                <p>${item.difficulty}</p>

                <h3>cuisine</h3>
                <p>${item.cuisine}</p>

                <h3>caloriesPerServing</h3>
                <p>${item.caloriesPerServing}</p>

                <h3>tags</h3>
                <p>${item.tags.join(", ")}</p>

                <h3>cuisine</h3>
                <p>${item.cuisine}</p>
*/