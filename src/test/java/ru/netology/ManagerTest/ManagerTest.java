package ru.netology.ManagerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTicket;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {
    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);

    private AirTicket spbMsk1 = new AirTicket(1, 2500, "LED", "SVO", 70);
    private AirTicket spbMsk2 = new AirTicket(2, 2450, "LED", "SVO", 85);
    private AirTicket mskSpb1 = new AirTicket(3, 2550, "SVO", "LED", 80);
    private AirTicket spbMsk3 = new AirTicket(4, 5050, "LED", "SVO", 70);
    private AirTicket mskSpb2 = new AirTicket(5, 5000, "SVO", "LED", 80);

    @BeforeEach
    public void setUp() {
        manager.add(spbMsk1);
        manager.add(spbMsk2);
        manager.add(mskSpb1);
        manager.add(spbMsk3);
        manager.add(mskSpb2);
    }

    @Test
    public void findByParamTest() {
        AirTicket[] actual = manager.findByParam("LED", "SVO");
        AirTicket[] expected = new AirTicket[]{spbMsk2, spbMsk1, spbMsk3};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByNotFoundParamTest() {
        AirTicket[] actual = manager.findByParam("LED", "VKO");
        AirTicket[] expected = new AirTicket[]{};

        assertArrayEquals(expected, actual);
    }
}
