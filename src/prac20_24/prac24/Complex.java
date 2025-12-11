package prac20_24.prac24;

public class Complex {
    private int real;
    private int image;

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public double getReal() {return real;}
    public double getImage() {return image;}

    public void setReal(int real) {this.real = real;}
    public void setImage(int image) {this.image = image;}

    @Override
    public String toString() {
        if (image >= 0) {
            return real + " + " + image + "i";
        } else {
            return real + " - " + (-image) + "i";
        }
    }
}