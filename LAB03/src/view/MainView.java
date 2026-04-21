package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class MainView {

    private BorderPane root = new BorderPane();

    private VBox leftPane = new VBox();
    private ImageView mainImage = new ImageView();
    private Label nameLabel = new Label();
    private Label priceLabel = new Label();

    private GridPane rightPane = new GridPane();

    public MainView() {
        buildUI();
    }

    private void buildUI() {

        root.setStyle("-fx-background-color: #f5f5f5;");

        // LEFT PANEL
        leftPane.setSpacing(15);
        leftPane.setPadding(new Insets(20));
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.setPrefWidth(320);

        leftPane.setStyle("""
            -fx-background-color: white;
            -fx-background-radius: 10;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10,0,0,2);
        """);

        mainImage.setFitWidth(260);
        mainImage.setFitHeight(160);

        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        priceLabel.setStyle("-fx-font-size: 16px;");

        leftPane.getChildren().addAll(mainImage, nameLabel, priceLabel);

        // RIGHT PANEL
        rightPane.setPadding(new Insets(20));
        rightPane.setHgap(20);
        rightPane.setVgap(20);

        root.setLeft(leftPane);
        root.setCenter(rightPane);
    }

    public BorderPane getRoot() {
        return root;
    }

    public GridPane getRightPane() {
        return rightPane;
    }

    public VBox getLeftPane() {
        return leftPane;
    }

    public void showProduct(String name, double price, String image) {
        mainImage.setImage(new Image(image));
        nameLabel.setText(name);
        priceLabel.setText("$" + String.format("%.2f", price));
    }
}