package model;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

/**
* This class will create random data used for testing
*
*/
public class GenerateSeed{

  private ArrayList<Integer> x_arr;
  private ArrayList<Integer> y_arr;
  private ArrayList<Coordinate> coordinates;
  private ArrayList<Integer> x_axis;
  private ArrayList<Integer> y_axis;


  /**
  * Constructs the object and initializes associated data structures
  *
  */
  public GenerateSeed(){
    x_arr = new ArrayList<Integer>();
    y_arr = new ArrayList<Integer>();
    coordinates = new ArrayList<Coordinate>();
  }

  /**
  * Generates a random number of Coordinate objects used for testing.
  * Creates two arrays with values from within the world limits.
  * Shuffles the 2 arrays and randomly split them into 2 arrays of a random size
  * Takes the values (x, y) from each one of the array and creates new Coordinate object
  * @return an ArrayList of Coordinate objects
  */
  public ArrayList<Coordinate> generateCoordinates(){

    for(int i = Coordinate.WORLD_MIN; i < Coordinate.WORLD_MAX + 1 ; i++){
      x_arr.add(i);
      y_arr.add(i);
    }

    Collections.shuffle(x_arr);
    Collections.shuffle(y_arr);


    int start = (int) (Math.random()* x_arr.size());
    x_axis = new ArrayList<Integer>(x_arr.subList(start, x_arr.size()));
    y_axis = new ArrayList<Integer>(y_arr.subList(start, y_arr.size()));

    for(int i = 0; i < x_axis.size(); i++)
      coordinates.add(new Coordinate(x_axis.get(i), y_axis.get(i), true));


    return coordinates;

  }






}
