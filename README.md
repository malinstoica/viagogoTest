## Developer Coding Challange for Viagogo Software Engineer Placement position

---

#### How to compile and run the project



1. Clone repository into local machine

   <code> git clone https://github.com/malinstoica/viagogoDeveloperTest.git </code>

2. Wait for cloning to finish

3. Change directory to /viagogoDeveloperTest/app

    * by <code>cd viagogoDeveloperTest </code> and <code> cd app</code> in terminal

    * double click <code> viagogoDeveloperTest</code> folder and then <code> app </code> folder

4. Open Terminal or Command Prompt in current folder

    * if you <code> cd app </code> before, go to next step

    * press <code> Shift</code> button and right click in the folder window. select <code> Open command window here </code>

5. Compile the source code

    * run <code> javac Main.java </code> in the terminal

6. Run the app

    * run <code> java Main </code> in the terminal

7. Input data and wait for response

    for the moment, this app accepts only input that reassembles either of these formats
      * <code> integer,integer </code>
      * <code> integer, integer </code>

    if during the usage the user wants to exit the app, just type in terminal
      * <code> exit </code>

---

#### Assumptions made

* Due to a small scale world, I hard-coded the maximum number of tickets that can be sold for an event [0-20] and the maximum amount of US Dollars a ticket can cost [$1-$100]
* Due to time limitations caused by external factors (University) and reduced time spent working on this project, I did not take into account the possibility to have all coordinates filled with an event for the seed data [maximum sample seed size is 40 active events out of a possible maximum of 400]
* Implemented potential usefull methods like <code> addTicket() </code> or <code> sellTicket() </code> to ease the proccess where one would have to remove or add individaul tickets to an Event

---

#### Multiple events at the same location improvisation

* The user should be prompted with a list of all the events that take place at that location and the cheapest available ticket for each event
* This would require a simple data structure that will hold all the available events inside a Coordinate object

     <code> ArrayList\<Event\> availableEvents; </code>

---

#### Bigger world improvisation

* The running time of the algorithm that finds the closest events to the user would exponentially grow with the size of the world. Given that the implemented method for this app iterates over all the available events in the world and selects only those that have a <code> distance < 12 </code>, there should be a better implementation that takes less time and is less complex.
* One way of doing that is having a threshold for the Coordinate class and a method that will search within that threshold for available events.


  ```java
  threshold = 4 //pseudocode

  for(int i = 0; i < threshold; i++)                             
     for(int j = 0; j < threshold; j++)
        if(coordinate(user.x + i + 1, user.y + j + 1).isValid())
          nearby.add(coordinate)
  return nearby
  ```
* despite having O(n^2), it is faster as it only looks for a limited area around the location of the user

---
