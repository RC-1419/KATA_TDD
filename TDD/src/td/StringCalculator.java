package td;

public class StringCalculator {
	public int Add(String numbers) {
		int sum = 0;
		if(numbers.equals("")) {
			return 0;
		}
		else if(numbers.contains(",\n")){
            return 0;
        }
		else if(numbers.contains("\n")){
		    numbers = numbers.replace('\n',',');
		}
		String[] number_array = numbers.split(",");
		for(int i = 0; i < number_array.length; i++){
		    sum += Integer.parseInt(number_array[i]);
		}
		return sum;
	}
}



