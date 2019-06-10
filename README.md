
Parking Lot System 

Parking Lot System is command line application to support use cases of a multifloor parking lot.

Pre requisite 

Java sdk 1.7 must be installed and JAVA_HOME must be set
Maven must be installed and mvn command path should be set in PATH enviornment variable.

Note - 
Application will work in unix but can also be made working in windows by updaing setup and parking_lot bat file for windows


Install
To build the executable jar file
parking_lot\bin\setup

Execution
To execute the application
parking_lot\bin\parking_lot  <input file which has st of commands>

Input - Accepted input is a file.

Following funtionalities has been supported by commands

1 To Build parking lot - 
	create_parking_lot <number of parking slot>
	
2 To reserve parking slot 
	park <registration number of vehicle> <color of vehicle>
	
3 To release parking slot
	leave <parking slot number>

4 To show status of parking slot at any point in time
	status

5 To show registration number of all the vehicles of a particular color
	registration_numbers_for_cars_with_colour <colour>
		
6.To show parking slot of a vehicle with a registration number
	slot_number_for_registration_number <registration number>

7. To show slot number of cars with a particular regitration number
	slot_numbers_for_cars_with_colour


Note -
Application can support multifloor parking system where as we can configure no of parking slot per floor, number of floors, entry and exits also stratgy to allocate parking slots can be configure while building the Parking Slots at run time.

Assumption
1) Designed it for multi floor parking system where no of parking slot will be given as input
2) Entry and Exit Parking slot can also be used to park vehicle
3) All type of vehicle consumed same size of parking slot
4) Each floor will have same no of parking slots
