package fr.ecp.is1220.projet.part2.simulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeManagerTest {
	@Test
	public void formatTimeTest1() {
		assertEquals(timeManager.formatTime(124.45), "2h4");
	}

}
