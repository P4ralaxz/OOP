public class Student {

    public String name;
    public double mScore;
    public double fScore;

    public void showGrade() {
        double s = (mScore * 0.4) + (fScore * 0.4) + 20;
        String grade;
        if (s < 50) {
            grade = "F";
        } else if (s <= 60) {
            grade = "D";
        } else if (s < 70) {
            grade = "C";
        } else if (s < 80) {
            grade = "B";
        } else {
            grade = "A";
        }
        System.out.println("Your grade : " + grade);
    }
}