import _ from 'lodash';
import './style.css';
import { navbar } from './navbar';
import { Loader } from "@googlemaps/js-api-loader";

const stops = []

const loader = new Loader({
    apiKey: "MAPS_API_KEY",
    version: "weekly",
});

let map;

const initMap = async () => {
    
}

const routeComp = (route) => {
    const start = document.createElement('h4');
    const end = document.createElement('h4');
    const requestButton = document.createElement('button');
    const form = document.createElement('form');
    const startPoint = route['startingPoint'];
    const endPoint = route['endPoint'];

    stops.push(startPoint, endPoint);

    start.textContent = 'Start: ' + startPoint['address'];
    end.textContent = 'End: ' + endPoint['address'];
    requestButton.textContent = 'Request';
    form.appendChild(start);
    form.appendChild(end);
    form.appendChild(requestButton);
    document.body.appendChild(form);
}

const submit = (data) => {
    console.log("data");
    console.log(data);
}

const mapDiv = document.createElement('div');
mapDiv.id = 'map';

document.body.appendChild(navbar());
await fetch('http://localhost:8081/api/commute-train/routes')
    .then((response) => response.json())
    .then((data) => {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i])
            routeComp(data[i]);
        }
    })
    .catch((e) => console.log(e));
document.body.appendChild(mapDiv);

await loader.load().then(async () => {
    const { Marker } = await google.maps.importLibrary("marker")
    const { Map } = await google.maps.importLibrary("maps");
    const mapOptions = {
        center: { lat: -26.208530974528735, lng: 28.03377145547322 },
        zoom: 10,
    }
    map = new Map(document.getElementById("map"), mapOptions);
    for (let j = 0; j < stops.length; j++) {
        console.log('lon')
        console.log(stops[j]['stopLongitude'])
        console.log('lat')
        console.log(stops[j]['stopLatitude'])
        const marker = new Marker({
            map: map,
            position: {lat: parseFloat(stops[j]['stopLongitude']), lng: parseFloat(stops[j]['stopLatitude'])},
          });
        marker.setMap(map);
    }
});
