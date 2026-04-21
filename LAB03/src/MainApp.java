import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import model.Product;
import view.MainView;
import controller.ProductController;

import java.util.Arrays;
import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        List<Product> products = Arrays.asList(
            new Product("4DFWD PULSE", 160, "file:src/images/img1.png"),
            new Product("FORUM MID", 100, "file:src/images/img2.png"),
            new Product("SUPERNOVA", 150, "file:src/images/img3.png"),
            new Product("NMD", 120, "file:src/images/img4.png"),
            new Product("PUMA", 190, "file:src/images/img5.png"),
            new Product("ADIDAS", 170, "file:src/images/img6.png")
        );

        MainView view = new MainView();
        ProductController controller = new ProductController(view, products);

        controller.init();

        Scene scene = new Scene(view.getRoot(), 900, 500);

        stage.setTitle("Shop UI - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}