package ru.netology.RepositoryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTicket;
import ru.netology.repository.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepositoryTest {
    private Repository repository = new Repository();
    private AirTicket spbMsk1 = new AirTicket(1, 2500, "LED", "SVO", 70);
    private AirTicket spbMsk2 = new AirTicket(2, 2450, "LED", "SVO", 85);
    private AirTicket mskSpb1 = new AirTicket(3, 2550, "SVO", "LED", 80);
    private AirTicket spbMsk3 = new AirTicket(4, 5050, "LED", "SVO", 70);
    private AirTicket mskSpb2 = new AirTicket(5, 5000, "SVO", "LED", 80);

    @BeforeEach
    public void setUp() {
        repository.save(spbMsk1);
        repository.save(spbMsk2);
        repository.save(mskSpb1);
        repository.save(spbMsk3);
        repository.save(mskSpb2);
    }

    @Test
    public void findAllTest() {
        AirTicket[] actual = repository.findAll();
        AirTicket[] expected = new AirTicket[]{spbMsk1, spbMsk2, mskSpb1, spbMsk3, mskSpb2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        AirTicket[] actual = repository.removeById(4);
        AirTicket[] expected = new AirTicket[]{spbMsk1, spbMsk2, mskSpb1, mskSpb2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToTest() {
        AirTicket[] expected = new AirTicket[]{spbMsk2, spbMsk1, mskSpb1, mskSpb2, spbMsk3};
        AirTicket[] actual = new AirTicket[]{spbMsk1, spbMsk2, mskSpb1, spbMsk3, mskSpb2};
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}
