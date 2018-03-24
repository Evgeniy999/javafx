import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

/**
 * Brain program perform impotent functions
 */
public class Process {
    Interface gui;
    static boolean check;
    University university;

    public Process() {
        gui = Main.main;
        university = new University();
        gui.TeacherButton.setOnAction((a) -> {
            addTeacher();
        });
        gui.StudentButton.setOnAction((a) -> {
            addStudent();
        });
        gui.LectureButton.setOnAction((a) -> {
            addLecture();
        });
    }

    public static Lecture choice(ArrayList<Lecture> list) {
        ChoiceDialog<Lecture> dialog = new ChoiceDialog(null, list);
        dialog.setTitle("Выберите лекцию");
        dialog.setHeaderText("Введите название лекции:");
        dialog.setContentText("Выберите нужную:");
        Optional<Lecture> result = dialog.showAndWait();
        if(result.isPresent()) {
            return result.get();
        }
        else return null;
    }

    public static void showStudents(String studentValue) {
        if (studentValue.isEmpty()) {
            studentValue = "Никого нету!";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Список студентов");
        alert.setContentText(studentValue);
        alert.show();
    }

    public static void notSelectLecture() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Выберите лекцию!");
        alert.show();
    }

    public static void notOnLecture() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Вы не на лекции!");
        alert.show();
    }

    public void addTeacher() {
        TextInputDialog dialog = new TextInputDialog("Препод");
        dialog.setTitle("Добавление информации");
        dialog.setHeaderText("Введите имя учителя:");
        dialog.setContentText("Имя:");
        Optional<String> result = dialog.showAndWait();
        String name = null;
        if (result.isPresent()){
            name = result.get().toString();
            check = true;
        }
        else {check = false;}

        if (name != null && !name.isEmpty()) {
            university.addTeacher(new Teacher(name));
            gui.teachersVBox.getChildren().clear();
            Iterator var = university.getTeachersList().iterator();

            while(var.hasNext()) {
                Teacher teacher = (Teacher)var.next();
                Pane pane = new Pane();
                Label label = new Label();
                label.setText(teacher.getName());
                Button button = new Button("Click");
                HBox hbox = new HBox(10);
                hbox.setAlignment(Pos.CENTER);
                hbox.getChildren().addAll(label,pane,button);
                hbox.setHgrow(pane, Priority.ALWAYS);
                button.setOnAction((a) -> {
                    show(teacher);
                });
                gui.teachersVBox.getChildren().add(hbox);
            }

        }
    }

    public void addStudent() {
        check = false;
        TextInputDialog dialog = new TextInputDialog("Студент");
        dialog.setTitle("Добавление информации");
        dialog.setHeaderText("Введите имя студента:");
        dialog.setContentText("Имя:");
        Optional<String> result = dialog.showAndWait();
        String name = null;
        if (result.isPresent()){
            name = result.get().toString();
            check = true;
        }
        else {check = false;}


        if (name != null && !name.isEmpty()) {
            if (check) {
                university.addStudent(new Starley(name));
            } else {
                university.addStudent(new Student(name));
            }

            gui.studentsVBox.getChildren().clear();
            Iterator value = university.getStudentsList().iterator();

            while(value.hasNext()) {
                Student student = (Student)value.next();
                Label label = new Label();
                Pane pane = new Pane();
                Button button = new Button("Click");
                label.setText(student.getName());
                HBox hbox = new HBox(10);
                hbox.setAlignment(Pos.CENTER);
                hbox.getChildren().addAll(label,pane,button);
                hbox.setHgrow(pane, Priority.ALWAYS);
                button.setOnAction((a) -> {
                    show(student);
                });
                gui.studentsVBox.getChildren().add(hbox);
            }

        }
    }

    public void addLecture() {
        TextInputDialog dialog = new TextInputDialog("Форточка");
        dialog.setTitle("Добавление информации");
        dialog.setHeaderText("Введите название лекции:");
        dialog.setContentText("Название:");
        Optional<String> result = dialog.showAndWait();
        String name = null;
        if (result.isPresent()){
            name = result.get().toString();
            check = true;
        }
        else {check = false;}

        if (name != null && !name.isEmpty()) {
            university.setSubjectsPlane(new Lecture[]{new Lecture(name)});
            gui.lecturesVBox.getChildren().clear();
            Iterator value = university.getEmploymentList().iterator();

            while(value.hasNext()) {
                Employment lecture = (Employment) value.next();
                Label label = new Label();
                Pane pane = new Pane();
                Button button = new Button("Click");
                label.setText(lecture.name);
                HBox hbox = new HBox(10);
                hbox.setAlignment(Pos.CENTER);
                hbox.getChildren().addAll(label,pane,button);
                hbox.setHgrow(pane, Priority.ALWAYS);
                button.setOnAction((a) -> {
                    show((Lecture)lecture);

                });
                gui.lecturesVBox.getChildren().add(hbox);
            }

        }
    }

    public void show(Teacher teacher) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText("1) Провести лекцию\n2) Проверить посещение");
        alert.setContentText("Выберите нужный вам пункт:");
        ButtonType takeLecture = new ButtonType("1");
        ButtonType checkStudents = new ButtonType("2");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        Lecture lecture = choice((ArrayList)university.getEmploymentList());
        if (lecture == null) {
            notSelectLecture();
        }
        else {
            alert.getButtonTypes().setAll(takeLecture, checkStudents, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == takeLecture) {
                if (lecture == null) {
                    notOnLecture();
                } else
                    teacher.readLecture(lecture);
            } else if (result.get() == checkStudents) {
                String endString = teacher.checkPeople((Lecture)teacher.getSubject());
                showStudents(endString);
            } else if (result.get() == buttonTypeCancel) {
                notSelectLecture();
            }
        }
    }

    public void show(Student student) {

        if (!student.getMarks().isEmpty()) {
            gui.showVBox.getChildren().add(new Text(student.marks()));
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText("1) Посетить лекцию\n2) Проверить посещение");
        alert.setContentText("Выберите нужный вам пункт:");
        ButtonType takeLecture = new ButtonType("1");
        ButtonType checkStudents = new ButtonType("2");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        Lecture lecture = choice((ArrayList)university.getEmploymentList());
        if (lecture == null) {
            notSelectLecture();
        }
        else {
            alert.getButtonTypes().setAll(takeLecture, checkStudents, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == takeLecture) {
                if (lecture == null) {
                    notOnLecture();
                } else
                    student.attendLecture(lecture);
            } else if (result.get() == checkStudents) {
                if (student.getClass() == Starley.class) {
                    if (lecture == null) {
                        notOnLecture();
                    } else {
                        showStudents(((Starley) student).checkPeople(lecture));
                    }
                }
                ;
            } else {
                showStudents(((Starley) student).checkPeople(lecture));

            }
        }

    }

    public void show(Lecture lecture) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText(lecture.name.toString());
        alert.showAndWait();
    }
}
