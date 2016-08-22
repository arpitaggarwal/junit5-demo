package com.arpit.aggarwal.junit5.demo.assertion;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.expectThrows;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertionsTests {

	@Test
	void standardAssertions() {
		assertEquals(2, 2);
		assertEquals(4, 4,
				"The optional assertion message is now the last parameter.");
	}

	@Test
	void groupedAssertions() {
		assertAll("address", () -> assertEquals("John", "John"),
				() -> assertEquals("User", "User"));
	}

	@Test
	void exceptionTesting() {
		Throwable exception = expectThrows(IllegalArgumentException.class,
				() -> {
					throw new IllegalArgumentException("a message");
				});
		assertEquals("a message", exception.getMessage());
	}
}
