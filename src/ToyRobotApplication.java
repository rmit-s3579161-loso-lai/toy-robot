
import java.util.*;
import CostomizedExceptions.CommandNotExistException;
import Simulator_Controller.Simulator;
/**
 * Application create a Simulator object
 * for monitoring toy robot status
 */
/**
 * It is a text-based program, where a robot moves on the table top; the simulator
 * is able to change the position, the facing information and report the current
 * state for the user.
 * The Table size is a 4 x 4 units. 
 * 
 * The Command instructions:
 * ========Instructions========
 * PLACE X,Y,F
 * MOVE
 * LEFT
 * RIGHT
 * REPORT
 * EXIT
 * Please enter your command :
 * $>
 * 
 * ToyRobotApplication is where the main function is 
 * the responsibility is that
 * 1. show Instructions
 * 2. get user input data for Simulator
 * 3. display exit message after typing in exit command
 */
public class ToyRobotApplication {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Simulator simulator = Simulator.getInstance();
		
		//display instructions
		showInstructions();
		
		boolean bExit = false;
		try{
			while(!bExit)
			{
				//noticing user input commands here
				System.out.print("$>");
				String str = reader.nextLine();
				
				//use regex to split parameters
				String[] inputs = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
				boolean bResult = simulator.excuteInput(inputs);
				if(!bResult)
					bExit = true;
			}
		} catch(CommandNotExistException e) {
			//if the command type doen't match
			//exit system
			System.err.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("Unexpected exception occur.");
			System.err.println(e.getMessage());
		}
		
		//exit system
		showExitMemssage();
	}
	
	public static void showInstructions()
	{
		System.out.println("========Instructions========");
		System.out.println("PLACE X,Y,F");
		System.out.println("MOVE");
		System.out.println("LEFT");
		System.out.println("RIGHT");
		System.out.println("REPORT");
		System.out.println("EXIT");
		System.out.println("Please enter your command : ");
	}
	
	public static void showExitMemssage()
	{
		System.out.println("========Exit SYSTEM========");
	}
}
