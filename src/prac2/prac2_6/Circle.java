package prac2.prac2_6;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {return radius;}
    public String getColor() {return color;}

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Радиус должен быть положительным числом!");
        }
    }

    public void setColor(String color) {this.color = color;}

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
        return Math.abs(this.radius - otherCircle.radius) < 0.000001 &&
                this.color.equals(otherCircle.color);
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, color=%s, area=%.2f, circumference=%.2f]",
                radius, color, getArea(), getLen());
    }
}
