package prac2.prac2_2;

public class TestBall {
    public static void main(String[] args) {
        Ball ball1 = new Ball();
        Ball ball2 = new Ball(7.0, 12.0);

        System.out.println("Начало Ball1(" + ball1.getX() + "," + ball1.getY() + ")");
        System.out.println("Начало Ball2(" + ball2.getX() + "," + ball2.getY() + ")");
        System.out.println();

        ball1.setX(5.7);
        ball1.setY(6.1);
        System.out.println("ball1 после именения: (" + ball1.getX() + "," + ball2.getY() + ")");

        ball2.setXY(0.1,1.5);
        System.out.println("ball2 после setXY: (" + ball2.getX() + ", " + ball2.getY() + ")");
        System.out.println();

        ball2.move(15,15);
        System.out.println("ball2 после move(15,15): (" + ball2.getX() + ", " + ball2.getY() + ")");
        System.out.println();

        System.out.println("ball1: " + "\n" + ball1.toString());
        System.out.println("ball2: " + "\n" + ball2.toString());
    }
}
