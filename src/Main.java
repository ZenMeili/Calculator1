import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите ваше выражение в формате a+b: ");
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        Main main1 = new Main();
        main1.calc(exp);
    }
    public static String calc (String input){
        RomanNum romanNum = new RomanNum();

        String[] operation = {"+", "-", "/", "*"};
        String[] regOperation = {"\\+", "-", "/", "\\*"};


        int opIndex = -1;
        int indOp = 0;


        for( int i = 0; i < operation.length; i++ ) {
            if( input.contains(operation[i])){
                opIndex =i;
                break;
            }
        }

        if(opIndex == -1){
            System.out.println("Вы ввели некорректное выражение!");
        }

        String[] data = input.split(regOperation[opIndex]);


        if(romanNum.isRoman(data[0]) == romanNum.isRoman(data[1])) {
            int a, b;

            boolean isRoman = romanNum.isRoman(data[0]);
            if(isRoman){
                a = romanNum.romanToInt(data[0]);
                b = romanNum.romanToInt(data[1]);
                if(opIndex == 1 && a <= b){
                    System.out.println("Не существует римских отрицательных чисел!");
                    return input;
                }
            }else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if ((a<0 || a>10) || (b<0 || b>10)){
                System.out.println("Вводимые значения не должны быть больше 10 или меньше 0");
            }else{
                int result = 0;
                switch (operation[opIndex]){
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                if(isRoman) {
                    System.out.println(romanNum.intToRoman(result));
                }else{
                    System.out.println(result);
                }
            }
        }
        else {
            System.out.println("Числа из выражения в разных форматах!");
        }
        return input;
    }
}