import _ from 'lodash';
import './style.css';
import { navbar } from './navbar';

const component = () => {
    const topSection = document.createElement("section");
    const h1 = document.createElement("h1");
    h1.appendChild(document.createTextNode("Home"));
    topSection.appendChild(h1);  
    return topSection;
}

document.body.appendChild(navbar())
document.body.appendChild(component());
