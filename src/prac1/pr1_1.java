package prac1;

public class pr1_1 {
    public static void main(String[] args) {
        int[] num = {12, 3, 43, 45 ,83, 4, 7};

       System.out.print("Массив: ");
       for (int i = 0; i < num.length; i++){
           System.out.print(num[i] + " ");
       }
       System.out.println();

       int sum = 0;
       for (int i = 0; i < num.length; i++){
           sum += num[i];
       }

       double av = (double) sum / num.length;

       System.out.println("Сумма: " + sum);
       System.out.println("Ср арифм: " + av);
    }
}