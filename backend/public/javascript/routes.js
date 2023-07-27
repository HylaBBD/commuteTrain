const SERVER_URL = 'http://localhost:8081/';

let map;
let start;
let end;
let stops = [];

const getRoutes = () => {
    fetch(SERVER_URL + 'api/commute-train/truck-routes')
        .then(response => response.json())
        .then(data => {
            data.forEach((truckRoute) => {
                let option = document.createElement('option');
                option.value = truckRoute['truckRouteId'];
                option.innerText = truckRoute['route']['startingPoint']['address'] + ' - ' + truckRoute['route']['endPoint']['address'];
                document.getElementById('route').appendChild(option);
                document.getElementById('pickupTime').innerText = truckRoute['pickupTime'].replace('T', ' ').replace(RegExp('\:\\d{2}\\..*'), '');
                document.getElementById('dropOffTime').innerText = truckRoute['dropOffTime'].replace('T', ' ').replace(RegExp('\:\\d{2}\\..*'), '');
                start = { lat: truckRoute['route']['startingPoint']['stopLatitude'], lng: truckRoute['route']['startingPoint']['stopLongitude'] };
                end = { lat: truckRoute['route']['endPoint']['stopLatitude'], lng: truckRoute['route']['startingPoint']['stopLongitude'] };
                stops.push({position : start, name : truckRoute['route']['startingPoint']['address']})
                stops.push({position : end, name : truckRoute['route']['endPoint']['address']})
            })
        })
}

async function initMap () {
    const { Map } = await google.maps.importLibrary("maps");

    map = new Map(document.getElementById("map"), {
        center: start,
        zoom: 8,
        mapId: 'DEMO_MAP_ID',
    });

    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");

    stops.forEach(stop => {
        new AdvancedMarkerElement({
            map,
            position: stop['position'],
            title: stop['name'],
        });
    })
}

const submit = () => {
    fetch(SERVER_URL + 'api/commute-train/bookings?truckRouteId=' + document.getElementById('route').valueOf(), {
        method: 'POST'
    }).then(window.location.push('/index.html'))
}

getRoutes();
document.addEventListener('load', initMap);
document.getElementById('submitButton').addEventListener('click', submit);


// Create the script tag, set the appropriate attributes
