# BookingGoProject

## Requirements:
Java - 1.8.0  
Apache Maven - 3.6

## Setup

Clone repository:
```
git clone https://github.com/raduandrone/BookingGoProject
```

Compile :
```
mvn clean compile assembly:single
```

## Part 1 

### Console application to print the search results for all taxi suppliers

Run 

Windows :
```
java -cp target\BookingGoTest-0.0.1-SNAPSHOT-jar-with-dependencies.jar Search.Part1 [pickup latitude] [pickup longitude] [dropoff latitude] [dropoff latitude]
```

Unix :
```
java -cp target/BookingGoTest-0.0.1-SNAPSHOT-jar-with-dependencies.jar Search.Part1 [pickup latitude] [pickup longitude] [dropoff latitude] [dropoff latitude]
```

Replace **[pickup latitude] [pickup longitude]** with pickup coordinates.   

Replace **[dropoff latitude] [dropoff longitude]** with pickup coordinates.


### Console application to filter by number of passengers

Run 

Windows :
```
java -cp target\BookingGoTest-0.0.1-SNAPSHOT-jar-with-dependencies.jar Search.Part1 [pickip latitude] [pickup longitude] [dropoff latitude] [dropoff latitude] [passangers]
```

Unix :
```
java -cp target/BookingGoTest-0.0.1-SNAPSHOT-jar-with-dependencies.jar Search.Part1 [pickip latitude] [pickup longitude] [dropoff latitude] [dropoff latitude] [passangers]
```

Command line arguments have the same format as before.

Extra argument to specify number of passangers.

Replace **[passangers]** with number of passangers.

## Part 2

### Sample request
```
http://localhost:8090/bookinggo?pickup=[pickup latitude,pickup longitude]&dropoff=[dropoff latitude,dropoff longitude]&passangers=[passangers]
```

Replace **[pickup latitude,pickup longitude]** with pickup coordinates.   

Replace **[dropoff latitude,dropoff longitude]** with pickup coordinates.

Replace **[passangers]** with number of passangers.


Example:
```
http://localhost:8090/bookinggo?pickup=51.470020,-0.454295&dropoff=3.410632,-2.157533&passangers=1
```
