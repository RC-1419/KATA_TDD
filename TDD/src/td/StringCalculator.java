package td;

public class StringCalculator {
    public int Add(String numbers) {
        int sum = 0;
        String[] number_array = new String[100];
        
        // Variable 'numbers' is empty
        if(numbers.equals("")) {
            return 0;
        }
        
        // Variable 'numbers' contains '//' 
        else if(numbers.contains("//")) {
            number_array = numbers.split("\n");
            
            // If variable 'numbers' also contains '[ ]' 
            if(numbers.contains("[") && numbers.contains("]")){
                String number = number_array[0];;
                number = number.replace("//","");
                number = number.replace("[","");
                number = number.replace("]","");
                String value = number_array[1];
                char to_find = number.charAt(0);
                char to_next = number.charAt(1);
                String delimiter = "";
                
                // It finds if we have same delimiter being repeating like "***"
                if(to_find == to_next){
                	
                	// It checks whether the variable 'value' contains the delimiter(whose length > 1) or not
                    if(number.contains(""+to_find)){
                        for(int i=0;i<number.length();i++){
                            delimiter += "\\"+to_find;
                        }
                        number_array = value.split(delimiter);
                    }
                    
                    // If the variable 'value' has only a single delimiter
                    else{
                        number_array = value.split(number);
                    }
                }
                
                //It finds if we have different delimiters like "%#"
                else{
                    String arr[] = number.split("");
                    for(int i=0;i<arr.length;i++){
                        arr[i] = "\\"+arr[i];
                    }
                    delimiter = arr[0] + "|" + arr[1];
                    number_array = value.split(delimiter);
                }
            }
            
            // If variable 'numbers' doesn't contains '[ ]' 
            else{
                String sym = number_array[0];
                char delimiter = sym.charAt(2);
                String value = number_array[1];
                number_array = value.split(""+delimiter);
            }
        }
        
        // It checks if the variable 'numbers' contains ",\n" as it is an invalid condition
        else if(numbers.contains(",\n")){
                    return 0;
                }
        
        // It checks if the variable 'numbers' contains "\n"
        else if(numbers.contains("\n")){
           numbers = numbers.replace('\n',',');
           number_array = numbers.split(",");
        }
        
        // It checks if the variable 'numbers' contains ","
        else if(numbers.contains(",")) {
            number_array = numbers.split(",");
        }
        
        String negative_string = "";        // A variable to hold all negative numbers
        
        for(int i = 0; i < number_array.length; i++){
            int num = Integer.parseInt(number_array[i]);
            
            // Checks if the number is < 1000 or not, which is our condition
            if(num>1000){
                sum += 0;
                continue;
            }
            else if(num<0) {
                negative_string += number_array[i] + " ";
            }
            sum += num;
        }
        
        // If determines whether we have empty "negative_string" variable or not
        if(!negative_string.equals("")) {
            throw new RuntimeException("negatives not allowed- " + negative_string);
        }
        return sum;
    }
}
