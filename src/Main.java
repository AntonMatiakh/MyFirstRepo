import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.services.LectureService;
import com.academy.services.MainService;

public class Main {

    public static void main(String[] args) {

        Course firstCourse = new Course("JAVA", 2022L);

        LectureService lectureService = new LectureService();

        Lecture firstLecture = lectureService.createLecture("Intro", 1L, firstCourse.getCourseID());
        Lecture secondLecture = lectureService.createLecture("Variables", 2L, firstCourse.getCourseID());
        Lecture thirdLecture = lectureService.createLecture("Data_types", 3L, firstCourse.getCourseID());
        Lecture fourthLecture = lectureService.createLecture("Git", 4L, firstCourse.getCourseID());
        Lecture fifthLecture = lectureService.createLecture("Github", 5L, firstCourse.getCourseID());
        Lecture sixthLecture = lectureService.createLecture("Methods", 6L, firstCourse.getCourseID());

        MainService.selectCategory(MainService.chooseCategory());
        MainService.realisationLecture(MainService.optionLecture());

//        int category = MainService.chooseCategory();
//        MainService.selectCategory(category);
//
//        int choice = MainService.optionLecture();
//        MainService.realisationLecture(choice);
    }
}