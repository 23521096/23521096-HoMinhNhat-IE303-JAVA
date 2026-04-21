package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Product;

public class ProductCard extends VBox {

    private Product product;

    public ProductCard(Product product) {
        this.product = product;

        setPadding(new Insets(10));
        setSpacing(8);
        setPrefWidth(160);

        setStyle(getDefaultStyle());

        ImageView img = new ImageView(new Image(product.getImage()));
        img.setFitWidth(140);
        img.setFitHeight(90);

        Label name = new Label(product.getName());
        Label price = new Label("$" + String.format("%.2f", product.getPrice()));

        getChildren().addAll(img, name, price);

        // Hover effect
        setOnMouseEntered(e -> {
            if (!getStyle().contains("#4CAF50")) {
                setStyle("""
                    -fx-background-color: #eeeeee;
                    -fx-border-radius: 10;
                    -fx-background-radius: 10;
                """);
            }
        });

        setOnMouseExited(e -> {
            if (!getStyle().contains("#4CAF50")) {
                setStyle(getDefaultStyle());
            }
        });
    }

    public Product getProduct() {
        return product;
    }

    public String getDefaultStyle() {
        return """
            -fx-background-color: white;
            -fx-border-color: #ddd;
            -fx-border-radius: 10;
            -fx-background-radius: 10;
        """;
    }

    public void setSelectedStyle() {
        setStyle("""
            -fx-background-color: white;
            -fx-border-color: #2196F3;
            -fx-border-width: 2;
            -fx-border-radius: 10;
            -fx-background-radius: 10;
        """);
    }
}