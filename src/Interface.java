import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * class Interface sets boundaries, buttons, boxes and lists
 */
public class Interface extends Pane {
    Button TeacherButton = new Button("Нанять преподавателя");
    Button StudentButton = new Button("Зачислить студента");
    Button LectureButton = new Button("Добавить лекцию");
    VBox teachersVBox = new VBox(7);
    VBox studentsVBox = new VBox(7);
    VBox lecturesVBox = new VBox(7);
    VBox showVBox = new VBox();

    /**
     * Constructor, where the process is implemented
     */
    public Interface() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(20);
        gridPane.setVgap(15);

        HBox teachersHBox = new HBox();
        teachersVBox.getChildren().add(teachersHBox);

        HBox studentHBox = new HBox();
        studentsVBox.getChildren().add(studentHBox);

        HBox lectureHBox = new HBox();
        lecturesVBox.getChildren().add(lectureHBox);

        ObservableList list1 = FXCollections.observableArrayList(teachersVBox);
        ObservableList list2 = FXCollections.observableArrayList(studentsVBox);
        ObservableList list3 = FXCollections.observableArrayList(lecturesVBox);

        ListView lv1 = new ListView(list1);
        VBox exampleVBox1 = new VBox();
        exampleVBox1.getChildren().addAll(new Node[]{lv1,TeacherButton});

        ListView lv2 = new ListView(list2);
        VBox exampleVBox2 = new VBox();
        exampleVBox2.getChildren().addAll(new Node[]{lv2,StudentButton});
        ListView lv3 = new ListView(list3);
        VBox exampleVBox3 = new VBox();
        exampleVBox3.getChildren().addAll(new Node[]{lv3,LectureButton});
        /**
         *  GridPane lays out its children within a flexible grid of rows and columns
         */
        gridPane.add(exampleVBox1, 0, 0,1,1);
        gridPane.add(exampleVBox2, 1, 0,1,1);
        gridPane.add(exampleVBox3, 2, 0,1,1);
        gridPane.add(showVBox, 0, 1, 1, 1);
        getChildren().add(gridPane);
    }

}
