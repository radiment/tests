package test;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.sun.javafx.runtime.VersionInfo;

public class Main extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        stage=primaryStage;
        FXMLLoader ldr = new FXMLLoader(getClass().getResource("/Main.fxml"));
        System.out.println(VersionInfo.getRuntimeVersion());
        Parent root = (Parent) ldr.load();
        final Controller controller = ldr.getController();
        primaryStage.setTitle("Test");
        final Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        scene.getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (!controller.shutdown()) {
                    event.consume();
                }
            }
        });


        primaryStage.show();

    }
}
