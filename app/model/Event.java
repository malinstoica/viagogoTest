package model;

import java.util.ArrayList;

/**
* This class will represent an event
*
*/
public class Event{

  private int id;
  private static int count;
  private ArrayList<Ticket> availableTickets;
  private Coordinate coordinate;

  /**
  * Constructs an Event object. Initializes the list of available tickets.
  *
  */
  public Event(Coordinate coordinate){
    this.coordinate = coordinate;
    availableTickets = new ArrayList<Ticket>();
    id = count++;
  }

  /**
  * Constructs and populates an event object with a random number of tickets within a range of [0-50].
  * Each ticket has a reference price, given at random within a [$1.00 - $100.00].
  *
  * @param test if true, will generate seed data. Otherwise, creates an empty event object
  */
  public Event(Coordinate coordinate, boolean test){
    this(coordinate);
    if(test){
      int numberOfTickets = (int) ((Math.random()*50) - 1);
      double price = 0.0;
      for(int i = 0; i < numberOfTickets; i++){
        price = Math.round((double) ((Math.random()*101) + 1) * 100.0) / 100.0;
        availableTickets.add(new Ticket(this, price));
      }
    }
  }


  /**
  * Returns the list of available tickets for this event
  *
  * @return the list of Ticket objects
  */
  public ArrayList<Ticket> getAvailableTickets(){
    return availableTickets;
  }

  /**
  * Returns the ID of the event
  *
  * @return the ID of the event as an Integer
  */
  public int getID(){
    return id;
  }

  /**
  * Returns the coordinate of the event
  *
  * @return the coordinate of this event
  */
  public Coordinate getCoordinate(){
    return coordinate;
  }

  /**
  * Replaces the available tickets list with the one supplied
  *
  * @param list the list of available tickets that is to be set for this event
  */
  public void updateAvailableTickets(ArrayList<Ticket> list){
    availableTickets = list;
  }

  /**
  * Adds a ticket that can be sold to the list of available tickets
  *
  * @param ticket the ticket to be added to the list
  */
  public void addTicket(Ticket ticket){
    availableTickets.add(ticket);
  }


  /**
  * Removes a ticket from the list of available tickets of this event
  *
  * @param ticket the ticket to be removed
  */
  public void sellTicket(Ticket ticket){
    availableTickets.remove(ticket);
  }

  /**
  * Returns a ticket object that has the cheapest price
  *
  * @return a ticket object with the lowest price
  */
  public Ticket getCheapestTicket(){

    if(availableTickets.size() == 0)
      return new Ticket();

    Ticket saved = availableTickets.get(0);
    double min = saved.getPrice();
    for(Ticket t : availableTickets)
      if(min > t.getPrice()){
        min = t.getPrice();
        saved = t;
      }

    return saved;


  }


  /**
  * Overwrites the defaul toString() method to display the Event and its ID
  *
  * @return the String representation of the event
  */
  @Override
  public String toString(){
    return "Event " + id;
  }





}
