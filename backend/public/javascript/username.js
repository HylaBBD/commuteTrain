const getUserName = () => {
    fetch('https://commute-train.bbdgrad.com/name')
        .then(response => response.text())
        .then(data => document.getElementById('username-title').innerText = data);
}

getUserName();
