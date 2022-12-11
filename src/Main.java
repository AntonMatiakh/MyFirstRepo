import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.services.LectureService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LectureService lectureService = new LectureService();

        Course firstCourse = new Course("Java", 2022L);

        Lecture firstLecture = lectureService.createLecture("Introduction", firstCourse.getCourseID());
        Lecture secondLecture = lectureService.createLecture("Variables", firstCourse.getCourseID());
        Lecture thirdLecture = lectureService.createLecture("DataTypes", firstCourse.getCourseID());
        Lecture fourthLecture = lectureService.createLecture("Git", firstCourse.getCourseID());
        Lecture fifthLecture = lectureService.createLecture("GitHub", firstCourse.getCourseID());
        Lecture sixthLecture = lectureService.createLecture("Methods", firstCourse.getCourseID());


        Scanner scanner = new Scanner(System.in);

        int option;

        while (true) {
            System.out.println("Welcome to 'Online School' project!");
            System.out.println("You have next options:");
            System.out.println("'Continue' - input 1, 'Finish' - input 2, 'Restart' - input any number");
            System.out.println("Please, select necessary option and input appropriate number:");
            option = scanner.nextInt();

            if (option == 1) {
                break;
            } else if (option == 2) {
                System.out.println("That's all, thank you for attention, see you next time :)");
                System.out.println("---------------------------END---------------------------");
                System.exit(0);
            }
        }

        int category;

        do {
            System.out.println("We have the following categories:");
            System.out.println("1.Course  2.Teacher  3.Student  4.Lecture");
            System.out.println("Please, select necessary category and input appropriate number:");
            category = scanner.nextInt();

            if (category < 1 || category > 4) {
                System.out.println("Sorry, nothing found... :(");
                System.out.println("Let's try again");
            }

        } while (category < 1 || category > 4);


        switch (category) {
            case 1:
                System.out.println("You have selected 'Course' category");
                break;
            case 2:
                System.out.println("You have selected 'Teacher' category");
                break;
            case 3:
                System.out.println("You have selected 'Student' category");
                break;
            case 4:
                System.out.println("You have selected 'Lecture' category");
                break;
        }

        int answer;

        System.out.println("We have already " + lectureService.getLectureCounter() + " lectures");
        System.out.println("Would you like to create new lecture?");
        System.out.println("If 'Yes' - input 1, if 'No' - input 2");
        System.out.println("Please, input appropriate number:");
        answer = scanner.nextInt();

        while (answer == 1) {
            System.out.println("Enter lecture name:");
            String lectureName = scanner.next();
            System.out.println(lectureService.createLecture(lectureName, firstCourse.getCourseID()));
            System.out.println("Now we have " + lectureService.getLectureCounter() + " lectures");

            if (lectureService.getLectureCounter() == 8) {
                System.out.println("That's all, thank you for attention, see you next time :)");
                System.out.println("---------------------------END---------------------------");
                System.exit(0);
            }

            System.out.println("Would you like to create another lecture?");
            System.out.println("If 'Yes' - input 1, if 'No' - input 2");
            System.out.println("Please, input appropriate number:");
            answer = scanner.nextInt();
        }
        if (answer == 2) {
            System.out.println("That's all, thank you for attention, see you next time :)");
            System.out.println("---------------------------END---------------------------");
        } else {
            System.out.println("Unfortunately, something went terribly wrong... :(");
            System.out.println("------------------------END-----------------------");
        }
        scanner.close();
    }
}