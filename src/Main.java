import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String rimResult;
        Scanner s = new Scanner(System.in);//создаём обьект сканер
        String str = s.nextLine();//просим записать выражение
        try {
            System.out.println(calc(str));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String calc(String input) throws Exception{
        String[] expression = input.split(" ");
        try {
            Integer x = numbersArab(expression[0]);
            try {
                if (expression.length < 3) {
                    throw new Exception("//т.к. строка не является математической операцией");
                }else {
                    Integer y = numbersArab(expression[2]);
                    try {
                        check(expression, x, y);
                        int r = result(expression[1], x, y);
                        String qwe = Integer.toString(r);
                        return qwe;
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("//т.к. используются одновременно разные системы счисления");
            }
        }catch (NumberFormatException e){
            try {
                Integer x = numbersRim(expression[0]);
                try {
                    if (expression.length < 3){
                        throw  new Exception("//т.к. строка не является математической операцией");
                    }else {
                        Integer y = numbersRim(expression[2]);
                        try {
                            check(expression, x, y);
                            int r = result(expression[1], x, y);
                            String qwe = resultRim(r);
                            return qwe;
                        }catch (Exception e1){
                            System.out.println(e1);
                        }
                    }
                }catch (NumberFormatException e1){
                    System.out.println("//т.к. используются одновременно разные системы счисления");
                }
            }catch (Exception e1){
                System.out.println(e1);
            }
        }
        String p = "";
        return p;
    }
    public static Integer numbersArab (String arab) throws NumberFormatException{
        Integer xArab = Integer.parseInt(arab);
        return xArab;
    }

    public static Integer numbersRim (String rim) throws Exception{
        Integer xRim;
        switch (rim) {
            case ("I"):
                xRim = 1;
                return xRim;
            case ("II"):
                xRim = 2;
                return xRim;
            case ("III"):
                xRim = 3;
                return xRim;
            case ("IV"):
                xRim = 4;
                return xRim;
            case ("V"):
                xRim = 5;
                return xRim;
            case ("VI"):
                xRim = 6;
                return xRim;
            case ("VII"):
                xRim = 7;
                return xRim;
            case ("VIII"):
                xRim = 8;
                return xRim;
            case ("IX"):
                xRim = 9;
                return xRim;
            case ("X"):
                xRim = 10;
                return xRim;
            default:
                throw new Exception("//т.к. ты ввёл какую то билибирду");
        }
    }
    public static void check(String[] expression, int x, int y) throws Exception{
        if (x<1 || x>10 || y<1 || y>10){
            throw new Exception("//т.к. переменные не соответствуют условию возможных чисел");
        } else if (expression.length > 3) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
    public static int result(String znak, Integer x, Integer y) {

        int result;

        switch (znak) {
            case "+":
                result = x + y;
                return result;
            case "-":
                result = x - y;
                return result;
            case "*":
                result = x * y;
                return result;
            case "/":
                result = x / y;
                return result;
            default:
                throw new RuntimeException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
    public static String resultRim(int r){
        String[] rimskieResultati = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "l",
                            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String res = rimskieResultati[r];
        return res;
    }

}