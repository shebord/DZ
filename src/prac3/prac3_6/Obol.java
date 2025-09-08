package prac3.prac3_6;

public class Obol {
    public static void main(String[] args) {
        Double z = Double.valueOf(5.73);
        Double x = Double.valueOf("3.98");
        Double c = Double.valueOf(14.0);

        System.out.println("1. Объекты типа Double: " + "\n" + z + "\n" + x + "\n" + c + "\n");

        String pecil = "123.67";
        Double dpencil = Double.parseDouble(pecil);

        System.out.println("2. Преобразование: ");
        System.out.println("Строка: " + pecil);
        System.out.println("Значение в Double: " + dpencil + "\n");

        Double num = 12.478634;

        byte bnum = num.byteValue();
        short snum = num.shortValue();
        int inum = num.intValue();
        long lnum = num.longValue();
        float fnum = num.floatValue();
        double dnum = num.doubleValue();
        boolean boolnum = (num != 0);

        System.out.println("3. Преобразования Double к примитивным типам данных: ");
        System.out.println("byte: " + bnum);
        System.out.println("short: " + snum);
        System.out.println("int: " + inum);
        System.out.println("long: " + lnum);
        System.out.println("float: " + fnum);
        System.out.println("double: " + dnum);
        System.out.println("boolean: " + boolnum + "\n");

        String s = Double.toString(3.8956);
        System.out.println("5. Преобразование double литерала к строке: ");
        System.out.println("Тип переменной d: " + s.getClass().getSimpleName());
        System.out.println("Значение переменной d: \"" + s + "\"");
    }
}
