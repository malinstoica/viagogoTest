package model;

/**
* This class will represent a ticket
*
*/

public class Ticket{

  private double price;
  private Event event;

  /**
  * Constructs a ticket object for a specific event. Sets the price to the given one.
  *
  * @param event the event for which this ticket is
  * @param price the price of the ticket
  */
  public Ticket(Event event, double price){
    this.event = event;
    this.price = price;
  }

  /**
  * Constucts an empty ticket for events that have no tickets available, 'placeholder'.
  *
  */
  public Ticket(){
    price = 0;
  }

  /**
  * Returns the price of this ticket
  *
  * @return the price of the ticket
  */
  public double getPrice(){
    return price;
  }

  /**
  * Updates the price of the ticket.
  *
  * @param price the new price
  */
  public void updatePrice(double price){
    this.price = price;
  }

  /**
  * Returns the event for which this ticket is sold for
  *
  * @return the event for this ticket
  */
  public Event getEvent(){
    return event;
  }

  /**
  *  Overwrites the default toString() method to output the price of the ticket in US Dollars
  *
  * @return the String representation of a Ticket
  */
  @Override
  public String toString(){
    if(price == 0)
      return "No ticket available";
    return "$" + price;
  }



}
