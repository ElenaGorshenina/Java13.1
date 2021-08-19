package ru.netology.manager;

import ru.netology.domain.AirTicket;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;

    public void add(AirTicket airTicket) {
        repository.save(airTicket);
    }

    public AirTicket[] findByParam(String fromAirport, String toAirport) {
        AirTicket[] tic = new AirTicket[0];
        for (AirTicket airTicket : repository.findAll()) {
            if (airTicket.getFromAirport().contains(fromAirport) && airTicket.getToAirport().contains(toAirport)) {
                int index = 0;
                tic[index] = airTicket;
                index++;
            } else {
            }
        }
        return tic;
    }

}
