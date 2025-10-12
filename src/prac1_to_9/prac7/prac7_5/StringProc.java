package prac1_to_9.prac7.prac7_5;

public class StringProc implements StringOp {

    @Override
    public int countCharacters(String s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    @Override
    public String getOddPositionCharacters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        char[] result = new char[(s.length() + 1) / 2];
        int index = 0;

        for (int i = 0; i < s.length(); i += 2) {
            result[index++] = s.charAt(i);
        }

        return new String(result);
    }

    @Override
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] characters = s.toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        return new String(characters);
    }

    public void demonstrate(String input) {
        System.out.println("Исходная строка: " + input);
        System.out.println("Количество символов: " + countCharacters(input));
        System.out.println("Символы на нечетных позициях: " + getOddPositionCharacters(input));
        System.out.println("Инвертированная строка: " + reverseString(input));
        System.out.println("---");
    }
}