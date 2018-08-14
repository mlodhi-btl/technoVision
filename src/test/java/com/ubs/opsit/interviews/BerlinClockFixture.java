package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing
 * stories. You should not need to edit this class to complete the exercise,
 * this is your definition of done.
 */
public class BerlinClockFixture {

	private TimeConverter berlinClock;
	private String theTime;

	@Before
	public void setUp() {
		berlinClock = new BerlinClock();
	}

	@Test
	public void berlinClockAcceptanceTests() throws Exception {
		aBehaviouralTestRunner().usingStepsFrom(this).withStory("berlin-clock.story").run();
	}

	@When("the time is $time")
	public void whenTheTimeIs(String time) {
		theTime = time;
	}

	@Then("the clock should look like $")
	public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
		assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
	}

	@Test
	public void testProcessTopHour() {

		assertThat(TimeUtil.processTopHours(0)).isEqualTo("OOOO");
		assertThat(TimeUtil.processTopHours(13)).isEqualTo("RROO");
		assertThat(TimeUtil.processTopHours(23)).isEqualTo("RRRR");
		assertThat(TimeUtil.processTopHours(24)).isEqualTo("RRRR");

	}

	@Test
	public void testProcessBottomHour() {

		assertThat(TimeUtil.processBottomHours(13)).isEqualTo("RRRO");
	}

	@Test
	public void testProcessTopMinutes() {
		assertThat(TimeUtil.processTopMinutes(0)).isEqualTo("OOOOOOOOOOO");
		assertThat(TimeUtil.processTopMinutes(17)).isEqualTo("YYROOOOOOOO");
		assertThat(TimeUtil.processTopMinutes(59)).isEqualTo("YYRYYRYYRYY");

	}

	@Test
	public void testProcessBottomMinutes() {

		assertThat(TimeUtil.processBottomMinutes(3)).isEqualTo("YYYO");

	}

	@Test
	public void testProcessSecounsON() {

		assertThat(TimeUtil.processSeconds(0)).isEqualTo("Y");

	}

	@Test
	public void testProcessSecoundOff() {
		assertThat(TimeUtil.processSeconds(59)).isEqualTo("O");

	}

}
