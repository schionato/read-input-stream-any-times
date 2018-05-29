package com.github.schionato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class InputStreamClonerTest {

    private InputStream inputStream;

    @BeforeEach void setUp() {
	this.inputStream = getClass().getResourceAsStream("/file.txt");
    }

    @Test void checkClone() throws Exception {
	InputStreamCloner cloner = new InputStreamCloner(inputStream);

	long firstRead = new BufferedReader(new InputStreamReader(cloner.makeCopy()))
			.lines()
			.count();
	assertEquals(3, firstRead);

	long secondRead = new BufferedReader(new InputStreamReader(cloner.makeCopy()))
			.lines()
			.count();
	assertEquals(3, secondRead);
    }


}