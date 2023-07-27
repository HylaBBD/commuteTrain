const SERVER_URL = 'https://commute-train.bbdgrad.com/';

let userId;

export const requestRide = (bookingId, truckRouteId) => {
    let requestBody = {
        "bookingId": bookingId,
        "commuterId": userId,
        "truckRouteId": truckRouteId
    }
    fetch(SERVER_URL + 'api/commute-train/routes', {
        method : 'POST',
        headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'applicati   on/x-www-form-urlencoded',
        },
        body: requestBody,
    }).then()
}

const getUserId = () => {
    fetch(SERVER_URL + 'id')
        .then(response => response.text())
        .then(data => userId = data)
}

getUserId();
getRoutes();
export {userId, routes};