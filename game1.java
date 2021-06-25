import java.util.*;
import java.util.Random;
import java.util.ArrayList;

class game1{

	static ArrayList <Integer> playerposition = new ArrayList <Integer>();
	static ArrayList <Integer> cpuposition = new ArrayList <Integer>();
	public static void main(String[]args)
	{
		char[][] gameB=
		{
		{' ','|',' ','|',' '},
		{'-','+','-','+',' '},
		{' ','|',' ','|',' '},
		{'-','+','-','+',' '},
		{' ','|',' ','|',' '},
		};
		printBoard(gameB);
		char choice;
Scanner sc=new Scanner(System.in);

		while(true)
		{		
		System.out.println("Enter the position that you want to  put 'X'");
		int position=sc.nextInt();
		while(playerposition.contains(position)|| cpuposition.contains(position))
		{
			System.out.println("Enter another position");
			position=sc.nextInt();
			}
			placeMark(gameB,position,"player");
		printBoard(gameB);
		String result=isWinner();
		if(result.length()>0)
		{
			System.out.println(result);
			break;
		}
		
		Random random=new Random();
		int cpuP=random.nextInt(9)+1;
		while(playerposition.contains(cpuP)|| cpuposition.contains(cpuP))
		{
			cpuP = random.nextInt(9)+1;
		}
		System.out.print("Computers move : \n");
		placeMark(gameB,cpuP,"cpu");
		printBoard(gameB);
		result=isWinner();
		if(result.length()>0)
		{
			System.out.println(result);
			break;
		}
		
		 }}
	
	public static void printBoard(char[][] gameB)
	{
	for(int i=0; i<5; i++)
	{
		for(int j=0; j<5; j++)
		{
			System.out.print(" "+gameB[i][j]);
		}
		System.out.println();
	}
	}
	public static String isWinner()
	{
		List toprow=Arrays.asList(1,2,3);
		List midrow=Arrays.asList(4,5,6);
		List botrow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(7,5,3);

		List<List> winning= new ArrayList<List>();
		winning.add(toprow);
		winning.add(midrow);
		winning.add(botrow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);

		for(List l:winning)
		{
			if(playerposition.containsAll(l))
			{
				return "Congratulations You WON This game!";
			}
			else if(cpuposition.containsAll(l))
			{
				return "OOPS YOU LOSE the game!";
			}
		}
		if(playerposition.size()+cpuposition.size()==9){
				return " This is TIE";
			}
		else{return"";}

	
}
	public static void placeMark(char[][] gameB,int position,String user)
	{

		char symbol=' ';
		if(user.equals("player"))
		{
			symbol='X';
			playerposition.add(position);
		}else if(user.equals("cpu"))
		{
			symbol='0';
			cpuposition.add(position);
		}

		switch (position)
		{
			case 1:
			gameB[0][0]=symbol;
			break;

			case 2:
			gameB[0][2]=symbol;
			break;

			case 3:
			gameB[0][4]=symbol;
			break;

			case 4:
			gameB[2][0]=symbol;
			break;

			case 5:
			gameB[2][2]=symbol;
			break;

			case 6:
			gameB[2][4]=symbol;
			break;

			case 7:
			gameB[4][0]=symbol;
			break;

			case 8:
			gameB[4][2]=symbol;
			break;

			case 9:
			gameB[4][4]=symbol;
			break;
		}
	}
	
}

