package model;

import java.lang.Math;
/**
* This class will represent a coordinate within the world.
*
*/

public class Coordinate{

  public static final int WORLD_MIN = -10;
  public static final int WORLD_MAX = 10;

  private int x;
  private int y;

  private Event event;

  /**
  * Constructs a Coordinate object. Holds only one event for each instance.
  *
  * @param x the x-axis value
  * @param y the y-axis value
  */
  public Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }

  /**
  * Constructs a Coordinate object for seed data
  *
  * @param x x-axis value
  * @param y y-axis value
  * @param test If true, automatically generate Event for seed data. Otherwise, instantiate new coordinate object
  */
  public Coordinate(int x, int y, boolean test){
    this(x, y);

    if(test)
      this.event = new Event(this, true);
  }

  /**
  * Sets the given event object as the event for this specific coordinate
  *
  * @param event the event that is to be set
  */
  public void setEvent(Event event){
    this.event = event;
  }

  /**
  * Returns the event for this coordinate
  *
  * @return the event object for this coordinate
  */
  public Event getEvent(){
    return event;
  }

  /**
  * Returns the x-axis value for this coordinate
  *
  * @return the x-axis value
  */
  public int getX(){
    return x;
  }


  /**
  * Returns the y-axis value for this coordinate
  *
  * @return the y-axis value
  */
  public int getY(){
    return y;
  }

  /**
  * Returns the Manhattan distance from this coordinate to a given one.
  *
  * @param destination the coordinates of the destination
  */
  public int getDistanceTo(Coordinate destination){
    return Math.abs(x - destination.getX()) + Math.abs(y - destination.getY());
  }

  /**
  * Overrides the toString() method to display the coordinates of the object
  *
  * @return a String representing the coordinates of the object
  */
  @Override
  public String toString(){
    return "(" + x + ", " + y + ")";
  }

}
