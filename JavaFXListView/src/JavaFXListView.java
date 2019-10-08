
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXListView extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Fruits list
        final ListView<String> lvFruits = new ListView<>();
        
        // Add the items to the List 
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Apricots");
        fruits.add("Avocados");

        lvFruits.getItems().addAll(fruits);
        // Set the size of the ListView
        lvFruits.setPrefSize(120, 120);
        // Enable multiple selection
        lvFruits.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lvFruits.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov,
                    final String oldvalue, final String newvalue) {
                System.out.println("New Value: " + newvalue+"\tOld Value: " + oldvalue);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(lvFruits);
        // Add GridPane to Scene
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX ListView Example");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
