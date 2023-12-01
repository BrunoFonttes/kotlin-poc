# Movie Tickets Booking API

Commands to run in Development Mode

./gradlew -t build
./gradlew run


## Endpoints

GET /movies

query parameters

title: string
showDate: string(ISO Date)
seatsAmount: number
location: countryId

GET /movies/sessions/:id

```json
  {
    "id": 123,
    "title": "The Nun II",
    "duration": "1h 51m",
    "showTime": "2023-09-23T20:55:39.034Z",
    "availableSeats": 1
  }
```
POST /movies/sessions/:id/booking
```json
[
  {
    "name": "Bruno"
  }
]
```
GET /movies/bookings/:id
```json
[
  {
    "name": "Bruno"
  }
]
```