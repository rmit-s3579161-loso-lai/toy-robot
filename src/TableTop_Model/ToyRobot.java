package TableTop_Model;
import ErrorMessages_View.LocationBoundaryRelated;

/**
 * ToyRobot class inheritance from TableItem
 * takes a model role in the system, apply Singleton pattern
 * Responsibilities:
 * static array that holding directions
 * store the positions of next step
 * current facing
 * currentDirection stores index that is able to map the directions
 * 
 * ToyRobot class has
 * - isAbleToMove:   call by MoveCommand
 * - robotMove:      call by MoveCommand
 * - robotTurnLeft:  call by LeftCommand
 * - robotTurnRight: call by RightCommand
 * - robotReport:    call by ReportCommand
 */
public class ToyRobot extends TableItem {
	public final static String NORTH = "NORTH";
	public final static String SOUTH = "SOUTH";
	public final static String EAST = "EAST";
	public final static String WEST = "WEST";
	
	public final static int DIRECTIONS = 4;
	private final int NORTH_INX = 0;
	private final int EAST_INX  = 1;
	private final int SOUTH_INX = 2;
	private final int WEST_INX  = 3;
	private String[] directions;
	
	private static ToyRobot instance = null;
	
	//record next valid movement
	private int nextPosX;
	private int nextPosY;
	
	//record direction
	private String facing;
	private int curDirection;
	
	public static ToyRobot getInstance()
	{
		if(instance == null)
			instance = new ToyRobot();
		
		return instance;
	}
	
	private ToyRobot()
	{
		super(TableItem.ROBOT);
		
		//initial directions
		directions = new String[DIRECTIONS];
		directions[NORTH_INX] = NORTH;
		directions[EAST_INX] = EAST;
		directions[SOUTH_INX] = SOUTH;
		directions[WEST_INX] = WEST;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
		
		//record current direction
		String upperStr = this.facing.toUpperCase();
		if(upperStr.matches(NORTH))
			curDirection = NORTH_INX;
		else if(upperStr.matches(EAST))
			curDirection = EAST_INX;
		else if(upperStr.matches(SOUTH))
			curDirection = SOUTH_INX;
		else
			curDirection = WEST_INX;
	}
	
	//facing string validation
	public static boolean checkFacing(String facing)
	{
		String upper = facing.toUpperCase();
		if(!upper.matches(NORTH) && 
		   !upper.matches(SOUTH) &&
		   !upper.matches(EAST)  &&
		   !upper.matches(WEST))
		{
			LocationBoundaryRelated.displayFacingInvalidMessage();
			return false;
		}
		
		return true;
	}
	
	//calculate the next position then 
	//check does is ot of the table range
	public boolean isAbleToMove()
	{
		//check one step from the direction
		//will be out of the position range
		int curPosX = this.getPosX();
		int curPosY = this.getPosY();
		String curFacing = this.getFacing();
		
		if(curFacing.toUpperCase().matches(NORTH))
			curPosY++;
		if(curFacing.toUpperCase().matches(SOUTH))
			curPosY--;
		if(curFacing.toUpperCase().matches(EAST))
			curPosX++;
		if(curFacing.toUpperCase().matches(WEST))
			curPosX--;
		
		//check new position
		if(!TableItem.checkPosX(curPosX))
			return false;
		if(!TableItem.checkPosY(curPosY))
			return false;
		
		//validate position
		nextPosX = curPosX;
		nextPosY = curPosY;
		return true;
	}
	
	//robot movement
	public void robotMove()
	{
		this.setPosX(nextPosX);
		this.setPosY(nextPosY);
	}
	
	//robot direction turning
	public void robotTurnLeft()
	{
		curDirection--;
		
		if(curDirection < 0)
			curDirection = directions.length - 1;
		
		this.facing = directions[curDirection];
	}
	
	//robot direction turning
	public void robotTurnRight()
	{
		curDirection++;
		
		if(curDirection >= directions.length)
			curDirection = 0;
		
		this.facing = directions[curDirection];
	}
	
	//robot report current status
	public void robotReport()
	{
		System.out.println(this.getPosX() + "," +
						   this.getPosY() + "," +
						   this.getFacing());
	}
}
