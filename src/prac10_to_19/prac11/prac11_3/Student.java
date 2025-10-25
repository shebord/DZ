package prac10_to_19.prac11.prac11_3;

import java.util.Date;
import java.text.SimpleDateFormat;

class Student {
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private double averageGrade;
    private Date birthDate;

    public Student(String firstName, String lastName, String specialty,
                   int course, String group, double averageGrade, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.averageGrade = averageGrade;
        this.birthDate = birthDate;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSpecialty() { return specialty; }
    public int getCourse() { return course; }
    public String getGroup() { return group; }
    public double getAverageGrade() { return averageGrade; }
    public Date getBirthDate() { return birthDate; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setCourse(int course) { this.course = course; }
    public void setGroup(String group) { this.group = group; }
    public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
        return String.format("%s %s, %s, курс %d, группа %s, балл: %.2f, рожд.: %s",
                firstName, lastName, specialty, course, group,
                averageGrade, formatBirthDate("short"));
    }

    public String formatBirthDate(String format) {
        switch (format.toLowerCase()) {
            case "short":
                return new SimpleDateFormat("dd.MM.yy").format(birthDate);
            case "medium":
                return new SimpleDateFormat("dd MMM yyyy").format(birthDate);
            case "full":
                return new SimpleDateFormat("dd MMMM yyyy 'г.'").format(birthDate);
            default:
                return new SimpleDateFormat("dd.MM.yyyy").format(birthDate);
        }
    }
}