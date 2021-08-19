package ru.netology.manager;

public class GenericBox <AirTicket> {
    private AirTicket value;
    public GenericBox(AirTicket value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return  value == null;
    }

    public AirTicket gerValue() {
        return value;
    }
}
