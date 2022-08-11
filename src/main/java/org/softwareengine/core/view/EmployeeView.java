package org.softwareengine.core.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;
import javafx.util.Callback;
import org.softwareengine.core.model.Employee;

public class EmployeeView {

    public  TableView<Employee> tableView;
    public final StackPane root;
    public final Button addButton;
    public final Button editButton;
    public final Button printButton;

    public EmployeeView() {
        SVGPath svgPath1 = new SVGPath();
        svgPath1.setContent("M22.5 38V25.5H10V22.5H22.5V10H25.5V22.5H38V25.5H25.5V38Z");
        svgPath1.setScaleX(.5);
        svgPath1.setScaleY(.5);
        addButton = new Button();
        addButton.setGraphic(svgPath1);
        addButton.setMinSize(40, 40);
        addButton.setMaxSize(40, 40);

        SVGPath svgPath2 = new SVGPath();
        svgPath2.setContent("M40.5 29.05 36.95 25.5 38.4 24.05Q38.8 23.65 39.45 23.65Q40.1 23.65 40.5 24.05L41.95 25.5Q42.35 25.9 42.35 26.55Q42.35 27.2 41.95 27.6ZM24 42V38.45L34.8 27.65L38.35 31.2L27.55 42ZM6 31.5V28.5H21V31.5ZM6 23.25V20.25H29.5V23.25ZM6 15V12H29.5V15Z");
        svgPath2.setScaleX(.5);
        svgPath2.setScaleY(.5);
        editButton = new Button();
        editButton.setGraphic(svgPath2);
        editButton.setMinSize(40, 40);
        editButton.setMaxSize(40, 40);

        SVGPath svgPath3 = new SVGPath();
        svgPath3.setContent("M24 44Q19.75 44 16.1 42.475Q12.45 40.95 9.75 38.25Q7.05 35.55 5.525 31.9Q4 28.25 4 24Q4 19.8 5.525 16.15Q7.05 12.5 9.75 9.8Q12.45 7.1 16.1 5.55Q19.75 4 24 4Q28.2 4 31.85 5.55Q35.5 7.1 38.2 9.8Q40.9 12.5 42.45 16.15Q44 19.8 44 24Q44 28.25 42.45 31.9Q40.9 35.55 38.2 38.25Q35.5 40.95 31.85 42.475Q28.2 44 24 44ZM24 18.3Q24.7 18.3 25.175 17.85Q25.65 17.4 25.65 16.7Q25.65 16 25.175 15.5Q24.7 15 24 15Q23.3 15 22.825 15.5Q22.35 16 22.35 16.7Q22.35 17.4 22.825 17.85Q23.3 18.3 24 18.3ZM22.65 34H25.65V22H22.65Z");
        svgPath3.setScaleX(.5);
        svgPath3.setScaleY(.5);
        printButton = new Button();
        printButton.setGraphic(svgPath3);
        printButton.setMinSize(40, 40);
        printButton.setMaxSize(40, 40);

        HBox hBox = new HBox(addButton, editButton, printButton);
        hBox.setPadding(new Insets(15));
        hBox.setSpacing(5);

        tableView = new TableView<>();
        TableColumn<Employee, Integer> id = new TableColumn<>("id");
        TableColumn<Employee, String> name = new TableColumn<>("name");
        TableColumn<Employee, Integer> degree = new TableColumn<>("degree");

        id.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().id()).asObject());
        name.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().name()));
        degree.setCellValueFactory(param -> new SimpleIntegerProperty(param.getValue().degree()).asObject());

        tableView.getColumns().add(id);
        tableView.getColumns().add(name);
        tableView.getColumns().add(degree);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(tableView);
        BorderPane.setMargin(tableView, new Insets(50));

        root = new StackPane();
        root.getChildren().add(borderPane);
    }
}
