import com.academy.models.Course;
import com.academy.models.Lecture;
import com.academy.services.LectureService;
import com.academy.services.MainService;

public class Main {

    public static void main(String[] args) {

        Course firstCourse = new Course("JAVA", 2022L);

        LectureService lectureService = new LectureService();

        Lecture firstLecture = lectureService.createLecture("Intro", 1L);
        Lecture secondLecture = lectureService.createLecture("Variables", 2L);
        Lecture thirdLecture = lectureService.createLecture("Data_types", 3L);
        Lecture fourthLecture = lectureService.createLecture("Git", 4L);
        Lecture fifthLecture = lectureService.createLecture("Github", 5L);
        Lecture sixthLecture = lectureService.createLecture("Methods", 6L);

        MainService.welcomeTo();

        //MainService.selectCategory(MainService.choiceOfCategory());
        //MainService.realisationLecture(MainService.optionLecture());

        //int category = MainService.choiceOfCategory();
        //MainService.selectCategory(category);

        int category = MainService.chooseCategory();
        MainService.selectCategory(category);


        //int choice = MainService.createNewLecture();
//        MainService.realisationLecture(choice);
        //MainService.creationOfLecture(choice);
    }
}