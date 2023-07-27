const getUserName = () => {
    fetch('http://localhost:8081/name')
        .then(response => response.text())
        .then(data => document.getElementById('username-title').innerText = data);
}

getUserName();
