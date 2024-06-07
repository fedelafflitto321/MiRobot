package ar.edu.et7;

import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;
import robocode.HitWallEvent;
import robocode.BulletHitEvent;

/**
 * @author Federico Lafflitto y Santiago Beron
 * 
 */

public class Sanfe extends Robot {

	public void run() {

		while (true) {

			// Desplaza el robot 100 pixels hacia adelante
			//ahead(100);

			// Gira el cañon hacia la derecha 90 grados
			turnGunRight(190);

			// Dispara con la maxima potencia
			fire(Rules.MAX_BULLET_POWER);

			// Desplaza el robot 100 pixels hacia adelante
			ahead(150);

			// Gira el cañon hacia la derecha 180 grados
			turnGunLeft(1000);

			// Dispara con la maxima potencia
			fire(Rules.MAX_BULLET_POWER);

			// Gira hacia la izquierda 90 grados
			turnLeft(200);

			// Gira el radar hacia la izquierda 15 grados
			turnRadarLeft(550);
			
			// Escanear otros robots
			scan();
			
		}
	}

	public void onScannedRobot(ScannedRobotEvent event) {

		// Al escanear un robot
		if (event.getDistance() < 100) {
			// Disparar
			fire(3);
		} else {
			// Disparar
			fire(1);
		}
	}
	
	   public void onHitWall(HitWallEvent event) {

		   // Al colisionar contra una pared
	       out.println("Choque contra la pared en direccion " + event.getBearing() + " degrees.");
	   }	
	   
	   public void onBulletHit(BulletHitEvent event) {
		   
		   // Al acertar un disparo
	       out.println("Le acerte un disparo a " + event.getName() + "!");
	   }	   
}
