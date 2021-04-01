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
            if(numbers.contains("[") && numbers.contains("]")){
                String number = number_array[0];;
                number = number.replace("//","");
                number = number.replace("[","");
                number = number.replace("]","");
                String value = number_array[1];
                char to_find = number.charAt(0);
                char to_next = number.charAt(1);
                String delimiter = "";
                if(to_find == to_next){
                    if(number.contains(""+to_find)){
                        for(int i=0;i<number.length();i++){
                            delimiter += "\\"+to_find;
                        }
                        number_array = value.split(delimiter);
                    }
                    else{
                        number_array = value.split(number);
                    }
                }
                else{
                    String arr[] = number.split("");
                    for(int i=0;i<arr.length;i++){
                        arr[i] = "\\"+arr[i];
                    }
                    delimiter = arr[0] + "|" + arr[1];
                    number_array = value.split(delimiter);
                }
            }
            else{
                String sym = number_array[0];
                char delimiter = sym.charAt(2);
                String value = number_array[1];
                number_array = value.split(""+delimiter);
            }
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
                negative_string += number_array[i] + " ";
            }
            sum += num;
        }
        if(!negative_string.equals("")) {
            throw new RuntimeException("negatives not allowed- " + negative_string);
        }
        return sum;
    }
}