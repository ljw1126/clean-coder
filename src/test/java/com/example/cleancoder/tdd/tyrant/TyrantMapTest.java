package com.example.cleancoder.tdd.tyrant;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class TyrantMapTest {

    @Test
    void getRetrievesWhatWasPut() throws IOException {
        TyrantMap tyrantMap = new TyrantMap();
        tyrantMap.open();
        tyrantMap.put("key", "value");
        assertThat(tyrantMap.get("key")).isEqualTo("value".getBytes());
        tyrantMap.close();
    }
}
