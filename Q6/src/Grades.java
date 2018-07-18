public class Grades {
    private int numberOfStudents;
    private int[] grades;

    public Grades(int numberOfStudents, int[] grades) {
        this.numberOfStudents = numberOfStudents;
        this.grades = grades;
    }

    public boolean validateArray() {
        boolean flag = false;

        if (numberOfStudents == grades.length) {
            for (int i = 0; i < grades.length; i++) {
                if (grades[i] <= 100 && grades[i] >= 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int minimumGrade() {
        int minimum = 0;

        if (validateArray()) {
            minimum = grades[0];

            for (int i = 1; i < grades.length; i++) {
                if (minimum > grades[i]) {
                    minimum = grades[i];
                }
            }
        }

        return minimum;
    }

    public int maximumGrade() {
        int maximum = 0;

        if (validateArray()) {
            maximum = grades[0];

            for (int i = 1; i < grades.length; i++) {
                if (maximum < grades[i]) {
                    maximum = grades[i];
                }
            }
        }

        return maximum;
    }

    public double averageGrade() {
        double average = 0;

        if (validateArray()) {
            average = 0.0;
            int sum = 0;

            for (int i = 0; i < grades.length; i++) {
                sum += grades[i];
            }

            average = sum / grades.length;
        }

        return average;
    }
}

