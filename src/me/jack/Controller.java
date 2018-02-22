package me.jack;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    public TextField textField;
    public Button button;
    public TextArea textArea;
    public VBox vBox;
    public Slider slider;
    public CheckBox checkBox;

    public void onSlide() {
        slider.valueProperty().addListener((observable, oldValue, newValue) ->
                textArea.setFont(Font.font(newValue.doubleValue())));
    }

    public void paste() {
        if (textArea.getText().isEmpty()) return;
        String url = PasteUtils.post(textArea.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Code pasted");
        alert.setHeaderText("The code has been pasted into hastebin...");

        alert.showAndWait();

        StringSelection selection = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        if (checkBox.isSelected()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        textField.setText(url);
    }

    public void saveKeyDetection() {
        textArea.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) paste();
        });
    }

    public void selectAll() {
        textField.selectAll();
    }
}
