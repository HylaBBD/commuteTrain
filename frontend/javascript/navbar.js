const initNav = () => {
    let navbar = document.getElementById("navbar");
    let aHome = document.createElement("a");
    let aRequest = document.createElement("a");
    let aCancel = document.createElement("a");
    let aLogout = document.createElement("a");
    aHome.textContent = "Home ";
    aRequest.textContent = "Request Ride ";
    aCancel.textContent = "Cancel Ride ";
    aLogout.textContent = "Logout ";
    aHome.href = "index.html";
    aRequest.href = "request.html";
    aCancel.href = "cancel.html";
    aLogout.href = "logout";
    navbar.appendChild(aHome);
    navbar.appendChild(aRequest);
    navbar.appendChild(aCancel);
    navbar.appendChild(aLogout);
}

initNav();