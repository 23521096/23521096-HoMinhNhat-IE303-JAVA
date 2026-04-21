package controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;
import model.Product;
import view.MainView;
import view.ProductCard;

import java.util.List;

public class ProductController {

    private MainView view;
    private List<Product> products;
    private ProductCard selectedCard = null;

    public ProductController(MainView view, List<Product> products) {
        this.view = view;
        this.products = products;
    }

    public void init() {

        int col = 0, row = 0;

        for (Product p : products) {

            ProductCard card = new ProductCard(p);

            card.setOnMouseClicked(e -> {

                // bỏ chọn cũ
                if (selectedCard != null) {
                    selectedCard.setStyle(selectedCard.getDefaultStyle());
                }

                // chọn mới
                card.setSelectedStyle();
                selectedCard = card;

                showProductWithEffect(p);
            });

            view.getRightPane().add(card, col, row);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }

        // default
        if (!products.isEmpty()) {
            showProductWithEffect(products.get(0));
        }
    }

    private void showProductWithEffect(Product p) {

        view.showProduct(p.getName(), p.getPrice(), p.getImage());

        FadeTransition fade = new FadeTransition(Duration.millis(200), view.getLeftPane());
        fade.setFromValue(0);
        fade.setToValue(1);

        ScaleTransition scale = new ScaleTransition(Duration.millis(200), view.getLeftPane());
        scale.setFromX(0.9);
        scale.setToX(1);
        scale.setFromY(0.9);
        scale.setToY(1);

        fade.play();
        scale.play();
    }
}