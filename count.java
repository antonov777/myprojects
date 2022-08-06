
public class count {
    public static void main(String[] args) {



        String s="import java.util.Scanner;\n" +
                "class EmptyStringException extends RuntimeException {\n" +
                "    EmptyStringException(String msg){\n" +
                "        super(msg);\n" +
                "    }\n" +
                "}\n" +
                "class ArabToRom {\n" +
                "    enum Romcat {\n" +
                "        I(1), IV(4), V(5), IX(9),\n" +
                "        X(10), XL(40), L(50),\n" +
                "        XC(90), C(100), CD(400),\n" +
                "        D(500), CM(900), M(1000);\n" +
                "        int v;\n" +
                "        Romcat(int val) {\n" +
                "            this.v = val;\n" +
                "        }\n" +
                "    };\n" +
                "    static String rom(int number) {\n" +
                "        if( number <= 0) {\n" +
                "            System.out.println();\n" +
                "            System.out.println(\"Output:\");\n" +
                "            System.out.println();\n" +
                "            System.err.print(\"в римской системе счисления нет отрицательных чисел\");\n" +
                "            System.err.println();\n" +
                "            System.err.println();\n" +
                "            System.out.print(\"throws Exception // \");\n" +
                "            throw new IllegalArgumentException();}\n" +
                "        StringBuilder sb = new StringBuilder();\n" +
                "        Romcat[] values = Romcat.values();\n" +
                "        for (int i = values.length - 1; i >= 0; i--) {\n" +
                "            while (number >= values[i].v) {\n" +
                "                sb.append(values[i]);\n" +
                "                //number = number - values[i].v;\n" +
                "                number -= values[i].v;\n" +
                "            }\n" +
                "        }\n" +
                "        return sb.toString();\n" +
                "    }\n" +
                "}\n" +
                "class RomToArab {\n" +
                "     static void main(String[] args) {\n" +
                "        rom2arab(roman);\n" +
                "    }\n" +
                "    static String roman=\"\";\n" +
                "    static String[] numerals = {\"M\", \"CM\", \"D\", \"CD\", \"C\", \"XC\", \"L\", \"XL\", \"X\", \"IX\", \"V\", \"IV\", \"I\"};\n" +
                "    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};\n" +
                "    public static int rom2arab(String roman) {\n" +
                "        int result = 0;\n" +
                "        for (int i = 0; i < numerals.length; i++) {\n" +
                "            while (roman.startsWith(numerals[i])) {\n" +
                "                result += values[i];\n" +
                "                roman = roman.substring(numerals[i].length());\n" +
                "            }\n" +
                "        }\n" +
                "        return result;\n" +
                "    }\n" +
                "}\n" +
                "class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Scanner in = new Scanner(System.in);\n" +
                "        System.out.println(\"Input: \");System.out.println();\n" +
                "        String input= in.nextLine(); in.close();\n" +
                "        checkForEmpty(input);\n" +
                "        checkForIllegal(input);\n" +
                "        input = severalChecks(input);\n" +
                "        calc(input);\n" +
                "    }\n" +
                "    public static String calc(String input)\n" +
                "\n" +
                "    {try{checkForEmpty(input);} catch (EmptyStringException e) {\n" +
                "            System.err.println(\"Error - Illegal expression\");\n" +
                "            System.err.println(\"\");\n" +
                "            throw new EmptyStringException(\"\");\n" +
                "        }\n" +
                "        int flagRomanExpression = 0;\n" +
                "        flagRomanExpression = checkToRoman(input);\n" +
                "        if (flagRomanExpression==1){\n" +
                "        input=input.replaceAll(\"[ ]\", \"\");\n" +
                "        String [] sRomArr = input.split(\"\\\\+|-|\\\\*|/\");\n" +
                "        String o = input.replaceAll(\"[ MDCLXVI]\", \"\");\n" +
                "        String a = sRomArr[0]; String b = sRomArr[1];\n" +
                "        int r1 = RomToArab.rom2arab(a);\n" +
                "        int r2 = RomToArab.rom2arab(b);\n" +
                "        String s1=String.valueOf(r1);\n" +
                "        String s2=String.valueOf(r2);\n" +
                "        input = r1+o+r2;\n" +
                "        }\n" +
                "        input = input.replace(\" \", \"\");\n" +
                "        String [] sArr = input.split(\"\\\\+|-|\\\\*|/\");\n" +
                "        int c = 0, a = Integer.parseInt(sArr[0]);\n" +
                "        int b = Integer.parseInt(sArr[1]);\n" +
                "        if (a>10 | b>10) {throw new IllegalArgumentException();}\n" +
                "        if (input.contains(\"+\")) {c = a + b;}\n" +
                "        if (input.contains(\"-\")) {c = a - b;}\n" +
                "        if (input.contains(\"*\")) {c = a * b;}\n" +
                "        if (input.contains(\"/\")) {c = a / b;}\n" +
                "        int number = c;\n" +
                "        String result = String.valueOf(c);\n" +
                "        if (flagRomanExpression==1){\n" +
                "            String romResult = ArabToRom.rom(number);\n" +
                "            result = romResult;\n" +
                "        }\n" +
                "        if (flagRomanExpression ==1 && number<1) {\n" +
                "            System.out.println();\n" +
                "            System.out.println(\"Output:\");\n" +
                "            System.out.println();\n" +
                "            System.err.print(\"в римской системе счисления нет отрицательных чисел\");\n" +
                "            System.err.println();\n" +
                "            System.err.println();\n" +
                "            System.out.print(\"throws Exception // \");\n" +
                "            throw new IllegalArgumentException();}\n" +
                "        System.out.println();\n" +
                "        System.out.println(\"Output:\");\n" +
                "        System.out.println();\n" +
                "        System.out.println(result);\n" +
                "        return result;\n" +
                "    }\n" +
                "    static void checkForEmpty(String input) throws EmptyStringException {\n" +
                "        if (input == null || input.isEmpty() || input.trim().length() == 0) {\n" +
                "            System.out.println();\n" +
                "            System.out.println(\"Output:\");\n" +
                "            System.out.println();\n" +
                "            System.err.print(\"выражение не может быть пустым\");\n" +
                "            System.err.println();\n" +
                "            System.err.println();\n" +
                "            System.out.print(\"throws Exception // \");\n" +
                "            throw new EmptyStringException(\"\");\n" +
                "        } else input = input;\n" +
                "    }\n" +
                "    static void checkForIllegal(String input) {\n" +
                "        String check1  = input.replaceAll\n" +
                "                (\"[ 0123456789MDCLXVI\\\\+\\\\-\\\\*/]\", \"\");\n" +
                "        if (check1.length()>0) {\n" +
                "            System.out.println();\n" +
                "            System.out.println(\"Output:\");\n" +
                "            System.out.println();\n" +
                "            System.err.print(\"строка не является математическим выражением\");\n" +
                "            System.err.println();\n" +
                "            System.err.println();\n" +
                "            System.out.print(\"throws Exception // \");\n" +
                "            throw new IllegalArgumentException();}\n" +
                "    }\n" +
                "    static String severalChecks(String input) {\n" +
                "        /**\n" +
                "         * ***********************************************************\n" +
                "         *  check for illegal characters:\n" +
                "         *  **********************************************************\n" +
                "         */\n" +
                "        String check1  = input.replaceAll\n" +
                "                (\"[ 0123456789MDCLXVI\\\\+\\\\-\\\\*/]\", \"\");\n" +
                "        if (check1.length()>0) {\n" +
                "\n" +
                "            throw new IllegalArgumentException();}\n" +
                "        /**\n" +
                "         * ***********************************************************\n" +
                "         *  check for together use roman and arab numbers:\n" +
                "         *  **********************************************************\n" +
                "         */\n" +
                "        String setRomChar = new String(\"IVXLCDM\");\n" +
                "        int countArab = 0;\n" +
                "        for (int i=0; i < 10; i++) {\n" +
                "            String str = String.valueOf(i);\n" +
                "            boolean cont = input.contains(str);\n" +
                "            if (cont == true) {\n" +
                "                countArab++;\n" +
                "            }\n" +
                "        }\n" +
                "        int countRom = 0;\n" +
                "        char [] romArr = setRomChar.toCharArray();\n" +
                "\n" +
                "        for (int i=0; i < 7; i++) {\n" +
                "            String str = String.valueOf(romArr[i]);\n" +
                "            boolean cont = input.contains(str);\n" +
                "            if (cont == true) {\n" +
                "                countRom++;\n" +
                "            }\n" +
                "        }\n" +
                "        if (countArab > 0 && countRom > 0) {\n" +
                "\n" +
                "            System.out.println();\n" +
                "            System.out.println(\"Output:\");\n" +
                "            System.out.println();\n" +
                "            System.err.print(\"операнды не могут быть из разных систем счисления\");\n" +
                "            System.err.println();\n" +
                "            System.err.println();\n" +
                "            System.out.print(\"throws Exception // \");\n" +
                "            throw new IllegalArgumentException();\n" +
                "        }\n" +
                "        /**\n" +
                "         * ***********************************************************\n" +
                "         *  a little check for correctly expression:\n" +
                "         *\n" +
                "         *  **********************************************************\n" +
                "         */\n" +
                "        String [] sArr = input.split(\"\\\\+|-|\\\\*|/\");\n" +
                "        if (sArr.length != 2) {\n" +
                "            System.out.println();\n" +
                "            System.out.println(\"Output:\");\n" +
                "            System.out.println();\n" +
                "            System.err.print(\"формат не соответсвует заданию\");\n" +
                "            System.err.println();\n" +
                "            System.err.println();\n" +
                "            System.out.print(\"throws Exception // \");\n" +
                "            throw new IllegalArgumentException();}\n" +
                "        return input;\n" +
                "    }\n" +
                "    static String convInput (String input) {\n" +
                "        input=input.replaceAll(\"[ ]\", \"\");\n" +
                "        String [] sRomArr = input.split(\"\\\\+|-|\\\\*|/\");\n" +
                "        String o = input.replaceAll(\"[ MDCLXVI]\", \"\");\n" +
                "        String a = sRomArr[0]; String b = sRomArr[1];\n" +
                "        int r1 = RomToArab.rom2arab(a);\n" +
                "        int r2 = RomToArab.rom2arab(b);\n" +
                "        String s1=String.valueOf(r1);\n" +
                "        String s2=String.valueOf(r2);\n" +
                "        input = r1+o+r2;\n" +
                "        return input;\n" +
                "    }\n" +
                "    static int checkToRoman (String input) {\n" +
                "        int flagRomanExpression=0;\n" +
                "        String checkRom  = input.replaceAll\n" +
                "                (\"[ MDCLXVI\\\\+\\\\-\\\\*/]\", \"\");\n" +
                "        int lcheckRom=checkRom.length();\n" +
                "        if (lcheckRom==0){\n" +
                "            flagRomanExpression++;\n" +
                "        }\n" +
                "        return flagRomanExpression;\n" +
                "    }\n" +
                "}";
        String codeString =  s;
        long mycount = codeString.chars().filter(ch -> ch == ';').count();
        System.out.println(mycount);
    }
}
