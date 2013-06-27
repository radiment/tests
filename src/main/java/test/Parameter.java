package test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Parameter {
    private SimpleIntegerProperty number;
    private SimpleStringProperty name;
    private SimpleStringProperty mappedTo;

    public int getNumber() {
        return number.get();
    }

    public Parameter(Integer number, String name, String mappedTo) {
        this.number = new SimpleIntegerProperty(number);
        this.name = new SimpleStringProperty(name);
        this.mappedTo = new SimpleStringProperty(mappedTo);
    }

    public SimpleIntegerProperty numberProperty() {
        return number;
    }


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }


    public String getMappedTo() {
        return mappedTo.get();
    }

    public SimpleStringProperty mappedToProperty() {
        return mappedTo;
    }


}
