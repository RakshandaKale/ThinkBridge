
import java.io.*;
import java.util.InputMismatchException;

public class NumberToCurrencyConverter {
	static String  units_values [] = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ",
									"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ",
									"Seventeen ","Eighteen ","Nineteen "};
	
	static String tens_values [] = {"","","Twenty ","Thirty ","Fourty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
	
	static String wordsConversion(Double number) {
		
		String result="";
		result=result+numberToWordsConversion((int)((number/100000)%100),"Lakh ");
		result=result+numberToWordsConversion((int)((number/1000)%100),"Thousand ");
		result=result+numberToWordsConversion((int)((number/100)%10),"Hundred ");
		
		if(number>100 && number%100>0) {
			result=result+"And ";
		}
		result=result+numberToWordsConversion((int)(number%100),"");
		return result;
	}
	
	static String numberToWordsConversion(int number,String str) {
		String result="";
		if(number>19) {
			result=result+tens_values[number/10]+units_values[number%10];
		}else {
			result=result+units_values[number];
		}
		if(number!=0) {
			result=result+str;
		}
		return result;
	}
	
	public static void main(String[] args)throws IOException {
		System.out.println("----------Hello User-----------");
		System.out.println("*******************************");
		String option;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));;
		do{
			try{
			   System.out.println("\nEnter the Value :");
			   String temp;
			   double value=0.0,decnum=0.0;
			   int decimalIndex=0;
			   value=Double.parseDouble(br.readLine());
			   if(value==0){
				   System.out.print("Rs.Zero Only");
			   }
			   while(value<0.0 || value >999999.99 ){
				   System.out.println("\nEnter a valid currency in between 0.0 to 999999.99:"); 
				   value=Double.parseDouble(br.readLine());
			   }
			   temp = String.valueOf(value);
			   decnum = (double) (value-Math.floor(value));
			   decimalIndex = temp.indexOf(".");
			   String output=wordsConversion(value);
			   if(decnum>0)
			   {
				   System.out.print("Rs."+output);
				   if(decimalIndex+3>temp.length()){
					   System.out.print(temp.substring(decimalIndex+1,decimalIndex+2));
					   System.out.println("0/100 ONLY.");
				   }
				   else{
				   		System.out.print(temp.substring(decimalIndex+1,decimalIndex+3));
				   		System.out.println("/100 ONLY.");
				   }
			   	}
			    else if(value!=0)
			    {
				   System.out.print("Rs."+output+"ONLY.");
			    }
			}
			catch(NumberFormatException e1){
				System.out.println("Invalid Number Enter numeric value");
			}
			catch(InputMismatchException e2){
				System.out.println(e2.getMessage());
			}
		System.out.println("\nDo You Want to Continue (Y/N)?"); 
		option=br.readLine();
		}while(option.equals("Y")||option.equals("y"));
	    System.out.println("Exit");
	}
}
