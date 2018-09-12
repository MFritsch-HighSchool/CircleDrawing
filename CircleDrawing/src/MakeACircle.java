import java.util.Scanner;
import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;


public class MakeACircle  implements Directions{
	Robot r = new Robot(1,1,North,-1);
	int sideDist;
	public static void main(String[] args) {
		MakeACircle temp = new MakeACircle();
		temp.prompt();
	}

	private void prompt() {
		System.out.println("Give me the radius of your cicle: ");
		Scanner keyboard  = new Scanner(System.in);
		int rad = keyboard.nextInt();
		World.setVisible(true);
		World.setSize(rad*2+1,rad*2+1);
		World.setDelay(0);
		moveToLoc(rad);
		circle(rad);	
	}
	//NOTE! MAKE IT TURN AFTER ONE FOURTH

	private void moveToLoc(int rad) {
		while(r.facingEast() == false)
			r.turnLeft();
		for(int i = rad; i>0; i--){
			r.move();
		}
		r.turnLeft();
		for(int i = rad; i>0; i--){
			r.move();
		}
		System.out.println("At loc");
	}

	private void circle(int rad) {
		for(int x = 4; x > 0; x--){
			sideDist = 1;
			for(int looper = rad; looper > 0; looper--){
				drawSideFirst(r, rad, sideDist);
				r.move();
				sideDist++;
				r.turnLeft();
			}
			r.turnLeft();
			for(int looper = rad; looper > 0; looper--){
				r.move();
			}
		}
		
		for(int x = 4; x > 0; x--){
			sideDist = 1;
			for(int looper = rad; looper > 0; looper--){
				drawSideSecond(r, rad, sideDist);
				r.move();
				sideDist++;
				turnRight();
			}
			turnRight();
			for(int looper = rad; looper > 0; looper--){
				r.move();
			}
		}
	}

	private void drawSideFirst(Robot r, int rad, int sideDist) {
		System.out.println("Current side distance is "+sideDist);
		double bsquared = (rad*rad)-(sideDist * sideDist);
		double moveb = Math.sqrt(bsquared);
		for(int x = (int) moveb-1; x > 0; x--)
			r.move();
		r.putBeeper();
		r.turnLeft();
		r.turnLeft();
		for(int x = (int) moveb-1; x > 0; x--)
			r.move();
		r.turnLeft();
	}
	
	private void drawSideSecond(Robot r, int rad, int sideDist) {
		System.out.println("Current side distance is "+sideDist);
		double bsquared = (rad*rad)-(sideDist * sideDist);
		double moveb = Math.sqrt(bsquared);
		for(int x = (int) moveb-1; x > 0; x--)
			r.move();
		r.putBeeper();
		r.turnLeft();
		r.turnLeft();
		for(int x = (int) moveb-1; x > 0; x--)
			r.move();
		turnRight();
	}
	
	private void turnRight(){
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
	}
	
}
