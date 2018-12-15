package constants;

public class Constant {
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 768;
	
	
											//Hp,atk,def,spd,cri
	public static final int[][] warriorStat = {{0, 0, 0, 0, 0},
											   {70,  12, 10, 10, 15}, //1 
											   {100, 19, 15, 12, 15}, //2
											   {120, 23, 20, 15, 15}, //3
											   {140, 26, 25, 18, 15}, //4
											   {160, 31, 30, 21, 15}, //5
											   {190, 35, 35, 23, 15}};//6
	
	public static final int[][] wizardStat = {{0, 0, 0, 0, 0},
											  {70,  10, 7,  15, 10},
											  {85,  13, 12, 16, 10},
											  {100, 16, 15, 18, 10},
											  {115, 19, 18, 21, 10},
											  {130, 22, 21, 23, 10},
											  {145, 25, 23, 25, 10}};
	
	public static final int[][] archerStat = {{0, 0, 0, 0, 0},
											  {70,  16, 10, 12, 18},
											  {85,  21, 10, 15, 18},
											  {100, 24, 15, 18, 18},
											  {115, 27, 15, 21, 18},
											  {130, 34, 15, 21, 18},
											  {145, 37, 18, 22, 18}};
	
}
