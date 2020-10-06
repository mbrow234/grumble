grumble-web

Grumble - Site to list animals for adoption, search for animals to adopt, search for registered and verified dog sitters in your area and search for vets/clinics in your area with ratings by community.

Running on port 3000 - LOCAL

START APP - LOCAL
-----------------
In terminal:
    mysql.server start
In IDE:
    Start spring boot app
    
 STOP APP - LOCAL
 ----------------
 In IDE:
    Stop spring boot app from IDE
In Terminal:
    mysql.server stop
    
    
TODO
----
Finish creating services, controllers, repositories and db schema/tables
api for saving entities in list and getting all entities in list ect
Put robust endpoints in each controller to allow for fine control over data
Create some sort of front end app - Angular or React, either with Typescript
Put some security and Auth in to endpoints. Authorized users.
Create services for petDto watching, petDto walking, petDto hospital finder/reviews.
Create ability for userDto to have profile for offering services like sitting, watching or training. Users are verified and registered to be able to offer such. What makes someone real and trustworthy?
