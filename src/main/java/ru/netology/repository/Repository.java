package ru.netology.repository;

import ru.netology.domain.AirTicket;

public class Repository {
    private AirTicket[] airTickets = new AirTicket[0];

    public void save(AirTicket airTicket) {
        int length = airTickets.length + 1;
        AirTicket[] tmp = new AirTicket[length];
        System.arraycopy(airTickets, 0, tmp, 0, airTickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = airTicket;
        airTickets = tmp;
    }

    public AirTicket[] findAll() {
        return airTickets;
    }

    public AirTicket[] removeById(int id) {
        int length = airTickets.length - 1;
        AirTicket[] tmp = new AirTicket[length];
        int index = 0;
        for (AirTicket airTicket : airTickets) {
            if (airTicket.getId() != id) {
                tmp[index] = airTicket;
                index++;
            }
        }
        return airTickets = tmp;
    }

}
