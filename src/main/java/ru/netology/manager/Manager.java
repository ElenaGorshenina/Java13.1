package ru.netology.manager;

import ru.netology.domain.AirTicket;
import ru.netology.repository.Repository;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(AirTicket airTicket) {
        repository.save(airTicket);
    }

    public AirTicket[] findByParam(String fromAirport, String toAirport) {
        AirTicket[] result = new AirTicket[0];
        for (AirTicket airTicket : repository.findAll()) {
            if (airTicket.getFromAirport().contains(fromAirport) && airTicket.getToAirport().contains(toAirport)) {
                AirTicket[] tic = new AirTicket[result.length + 1];
                System.arraycopy(result, 0, tic, 0, result.length);
                tic[tic.length - 1] = airTicket;
                result = tic;
            } else {
            }
        }
        return result;
    }

}
