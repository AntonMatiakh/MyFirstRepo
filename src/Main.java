import com.academy.models.Course;
import com.academy.models.Lecture;

public class Main {

    public static void main(String[] args) {

        Course firstCourse = new Course("English_Tenses", 1l);

        Lecture firstLecture = new Lecture("Present_Simple", 1l, firstCourse.getID());
        Lecture secondLecture = new Lecture("Present_Continuous", 2l, firstCourse.getID());
        Lecture thirdLecture = new Lecture("Present_Perfect", 3l, firstCourse.getID());
        Lecture fourthLecture = new Lecture("Past_Simple", 4l, firstCourse.getID());
        Lecture fifthLecture = new Lecture("Past_Continuous", 5l, firstCourse.getID());
        Lecture sixthLecture = new Lecture("Past_Perfect", 6l, firstCourse.getID());

        System.out.println("Number of lectures: " + Lecture.counter);
        System.out.println("Sixth lecture's id: " + sixthLecture.courseID);
    }
}