package Commands;
import ErrorMessages.*;
import TableTop.*;

public class PlaceCommand extends Command {
	public final static int PARA_POSX = 1;
	public final static int PARA_POSY = 2;
	public final static int PARA_FACEING = 3;
	public final static int PLACE_LIMIT = 1;
	
	private int posX;
	private int posY;
	private String facing;
	
	//add getters for JUnit testing
	public int getPara0_Type()
	{
		return getCommandType();
	}
	public int getPara1_posX()
	{
		return posX;
	}
	public int getPara2_posY()
	{
		return posY;
	}
	public String getPara3_Facing()
	{
		return facing;
	}

	public PlaceCommand(String[] inputs)
	{
		super(PLACE);
		
		if(inputs.length > 1 && inputs.length <= 4)
		{
			try
			{
				posX = Integer.parseInt(inputs[PARA_POSX]);
			}
			catch(Exception e){
				CommandRelated.displayInputFormatInvalid(inputs[PARA_POSX]);
			}
			
			//checking position X boundary
			if(!TableItem.checkPosX(posX))
				super.setExecutableFlag(false);
			
			try
			{
				posY = Integer.parseInt(inputs[PARA_POSY]);
			}
			catch(Exception e){
				CommandRelated.displayInputFormatInvalid(inputs[PARA_POSX]);
			}
			//checking position Y boundary
			if(!TableItem.checkPosY(posY))
				super.setExecutableFlag(false);
			
			facing = inputs[PARA_FACEING];
			//checking facing
			if(!ToyRobot.checkFacing(facing))
				super.setExecutableFlag(false);
		}
		else 
		{
			//should new expection for it
			//instead of returning false
		}
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(!super.isExecutableFlag())
		{
			CommandRelated.diaplayCommandIgnore();
			return;
		}
		
		//for debug purpose
		System.out.println(PLACE);		
		
		ToyRobot robot = ToyRobot.getInstance();
		robot.setPlaceCounter();
		
		if(robot.getPlaceCounter() > PLACE_LIMIT)
			RobotRelated.displayHasRobotAlready();
		else
		{
			robot.setPosX(posX);
			robot.setPosY(posY);
			robot.setFacing(facing);
		}
		
	}
}
