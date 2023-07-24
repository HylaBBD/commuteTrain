export const navbar = () => {
    const element = document.createElement("nav");
    const home = document.createElement("a");
    const request = document.createElement("a");
    const cancel = document.createElement("a");
    const logout = document.createElement("a");

    home.setAttribute("href", "index.html");
    request.setAttribute("href", "request.html");
    cancel.setAttribute("href", "cancel.html");
    logout.setAttribute("href", "logout");
    home.appendChild(document.createTextNode("Home"))
    request.appendChild(document.createTextNode("Request"))
    cancel.appendChild(document.createTextNode("Cancel"))
    logout.appendChild(document.createTextNode("Logout"))
    element.appendChild(home);
    element.appendChild(request);
    element.appendChild(cancel);
    element.appendChild(logout);

    return element;
}
