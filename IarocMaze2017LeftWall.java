package Assignments;

import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class IarocMaze2017LeftWall extends IRobotAdapter {
	Sonar sonar = new Sonar();

	public IarocMaze2017LeftWall(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		IarocMaze2017LeftWall rob = new IarocMaze2017LeftWall(base);
		rob.setup();
		while (rob.loop()) {
		}
		rob.shutDown();

	}

	private void setup() throws Exception {
		// SETUP CODE GOES HERE!!!!!
	
		
		
		
	}

	private boolean loop() throws Exception{
		readSensors(100);
		
		driveDirect(130,1000);
		
		int[] lightBumpReadings = getLightBumps();
		
		
			if(lightBumpReadings[0] > 0){
				driveDirect(500,-500);
				sleep(50);
				driveDirect(0, 0);
		
			}
		

			if(lightBumpReadings[1] > 0){
				driveDirect(500,-500);
				sleep(70);
				driveDirect(0, 0);
		
			}
		return true;
	}
	
	private void sleep(int amt) {
		try {
			Thread.sleep(amt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}