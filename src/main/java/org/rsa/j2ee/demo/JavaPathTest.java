package org.rsa.j2ee.demo;

import java.io.File;

public class JavaPathTest {

	public static void main(String[] args) {
		File test = new File("src/main/resources/a.txt");
		System.out.println(test.getAbsolutePath());
	}

}
