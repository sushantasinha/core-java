package com.java.java8.others;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFileRead {

	public static void main(String[] args) {
		String fileName = "F://linesTxt.txt";
		try (Stream<String> line = Files.lines(Paths.get(fileName))) {
			line.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
