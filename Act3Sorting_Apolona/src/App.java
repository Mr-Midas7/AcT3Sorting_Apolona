import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class App {

    public static void insertion(Student[] students) {
        int n = students.length;
        for (int i = 1; i < n; i++) {
            Student k = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].grade > k.grade) {
                students[j + 1] = students[j];
                j--;
            }

            students[j + 1] = k;
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.print("How many Students? ");
        int num = sc.nextInt();
        sc.nextLine(); 

        Student[] students = new Student[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter Details For Student #" + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Grade: ");
            double grade = sc.nextDouble();
            sc.nextLine(); 

            students[i] = new Student(name, grade);
        }

        insertion(students);

        System.out.println("\nSorted Students by Grade (Ascending):");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.grade);
        }
    }
}
