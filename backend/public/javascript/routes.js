const SERVER_URL = 'https://commute-train.bbdgrad.com/';

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

                document.getElementById('routes-list').appendChild(option);

                document.getElementById('pickupTime').value = truckRoute['pickupTime'].split('T')[0];
                document.getElementById('dropOffTime').value = truckRoute['dropOffTime'].split('T')[0];

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
    let submitButton = document.getElementById("routes-list");
    let value = submitButton.options[submitButton.selectedIndex].value;

    fetch(SERVER_URL + 'api/commute-train/bookings?truckRouteId=' + value, {
        method: 'POST'
    }).then(response => response.json())
        .then(data => {
            if (data['status'] === 'success') {
                window.location.href = '../html/success.html';
            }
            if (data['bookingId']) {
                window.location.href = '../html/success.html';
            }
            if (data['status'] === 500){
                window.location.href = '../html/error.html';
            }
        })
}

document.addEventListener('DOMContentLoaded', () => {
    getRoutes();
    document.addEventListener('load', initMap);
    document.getElementById('submitButton').addEventListener('click', submit);
});



// Create the script tag, set the appropriate attributes
