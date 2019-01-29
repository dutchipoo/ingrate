package com.dutchipoo.ingrate;

import static org.junit.Assert.assertEquals;

import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

public class UnixDataDirectoryTest {
    System mockedSystem = null;
    UnixDataDirectory udd = null;

    @Before
    public void beforeEachTest() {
	mockedSystem = Mockito.mock(System.class);
	udd = new UnixDataDirectory(mockedSystem);
    }

    @Test
    public void nonExistentEnvironmentVariable() {
	Mockito.when(mockedSystem.getenv()).thenReturn(new Map());
	assertEquals(udd.getPath(), "");
    }

    @Test
    public void emptyEnvironmentVariable() {
	Mockito.when(mockedSystem.getenv()).thenReturn(Map.of("XDG_DATA_HOME", ""));
	assertEquals(udd.getPath(), "");
    }

    @Test
    public void existentEnvironmentVariable() {
	Mockito.when(mockedSystem.getenv()).thenReturn(Map.of("XDG_DATA_HOME", "foo"));
	assertEquals(udd.getPath(), "foo");
    }
}
