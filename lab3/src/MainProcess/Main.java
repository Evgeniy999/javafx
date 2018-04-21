package MainProcess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author evgeniy
 *
 */
public class Main extends Application {

    static Interface main;

    public Main() {
    }

    /**
     * start programm
     * @param stage -The JavaFX Stage class is the top level JavaFX container.
     *              The primary Stage is constructed by the platform.
     */
    public void start(Stage stage){
        main = new Interface();
        Scene scene = new Scene(main, 810, 500);
        stage.setScene(scene);
        stage.show();
        new Process();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
