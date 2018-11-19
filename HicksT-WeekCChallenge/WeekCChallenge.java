import java.util.Scanner;

public class WeekCChallenge extends Calculator {

	public static void main(String[] args){
		
      double x = 0;
      double y = 0;
      
      
		//1. create a new instance of the Calculator class
      
      Calculator calc = new Calculator(); 
      
      System.out.println("----------------------------");
      System.out.println("Welcome to Troy's Calculator");
      System.out.println("----------------------------");
      double[] array = getInputValues(x, y);
      x = array[0];
      y = array[1];

		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
      System.out.println("\nResults\n--------------------------------------");
		double additionResult = calc.add(x,y);
		double subtractionResult = calc.subtract(x,y);
		double multiplicationResult = calc.multiply(x,y);
		double divisionResult = calc.divide(x,y);

		//3. print the value of each of these variables to the console with a descriptive message
		

		//4. implement the static fizzBuzz method in this class and call it from the main method
	   
      
      System.out.println("\n-------------------------------------" +
                       "\nFIZZZZZZZZZZZZ BUZZZZZZZZZZZZZZZZZZZZ" +
                       "\n-------------------------------------");
      
      
      int X = 0;
      int Y = 0;
      
      int[] array2 = getFizzBuzzM_N(X,Y);
      X = array2[0];
      Y = array2[1];
      
      int[] array3 = getFizzBuzzNumbers();
      
      int length = array3.length;
      
      String[] array4 = getFizzBuzzTerms(length); 
            
      for(int i=X; i < Y; i++){
         System.out.println(i);     
         for(int k = 0; k < length ; k++){
            
            if(i % array3[k] == 0 && i != 0){
               System.out.println(array4[k]);
            }
         }
      }
     
   }
   
   //Get Terms[]
   //---------------------------------------------------------------------------------------
   
   public static String[] getFizzBuzzTerms(int arrLength){
      Scanner sc = new Scanner(System.in);
      String[] terms = new String[arrLength];
      

      System.out.println();
      for (int i = 0; i < arrLength ; i++){
         System.out.println("Enter Replacement Value Term: ");
         terms[i] = sc.nextLine();
      }
      
      return terms;
   }
   
     //---------------------------------------------------------------------------------------
   
   //Get Numbers[]
   
   public static int[] getFizzBuzzNumbers(){
      
      Scanner sc3 = new Scanner(System.in);
      
      System.out.println("\nHow many values for replacement? ");
      
      int z = sc3.nextInt();
      
      int[] temp = new int[z];
      for(int i = 0; i < z; i++){
         
         System.out.print("Enter Replacement Value (m): ");
         temp[i] = sc3.nextInt();
      }
      
      return temp;
   }

   
   
   //Get M-N
   //---------------------------------------------------------------------------------------
   
   public static int[] getFizzBuzzM_N(int x, int y){
      
      Scanner sc2 = new Scanner(System.in);
      System.out.println("Enter number Range from Low to High!");
      System.out.print("Enter Value (m): ");
      x = sc2.nextInt();
      System.out.print("Enter Value (n): ");
      y = sc2.nextInt();
      
      if (x > y){
         System.out.println("Emily: Please Place Numbers in order from Low to High");
         
         System.out.print("Enter Value (m): ");
         x = sc2.nextInt();
         System.out.print("Enter Value (n): ");
         y = sc2.nextInt();
      }
            
      int[] array = {x,y};
      return array;
   }
   
   //---------------------------------------------------------------------------------------
	
   public static double[] getInputValues(double x, double  y){
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Enter Value (1): ");
      x = sc.nextDouble();
      System.out.print("Enter Value (2): ");
      y = sc.nextDouble();
      
      
      double[] array = {x,y};  
      
      return array;
   }
   
   
   //---------------------------------------------------------------------------------------

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
      
	}
   
   
   
    
   
   
}