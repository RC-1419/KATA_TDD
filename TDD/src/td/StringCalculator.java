package td;

public class StringCalculator {
	public int Add(String numbers) {
	    int sum = 0;
	    String[] number_array = new String[100];
	    if(numbers.equals("")) {
	        return 0;
	    }
	    else if(numbers.contains("//")) {
	        number_array = numbers.split("\n");
	        String sym = number_array[0];
	        char delimiter = sym.charAt(2);
	        String value = number_array[1];
	        number_array = value.split(""+delimiter);
	    }
	    else if(numbers.contains(",\n")){
	                return 0;
	            }
	    else if(numbers.contains("\n")){
	       numbers = numbers.replace('\n',',');
	       number_array = numbers.split(",");
	    }
	    else if(numbers.contains(",")) {
	        number_array = numbers.split(",");
	    }
	    String negative_string = "";
	    for(int i = 0; i < number_array.length; i++){
	        int num = Integer.parseInt(number_array[i]);
	        if(num>1000){
	            sum += 0;
	            continue;
	        }
	        else if(num<0) {
	            negative_string = number_array[i] + " ";
	        }
	        sum += num;
	    }
	    if(!negative_string.equals("")) {
	        //throw new NumberFormatException("negatives not allowed - [" + negative_string + "]");
	        throw new NumberFormatException("negatives not allowed");
	    }
	    return sum;
	}
}