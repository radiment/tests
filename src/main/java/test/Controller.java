package test;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Controller {

    @FXML
    private TreeView<String> fileTree;
    @FXML
    private TreeView<String> nodeTree;
    @FXML
    private TableView<Parameter> fileTable;
    @FXML
    private SplitPane splitPane;

    public void initialize() {
        reloadFileTree();
        reloadEditor();
    }

    private void reloadFileTree() {
        TreeItem<String> tree = getTestTree();
        ObservableList<Parameter> list = FXCollections.observableArrayList();
        list.add(new Parameter(1, "some", ""));
        fileTable.setItems(list);
        fileTree.setRoot(tree);
    }

    private TreeItem<String> getTestTree() {
        TreeItem<String> root = new TreeItem<>("root");
        for (int i = 0; i < 10; i++) {
             root.getChildren().add(new TreeItem<String>("child " + i));
        }
        return root;
    }

    public void exit(ActionEvent event) {
        if (!shutdown()) {
            event.consume();
        } else {
            Platform.exit();
        }
    }

    public boolean shutdown() {
        return true;
    }

    private void reloadEditor() {
        nodeTree.setRoot(new TreeItem<>("test tree"));
    }

    private Boolean itemsOpen;
    private Double value;

    public void onClickHideShowButton(ActionEvent actionEvent) {
        if (itemsOpen == null) {
            itemsOpen = Math.round(splitPane.getDividers().get(0).getPosition() * 10) != 10;
        }
        if (itemsOpen) {
            //save divide position
            value = splitPane.getDividers().get(0).getPosition();
            splitPane.getDividers().get(0).setPosition(1);
            itemsOpen = false;
        } else {
            //load saved position
            splitPane.getDividers().get(0).setPosition(value);
            itemsOpen = true;
        }
    }
}
