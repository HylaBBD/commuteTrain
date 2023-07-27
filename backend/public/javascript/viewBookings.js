let equipment = ["barbell", "dumbbell", "kettlebell", "medicine ball", "resistance band", "jump rope", "foam roller", "yoga mat"];
let exercises = ["Squat", "Bench Press", "Deadlift", "Overhead Press", "Barbell Row"];

const addWorkouts = (parent) => {
    fetch('http://localhost:8081/api/commute-train/bookings')
        .then(response => response.json())
        .then(data => {
            let h2 = document.createElement('h2');
            h2.innerText = data.exerciseType;

            let br = document.createElement('br');
            let table = document.createElement('table');
            let tableHeader = document.createElement('tr');

            let tableHeaderExercise = document.createElement('th');
            tableHeaderExercise.innerText = 'Exercise';

            let tableHeaderEquipment = document.createElement('th');
            tableHeaderEquipment.innerText = 'Equipment';

            tableHeader.appendChild(tableHeaderExercise);
            tableHeader.appendChild(tableHeaderEquipment);

            let tableBody = document.createElement('tbody');

            let maxLength = Math.max(exercises.length, equipment.length);

            for (let i = 0; i < maxLength; i++) {
                let tableRow = document.createElement('tr');
                let tableDataExercise = document.createElement('td')
                let tableDataEquipment = document.createElement('td')

                if (exercises[i] !== undefined) {
                    tableDataExercise.innerText = data.exercises[i].name;
                } else {
                    tableDataExercise.innerText = '';
                }

                if (equipment[i] !== undefined) {
                    tableDataEquipment.innerText = data.equipment[i].name;
                } else {
                    tableDataEquipment.innerText = '';
                }

                tableRow.appendChild(tableDataExercise);
                tableRow.appendChild(tableDataEquipment);
                tableBody.appendChild(tableRow);
            }

            table.appendChild(tableHeader);
            table.appendChild(tableBody);

            parent.appendChild(br);
            parent.appendChild(h2);
            parent.appendChild(table);
        })
}


const addBookings = () => {
    fetch('http://localhost:8081/api/commute-train/bookings')
        .then(response => response.json())
        .then(data => data.forEach(booking => {
            let articleElement = document.createElement('article');
            articleElement.classList.add('booking-card', 'v-container');

            let addressRouteStartValue = document.createElement('address');
            let addressRouteEndValue = document.createElement('address');
            let timeStartValue = document.createElement('time');
            let timeEndValue = document.createElement('time');

            addressRouteStartValue.innerText = booking['truckRoute']['route']['startingPoint']['address'];
            addressRouteEndValue.innerText = booking['truckRoute']['route']['endPoint']['address'];
            timeStartValue.innerText = booking['truckRoute']['pickupTime'].replace('T', ' ').replace(RegExp('\:\\d{2}\\..*'), '');
            timeEndValue.innerText = booking['truckRoute']['dropOffTime'].replace('T', ' ').replace(RegExp('\:\\d{2}\\..*'), '');
            console.log(addressRouteStartValue, addressRouteEndValue, timeStartValue, timeEndValue);

            let cardHeader = document.createElement('h2');
            cardHeader.innerText = 'Booking for ' + booking['commuter']['commuterName'] + '.';

            articleElement.appendChild(cardHeader);

            let cardContent = document.createElement('dl');

            let addressRouteStartLabel = document.createElement('dt')
            addressRouteStartLabel.innerText = 'Pick up area:';
            let addressRouteEndLabel = document.createElement('dt')
            addressRouteEndLabel.innerText = 'Drop-off area:';
            let timeStartLabel = document.createElement('dt')
            timeStartLabel.innerText = 'Pick up time:';
            let timeEndLabel = document.createElement('dt')
            timeEndLabel.innerText = 'Drop-off time:';

            let addressRouteStartData = document.createElement('dd');
            let addressRouteEndData = document.createElement('dd');
            let timeStartData = document.createElement('dd');
            let timeEndData = document.createElement('dd');


            addressRouteStartData.appendChild(addressRouteStartValue);
            addressRouteEndData.appendChild(addressRouteEndValue);
            timeEndData.appendChild(timeEndValue);
            timeStartData.appendChild(timeStartValue);

            cardContent.appendChild(addressRouteStartLabel);
            cardContent.appendChild(addressRouteStartData);
            cardContent.appendChild(addressRouteEndLabel);
            cardContent.appendChild(addressRouteEndData);
            cardContent.appendChild(timeStartLabel);
            cardContent.appendChild(timeStartData);
            cardContent.appendChild(timeEndLabel);
            cardContent.appendChild(timeEndData);

            articleElement.appendChild(cardContent)

            addWorkouts(articleElement);

            document.getElementById('bookings-list').appendChild(articleElement);
        }))
}

addBookings();
