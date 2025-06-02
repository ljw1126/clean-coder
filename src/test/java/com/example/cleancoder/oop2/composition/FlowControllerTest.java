package com.example.cleancoder.oop2.composition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Iterator;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FlowControllerTest {

    private Iterator<String> it = Arrays.asList("one", "two").iterator();

    @InjectMocks
    private FlowController controller;

    @Mock
    private LogCollector logCollector;

    @Mock
    private LogWriter logWriter;

    @Mock
    private LogSet logSet;

    @Test
    void shouldParseAndWrite() {
        when(logSet.iterate()).thenReturn(it);
        when(logCollector.collect()).thenReturn(logSet);

        controller.process();

        verify(logCollector, times(1)).collect();
        verify(logWriter, times(2)).write(anyString());
    }
}
