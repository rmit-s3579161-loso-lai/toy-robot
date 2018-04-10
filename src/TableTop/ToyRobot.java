package TableTop;
import ErrorMessages.LocationBoundaryRelated;

/**
 * ToyRobot inheritance from TableItem
 */
public class ToyRobot extends TableItem {
	public final static int POSX_MIN = 0;
	public final static int POSX_MAX = 4;
	public final static int POSY_MIN = 0;
	public final static int POSY_MAX = 4;
	
	public final static String NORTH = "NORTH";
	public final static String SOUTH = "SOUTH";
	public final static String EAST = "EAST";
	public final static String WEST = "WEST";
	
	private String facing;
	private static ToyRobot instance = null;
	private int instanceConter;
	
	public static ToyRobot getInstance()
	{
		if(instance == null)
			instance = new ToyRobot();
		
		return instance;
	}
	
	public int getInstanceConter() {
		return instanceConter;
	}

	public void setInstanceConter() {
		this.instanceConter++;
	}
	
	
	private ToyRobot()
	{
		super(TableItem.ROBOT);
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}
	
//	public ToyRobot(int posX, int posY, String facing)
//	{
//		super(TableItem.ROBOT, posX, posY);
//		this.facing = facing;
//		
//		//checking the position is out of boundaries or not
//		if(posX < POSX_MIN || posX > POSX_MAX)
//			//posX out of range
//			LocationBoundaryRelated.displayPosXOutOfRange();
//		if(posY < POSY_MIN || posY > POSY_MAX)
//			//posY out of range
//			LocationBoundaryRelated.displayPosYOutOfRange();
//		
//		//find efficient way to check facing
//	}
}