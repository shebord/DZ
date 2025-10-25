package prac10_to_19.prac13;

public class prac13_1 {

    public static void main(String[] args) {
        analyzeString("I like Java!!!");
    }

    public static void analyzeString(String str) {
        System.out.println("Исходная строка: " + str);

        char lastChar = str.charAt(str.length() - 1);
        System.out.println("2. Последний символ: '" + lastChar + "'");

        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("3. Заканчивается на '!!!': " + endsWithExclamation);

        boolean startsWithILike = str.startsWith("I like");
        System.out.println("4. Начинается с 'I like': " + startsWithILike);

        boolean containsJava = str.contains("Java");
        System.out.println("5. Содержит 'Java': " + containsJava);

        int javaPosition = str.indexOf("Java");
        System.out.println("6. Позиция 'Java': " + javaPosition);

        String replacedStr = str.replace('a', 'o');
        System.out.println("7. После замены 'a' на 'o': " + replacedStr);

        String upperCaseStr = str.toUpperCase();
        System.out.println("8. В верхнем регистре: " + upperCaseStr);

        String lowerCaseStr = str.toLowerCase();
        System.out.println("9. В нижнем регистре: " + lowerCaseStr);

        if (javaPosition != -1) {
            String javaSubstring = str.substring(javaPosition, javaPosition + 4);
            System.out.println("10. Вырезанная подстрока 'Java': '" + javaSubstring + "'");
        }
    }
}