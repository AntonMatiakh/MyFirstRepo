import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.services.LectureService;

public class Main {

    public static void main(String[] args) {

        Course firstCourse = new Course("JAVA", 1l);

        LectureService lectureService = new LectureService();

        Lecture firstLecture = lectureService.createLecture("Intro", 1l, firstCourse.getID());
        Lecture secondLecture = lectureService.createLecture("Variables", 2l, firstCourse.getID());
        Lecture thirdLecture = lectureService.createLecture("Data_types", 3l, firstCourse.getID());
        Lecture fourthLecture = lectureService.createLecture("Git", 4l, firstCourse.getID());
        Lecture fifthLecture = lectureService.createLecture("Github", 5l, firstCourse.getID());
        Lecture sixthLecture = lectureService.createLecture("Methods", 6l, firstCourse.getID());

        System.out.println("Number of lectures: " + Lecture.counter);
        System.out.println("Sixth lecture's id: " + sixthLecture.courseID);
    }
}