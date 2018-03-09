package model;

import java.io.Serializable;

public class HealthCheckLogic implements Serializable {

	private double bmi;
	
	public void HealthCheckLogic() {
		
	}
			public double calculateBmi(double hight, double weight) {
		return bmi = weight / (hight / 100 * hight / 100);
	}
	
}
