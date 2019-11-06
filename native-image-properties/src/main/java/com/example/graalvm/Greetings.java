package com.example.graalvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

public class Greetings {

	private static final String GREETING_FILE = "/greeting.txt";

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		String greeting = getGreeting();
		System.out.println(greeting);
	}

	private static String getGreeting() throws IOException, UnsupportedEncodingException {
		try (InputStream inputStream = Greetings.class.getResourceAsStream(GREETING_FILE);
				InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(streamReader)) {
			return bufferedReader.lines().collect(Collectors.joining());
		}
	}

}
