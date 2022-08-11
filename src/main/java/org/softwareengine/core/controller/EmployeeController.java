package org.softwareengine.core.controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.softwareengine.core.model.Employee;
import org.softwareengine.core.repositories.EmployeeRepository;
import org.softwareengine.core.view.EmployeeView;

public class EmployeeController extends EmployeeView {

    public EmployeeController() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        addButton.setOnAction(event -> {
            Label idLabel = new Label("id");
            TextField idTextField = new TextField();

            Label nameLabel = new Label("name");
            TextField nameTextField = new TextField();

            Label degreeLabel = new Label("degree");
            TextField degreeTextField = new TextField();

            Button add = new Button("Add");
            add.setMinWidth(170);

            GridPane gridPane = new GridPane();
            gridPane.add(idLabel, 0, 0);
            gridPane.add(idTextField, 1, 0);
            gridPane.add(nameLabel, 0, 1);
            gridPane.add(nameTextField, 1, 1);
            gridPane.add(degreeLabel, 0, 2);
            gridPane.add(degreeTextField, 1, 2);
            gridPane.add(add, 1, 3);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            Label title = new Label("Add Employee");
            title.setPadding(new Insets(15));
            VBox vBox = new VBox(title, gridPane);
            vBox.setPrefSize(350, 250);
            vBox.setAlignment(Pos.CENTER);

            add.setOnAction(event1 -> {
                        employeeRepository.insert(new Employee(
                                Integer.parseInt(idTextField.getText()),
                                nameTextField.getText(),
                                Integer.parseInt(degreeTextField.getText())
                        ));
                        tableView.setItems(employeeRepository.getAll());
                    }
            );

            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            jfxDialogLayout.setBody(vBox);
            JFXDialog dialog = new JFXDialog(root, jfxDialogLayout, JFXDialog.DialogTransition.CENTER, true);
            dialog.setContent(vBox);
            dialog.show();
        });

        tableView.setItems(employeeRepository.getAll());
    }
}
