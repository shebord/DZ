package prac10_to_19.prac10;

class Student {
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private double averageGrade;

    public Student(String firstName, String lastName, String specialty,
                   int course, String group, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.averageGrade = averageGrade;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSpecialty() { return specialty; }
    public int getCourse() { return course; }
    public String getGroup() { return group; }
    public double getAverageGrade() { return averageGrade; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setCourse(int course) { this.course = course; }
    public void setGroup(String group) { this.group = group; }
    public void setAverageGrade(double averageGrade) { this.averageGrade = averageGrade; }

    @Override
    public String toString() {
        return String.format("%s %s, %s, курс %d, группа %s, балл: %.2f",
                firstName, lastName, specialty, course, group, averageGrade);
    }
}
