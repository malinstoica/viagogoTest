import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
* This is the Driver class that will hold the tests and handle user interaction
*
*/

public class Main{

  /**
  * The main method. Will create seed data, wait for user input and proccess all the information
  *
  * @param args command line input
  */
  public static void main(String[] args){

    //1. generate data
    //2. accept input
    //3. select closest coordinates to input
    //4. output to Sys.output

    GenerateSeed seed = new GenerateSeed();
    Scanner in = new Scanner(System.in);

    ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>(seed.generateCoordinates());

    int x;
    int y;
    boolean exit = false;

    String patternString1 = "\\-\\d*,\\-?|\\d*,\\-?\\d*";
    String patternString2 = "(?:\\-\\d*, \\-?|\\d*, \\-?)\\d*";
    Pattern pattern1 = Pattern.compile(patternString1);
    Pattern pattern2 = Pattern.compile(patternString2);
    String input = "";


    while(!in.equals("exit")){



      System.out.println("Input coordinates : ");
      input = in.nextLine();

      if(input.equals("exit")){
        exit = true;
        break;
      }

      Matcher matcher1 = pattern1.matcher(input);
      Matcher matcher2 = pattern2.matcher(input);
      boolean matches1 = matcher1.matches();
      boolean matches2 = matcher2.matches();

      if(matches1){
        x = Integer.parseInt(input.split(",")[0]);
        y = Integer.parseInt(input.split(",")[1]);
        printResult(x, y, coordinates);
      } else if(matches2){
          x = Integer.parseInt(input.split(", ")[0]);
          y = Integer.parseInt(input.split(", ")[1]);
          printResult(x, y, coordinates);
        } else if(!exit){
          System.out.println("Incorrect input. Please provide a coordinate of the form 'x,y' or 'x, y' ");
      }

    }


  }

  /**
  * Prints to the terminal all closest events and their cheapest tickets
  *
  * @param x the x-axis value
  * @param y the y-axis value
  * @param coordinates the list of coordinates
  */

  public static void printResult(int x, int y, ArrayList<Coordinate> coordinates){

    if(x <= Coordinate.WORLD_MAX && x >= Coordinate.WORLD_MIN && y <= Coordinate.WORLD_MAX && y >= Coordinate.WORLD_MIN){

      Coordinate user = new Coordinate(x, y);

      System.out.println("Closest Events to " + user + ":");

      for(Coordinate c : coordinates)
        if(user.getDistanceTo(c) < 12)
          System.out.println(c.getEvent() + " - " + c.getEvent().getCheapestTicket() + ", Distance " + user.getDistanceTo(c));

    } else {
      System.out.println("Coordinates provided are outside the world range. Please input coordinates in the range [-10, 10]");
    }

  }
}
