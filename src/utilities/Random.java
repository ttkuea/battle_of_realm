package utilities;

public class Random {
	public static int randInt(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

}