#Nymble Travel Agency


##Overview


This project represents a software system designed for travel agencies to manage their travel packages' itinerary and passengers. It provides functionalities to create and maintain travel packages, destinations, activities, and passengers. The system allows passengers to sign up for activities based on their preferences and handles different types of passengers with varying privileges.

##Specification

*Travel Package:*

Each travel package has a name, passenger capacity, itinerary (list of destinations), and a list of passengers enrolled.

*Destination:*

Each destination has a name and a list of activities available at that destination.
*Activity:*

Each activity has a name, description, cost, and capacity. Each activity is associated with one destination only.

*Passenger:*

Passengers can sign up for zero or more activities at each destination of the travel package.
Once an activity reaches its capacity, no more passengers can sign up for it.
Passengers are categorized as standard, gold, or premium, each with different privileges regarding activity sign-ups.

*Functions*
The classes provide the following functions:

Print Itinerary:

Displays the travel package's itinerary, including package name, destinations, and details of available activities at each destination.
Print Passenger List:

Shows the list of passengers enrolled in the travel package, including package name, passenger capacity, current enrollment count, and details of each passenger.
Print Passenger Details:

Prints the details of an individual passenger, including name, passenger number, balance (if applicable), and the list of activities they have signed up for, including destination and activity price.
Print Available Activities:

##Usage
To use this project, simply clone the repository and run the Main class. Make sure you have Java installed on your system.

Displays the details of all activities that still have spaces available, including the number of available spaces.


##Contributors
Shubham Kumar
