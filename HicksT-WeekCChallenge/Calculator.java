public class Calculator {
      
   double z = 0;
   
	public double add(double arg0, double arg1) {
		
      z = arg0 + arg1;
      
      System.out.println(arg0 + " + " + arg1 + " = " + z);
      
      return z;
	}

	public double subtract(double arg0, double arg1) {
		
      double z = arg0 - arg1;
      
      System.out.println(arg0 + " - " + arg1 + " = " + z);
      
      return z;
	}

	public double multiply(double arg0, double arg1) {
		
      double z = arg0 * arg1;
      
      System.out.println(arg0 + " * " + arg1 + " = " + z);
      
      return z;
	}

	public double divide(double arg0, double arg1) {
		 
      double z = arg0 / arg1;
      
      System.out.println(arg0 + " / " + arg1 + " = " + z);
      
      return z;
	}
   
   public double getZ(){
      return this.z;
   }
   public void setZ(){
      this.z = z; 
   }
   

}