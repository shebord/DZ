package prac10_to_19.prac11;

import java.util.Date;
import java.text.SimpleDateFormat;

public class prac11_1 {
    public static void main(String[] args) {
        String developer = "Шебордаев Илья";

        Date receiveDate = new Date(125, 9, 25, 19, 54, 23);
        Date submitDate = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        System.out.println("Разработчик: " + developer);
        System.out.println("Дата получения: " + sdf.format(receiveDate));
        System.out.println("Дата сдачи: " + sdf.format(submitDate));
    }
}
