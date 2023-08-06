const fetchData = async() =>{
    let data = await fetch('https://jsonplaceholder.typicode.com/users');
    let res = await data.json();
    console.log(res);
}
fetchData();