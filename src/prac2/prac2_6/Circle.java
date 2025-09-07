package prac2.prac2_6;

public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
    }

    public double getRadius() {return radius;}

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Радиус должен быть положительным числом!");
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getLen() {
        return 2 * Math.PI * radius;
    }

    public boolean equals(Circle otherCircle) {
        if (otherCircle == null) {
            return false;
        }
        return Math.abs(this.radius - otherCircle.radius) < 0.000001;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, area=%.2f, Len=%.2f]",
                radius, getArea(), getLen());
    }
}