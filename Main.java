import java.util.Scanner;
class EmptyStringException extends RuntimeException {
    EmptyStringException(String msg){
        super(msg);
    }
}
class ArabToRom {
    enum Romcat {
        I(1), IV(4), V(5), IX(9),
        X(10), XL(40), L(50),
        XC(90), C(100), CD(400),
        D(500), CM(900), M(1000);
        int v;
        Romcat(int val) {
            this.v = val;
        }
    };
    static String rom(int number) {
        if( number <= 0) {
            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("в римской системе счисления" +
                    " нет отрицательных чисел");
            System.err.println();
            System.err.println();
            System.out.print("throws Exception // ");
            throw new IllegalArgumentException();}
        StringBuilder sb = new StringBuilder();
        Romcat[] values = Romcat.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (number >= values[i].v) {
                sb.append(values[i]);
                //number = number - values[i].v;
                number -= values[i].v;
            }
        }
        return sb.toString();
    }
}
class RomToArab {
     static void main(String[] args) {
        rom2arab(roman);
    }
    static String roman="";
    static String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static int rom2arab(String roman) {
        int result = 0;
        for (int i = 0; i < numerals.length; i++) {
            while (roman.startsWith(numerals[i])) {
                result += values[i];
                roman = roman.substring(numerals[i].length());
            }
        }
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = "";
        in = new Scanner(System.in);
        for(;;) {
        //in = new Scanner(System.in);
        System.out.println();
        System.out.println("Input: ");System.out.println();
        input = in.nextLine();
        //in.close();
        checkForEmpty(input);
        checkForIllegal(input);
        input = severalChecks(input);
        calc(input);}
    }
    public static String calc(String input)

    {try{checkForEmpty(input);} catch (EmptyStringException e) {
            System.err.println("Error - Illegal expression");
            System.err.println("");
            throw new EmptyStringException("");
        }
        int flagRomanExpression = 0;
        flagRomanExpression = checkToRoman(input);
        if (flagRomanExpression==1){
        input=input.replaceAll("[ ]", "");
        String [] sRomArr = input.split("\\+|-|\\*|/");
        String o = input.replaceAll("[ MDCLXVI]", "");
        String a = sRomArr[0]; String b = sRomArr[1];
        int r1 = RomToArab.rom2arab(a);
        int r2 = RomToArab.rom2arab(b);
        String s1=String.valueOf(r1);
        String s2=String.valueOf(r2);
        input = r1+o+r2;
        }
        input = input.replace(" ", "");
        String [] sArr = input.split("\\+|-|\\*|/");
        int c = 0, a = Integer.parseInt(sArr[0]);
        int b = Integer.parseInt(sArr[1]);
        if (a>10 | b>10) {
            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("операнды не должны быть больше 10");
            System.out.print("throws Exception // ");
            System.err.println();
            System.err.println();
            throw new IllegalArgumentException();}
        if (input.contains("+")) {c = a + b;}
        if (input.contains("-")) {c = a - b;}
        if (input.contains("*")) {c = a * b;}
        if (input.contains("/")) {c = a / b;}
        int number = c;
        String result = String.valueOf(c);
        if (flagRomanExpression==1){
            String romResult = ArabToRom.rom(number);
            result = romResult;
        }
        if (flagRomanExpression ==1 && number<1) {
            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("в римской системе счисления" +
                    " нет отрицательных чисел");
            System.err.println();
            System.err.println();
            System.out.print("throws Exception // ");
            throw new IllegalArgumentException();}
        System.out.println();
        System.out.println("Output:");
        System.out.println();
        System.out.println(result);
        return result;
    }
    static void checkForEmpty(String input)
            throws EmptyStringException {
        if (input == null || input.isEmpty() ||
                input.trim().length() == 0) {
            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("выражение не может быть пустым");
            System.err.println();
            System.err.println();
            System.out.print("throws Exception // ");
            throw new EmptyStringException("");
        } else input = input;
    }
    static void checkForIllegal(String input) {
        String check1  = input.replaceAll
                ("[ 0123456789MDCLXVI\\+\\-\\*/]", "");
        if (check1.length()>0) {
            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("строка не является математическим выражением");
            System.err.println();
            System.err.println();
            System.out.print("throws Exception // ");
            throw new IllegalArgumentException();}
    }
    static String severalChecks(String input) {
        /**
         * ***********************************************************
         *  check for illegal characters:
         *  **********************************************************
         */
        String check1  = input.replaceAll
                ("[ 0123456789MDCLXVI\\+\\-\\*/]", "");
        if (check1.length()>0) {

            throw new IllegalArgumentException();}
        /**
         * ***********************************************************
         *  check for together use roman and arab numbers:
         *  **********************************************************
         */
        String setRomChar = new String("IVXLCDM");
        int countArab = 0;
        for (int i=0; i < 10; i++) {
            String str = String.valueOf(i);
            boolean cont = input.contains(str);
            if (cont == true) {
                countArab++;
            }
        }
        int countRom = 0;
        char [] romArr = setRomChar.toCharArray();

        for (int i=0; i < 7; i++) {
            String str = String.valueOf(romArr[i]);
            boolean cont = input.contains(str);
            if (cont == true) {
                countRom++;
            }
        }
        if (countArab > 0 && countRom > 0) {

            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("операнды не могут быть" +
                    " из разных систем счисления");
            System.err.println();
            System.err.println();
            System.out.print("throws Exception // ");
            throw new IllegalArgumentException();
        }
        /**
         * **********************************************
         *  a little check for correctly expression:
         *
         *  *********************************************
         */
        String [] sArr = input.split("\\+|-|\\*|/");
        if (sArr.length != 2) {
            System.out.println();
            System.out.println("Output:");
            System.out.println();
            System.err.print("формат не соответсвует заданию");
            System.err.println();
            System.err.println();
            System.out.print("throws Exception // ");
            throw new IllegalArgumentException();}
        return input;
    }
    static String convInput (String input) {
        input=input.replaceAll("[ ]", "");
        String [] sRomArr = input.split("\\+|-|\\*|/");
        String o = input.replaceAll("[ MDCLXVI]", "");
        String a = sRomArr[0]; String b = sRomArr[1];
        int r1 = RomToArab.rom2arab(a);
        int r2 = RomToArab.rom2arab(b);
        String s1=String.valueOf(r1);
        String s2=String.valueOf(r2);
        input = r1+o+r2;
        return input;}
    static int checkToRoman (String input) {
        int flagRomanExpression=0;
        String checkRom  = input.replaceAll
                ("[ MDCLXVI\\+\\-\\*/]", "");
        int lcheckRom=checkRom.length();
        if (lcheckRom==0){flagRomanExpression++;}
        return flagRomanExpression;
    }
}