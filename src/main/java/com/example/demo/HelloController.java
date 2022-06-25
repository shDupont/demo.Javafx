package com.example.demo;

import com.example.demo.entities.Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ComboBox<Person> cmbPerson;

    @FXML
    private Button btAll;

    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxPersonAction(){
        Person person = cmbPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @FXML
    public void onClickBtAll(){
        for (Person person : cmbPerson.getItems()){
            System.out.println(person);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"Maria","maria@gmail.com"));
        list.add(new Person(2,"Bob","bob@gmail.com"));
        list.add(new Person(3,"Roger","roger@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        cmbPerson.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        cmbPerson.setCellFactory(factory);
        cmbPerson.setButtonCell(factory.call(null));
    }
}