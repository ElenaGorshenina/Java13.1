package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AirTicket implements Comparable<AirTicket>{
    private int id;
    private int price;
    private String fromAirport;
    private String toAirport;
    private int travelTime;

    public int getId() {
        return id;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    @Override
    public int compareTo(AirTicket o) {
        return this.price - o.price;
    }
}
