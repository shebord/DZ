package prac1_to_9.prac7.prac7_8;

public class Magazine implements Printable {
    private String title;

    public Magazine(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}