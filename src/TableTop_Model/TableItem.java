package TableTop_Model;
import ErrorMessages_View.LocationBoundaryRelated;

/**
 * TableItem is an Abstract class that providing the constructor
 * for initial variable (itemType) 
 * Responsibilities:
 * support multiple item types are able to put on table top
 * TableItem class has
 * - a private int posX
 * - a private int posY
 * provides
 * - static boolean checkPosX(int posX)
 * - static boolean checkPosY(int posY)
 *   that allow other classes to use for checking the next step
 *   would be out of table range or not
 */
public abstract class TableItem {
	public final static int UNIT_SIZE = 5;
	public final static int POSX_MIN = 0;
	public final static int POSX_MAX = 4;
	public final static int POSY_MIN = 0;
	public final static int POSY_MAX = 4;
	
	public final static int EMPTY = 0;
	public final static int ROBOT = 1;
	
	private int itemType;
	private int posX;
	private int posY;
	
	//constructors
	public TableItem(int itemType)
	{
		setItemType(itemType);
	}
	public TableItem(int itemType, int posX, int posY)
	{
		setItemType(itemType);
		setPosX(posX);
		setPosY(posY);
	}
	
	// item getter and setter
	protected void setItemType(int itemType)
	{
		this.itemType = itemType;
	}
	public int getItemType()
	{
		return itemType;
	}
	
	//position getters and setters
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {		
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	//validation location
	public static boolean checkPosX(int posX)
	{
		if(posX < POSX_MIN || posX > POSX_MAX)
		{
			//posX out of range
			LocationBoundaryRelated.displayPosXOutOfTableRange();
			return false;
		}
		return true;
	}
	
	public static boolean checkPosY(int posY)
	{
		if(posY < POSY_MIN || posY > POSY_MAX)
		{
			//posY out of range
			LocationBoundaryRelated.displayPosYOutOfTableRange();
			return false;
		}
		return true;
	}
}
