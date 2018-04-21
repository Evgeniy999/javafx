package MainProcess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import Body.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

/**
 * @author evgeniy
 * Brain program perform impotent functions
 */
public class Process {
    Interface gui;
    static boolean check;
    University university;

    /**
     * default constructor
     */
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

    /**
     *
     * @param list
     * @return result choice
     */
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

    /**
     *
     * @param studentValue
     */
    public static void showStudents(String studentValue) {
        if (studentValue.isEmpty()) {
            studentValue = "Никого нету!";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Список студентов");
        alert.setContentText(studentValue);
        alert.show();
    }

    public void notSelectLecture() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Лекция");
        alert.setContentText("Выберите лекцию!");
        alert.show();
    }

    public void notOnLecture() {
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
                Button button = new Button("Действие");
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

       if (result.isPresent()) {
           name = result.get().toString();
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Добавление информации");
           alert.setHeaderText("Проверка старосты");
           alert.setContentText("Ты староста?");

           ButtonType yes = new ButtonType("Да");
           ButtonType no = new ButtonType("Нет");
           alert.getButtonTypes().setAll(yes, no);
           Optional<ButtonType> result2 = alert.showAndWait();

           if (result2.get() == yes) {
               check = true;
           } else if(result2.get() == no)
               check = false;

           if (name != null && !name.isEmpty()) {
               if (check) {
                   university.addStudent(new Starley(name, true));
               } else {
                   university.addStudent(new Student(name, false));
               }

               gui.studentsVBox.getChildren().clear();
               Iterator value = Journal.getJournal().getStudents().iterator();
               while (value.hasNext()) {
                   Student student = (Student) value.next();
                   Label label = new Label();
                   Pane pane = new Pane();
                   Button button = new Button("Действие");
                   label.setText(student.getName());
                   HBox hbox = new HBox(10);
                   hbox.setAlignment(Pos.CENTER);
                   hbox.getChildren().addAll(label, pane, button);
                   hbox.setHgrow(pane, Priority.ALWAYS);
                   button.setOnAction((a) -> {
                       show(student);
                   });
                   gui.studentsVBox.getChildren().add(hbox);
               }
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
            university.getSetSubject(new Lecture[]{new Lecture(name)});
            gui.lecturesVBox.getChildren().clear();
            Iterator value = university.getEmploymentList().iterator();

            while(value.hasNext()) {
                AbstractEmployment lecture = (AbstractEmployment) value.next();
                Label label = new Label();
                Pane pane = new Pane();
                Button button = new Button("Действие");
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

    /**
     *
     * @param teacher perform choice
     */
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
                if (teacher.getSubject() == null) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setHeaderText("Вначале сходи на нее!");
                    alert2.show();
                } else {
                String endString = teacher.getCheckPeople((Lecture)teacher.getSubject());
                showStudents(endString);
                }
            } else if (result.get() == buttonTypeCancel) {
                notSelectLecture();
            }
        }
    }

    /**
     *
     * @param student
     */
    public void show(Student student) {

        if (!student.getMarks().isEmpty()) {
            gui.showVBox.getChildren().add(new Text(student.marks()));
        }
        if (student.getStatus() == false) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Информационное окно");
            alert.setHeaderText("Посетить лекцию?");
            ButtonType takeLecture = new ButtonType("Да");
            ButtonType noLecture = new ButtonType("Нет");
            ButtonType buttonTypeCancel = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);
            Lecture lecture = choice((ArrayList)university.getEmploymentList());
            if (lecture == null) {
                notSelectLecture();
            }
            else {
                alert.getButtonTypes().setAll(takeLecture, noLecture, buttonTypeCancel);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == takeLecture) {
                    if (lecture == null) {
                        notOnLecture();
                    } else
                        student.attendLecture(lecture);
                } else if (result.get() == noLecture) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setHeaderText("Ну и ладно!");
                    alert2.setContentText("Не забудь, ты идешь на экзамен!");
                    alert2.show();
                }
            }

        }else if(student.getStatus() == true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Информационное окно");
            alert.setHeaderText("1) Посетить лекцию\n2) Проверить посещение");
            alert.setContentText("Выберите нужный вам пункт:");
            ButtonType takeLecture = new ButtonType("1");
            ButtonType checkStudents = new ButtonType("2");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            Lecture lecture = choice((ArrayList) university.getEmploymentList());
            if (lecture == null) {
                notSelectLecture();
            } else {
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
                            showStudents(((Starley) student).getCheckPeople(lecture));
                        }
                    }
                    ;
                } else {
                    showStudents(((Starley) student).getCheckPeople(lecture));

                }
            }
        }

    }

    /**
     *
     * @param lecture
     */
    public void show(Lecture lecture) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационное окно");
        alert.setHeaderText(lecture.name.toString());
        alert.setContentText(lecture.showPeople(lecture));
        alert.showAndWait();
    }
}
