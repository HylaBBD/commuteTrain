const addBookings = () => {
    fetch('http://localhost:8081/api/commute-train/bookings')
        .then(response => response.json())
        .then(data => data.forEach(booking => {
            let item = document.createElement('li');
            let from = document.createElement('address');
            let to = document.createElement('address');
            let at = document.createElement('time');
            let until = document.createElement('time');

            from.innerText = ' Pickup: ' + booking['truckRoute']['route']['startingPoint']['address'];
            to.innerText = ' Drop-off: ' + booking['truckRoute']['route']['endPoint']['address'];
            at.innerText = ' Pickup Time: ' + booking['truckRoute']['pickupTime'].replace('T', ' ').replace(RegExp('\:\\d{2}\\..*'), '');
            until.innerText = ' Drop-off Time: ' + booking['truckRoute']['dropOffTime'].replace('T', ' ').replace(RegExp('\:\\d{2}\\..*'), '');
            console.log(from, to, at, until);
            let fromHeader = document.createElement('h4');
            let toHeader = document.createElement('h4');
            let untilHeader = document.createElement('h4');
            let atHeader = document.createElement('h4');
            let finalHeader = document.createElement('h4');
            fromHeader.appendChild(from);
            toHeader.appendChild(to);
            untilHeader.appendChild(until);
            atHeader.appendChild(at);
            finalHeader.innerText = '-'
            item.appendChild(fromHeader);
            item.appendChild(toHeader);
            item.appendChild(atHeader);
            item.appendChild(untilHeader);
            item.appendChild(finalHeader);
            document.getElementById('bookingsList').appendChild(item);
        }))
}

addBookings();