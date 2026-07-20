let click=document.getElementById('click')

function showForm(){
    console.log('showForm')
    click.classList.add('showForm')
}
function closeForm(){
    click.classList.remove('showForm')
}