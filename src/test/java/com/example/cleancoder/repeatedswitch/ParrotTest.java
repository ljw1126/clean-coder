package com.example.cleancoder.repeatedswitch;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParrotTest {

    @Test
    public void getSpeedOfEuropeanParrot() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_One_Coconut() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.AFRICAN, 1, 0, false);
        assertEquals(3.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_Two_Coconuts() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.AFRICAN, 2, 0, false);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedOfAfricanParrot_With_No_Coconuts() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.AFRICAN, 0, 0, false);
        assertEquals(12.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_nailed() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, true);
        assertEquals(0.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 1.5, false);
        assertEquals(18.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getSpeedNorwegianBlueParrot_not_nailed_high_voltage() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 4, false);
        assertEquals(24.0, parrot.getSpeed(), 0.0);
    }

    @Test
    public void getCryOfEuropeanParrot() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.EUROPEAN, 0, 0, false);
        assertEquals("Sqoork!", parrot.getCry());
    }

    @Test
    public void getCryOfAfricanParrot() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.AFRICAN, 1, 0, false);
        assertEquals("Sqaark!", parrot.getCry());
    }

    @Test
    public void getCryOfNorwegianBlueHighVoltage() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 4, false);
        assertEquals("Bzzzzzz", parrot.getCry());
    }

    @Test
    public void getCryOfNorwegianBlueNoVoltage() {
        Parrot parrot = Parrot.of(ParrotTypeEnum.NORWEGIAN_BLUE, 0, 0, false);
        assertEquals("...", parrot.getCry());
    }
}
