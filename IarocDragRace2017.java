package Assignments;

import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class IarocDragRace2017 extends IRobotAdapter {
	Sonar sonar = new Sonar();

	public IarocDragRace2017(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		IarocDragRace2017 rob = new IarocDragRace2017(base);
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
		
		driveDirect(1000,1000);
		
		int[] lightBumpReadings = getLightBumps();
		
		if(lightBumpReadings[0] > 0){
			driveDirect(700, 200);
			sleep(100);
			driveDirect(0, 0);
		}
			if(lightBumpReadings[5] > 0){
				driveDirect(200, 700);
				sleep(100);
				driveDirect(0, 0);
		
			}
			if(lightBumpReadings[1] > 0){
				driveDirect(700, 100);
				sleep(100);
				driveDirect(0, 0);
			}

			if(lightBumpReadings[4] > 0){
				driveDirect(100, 700);
				sleep(100);
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