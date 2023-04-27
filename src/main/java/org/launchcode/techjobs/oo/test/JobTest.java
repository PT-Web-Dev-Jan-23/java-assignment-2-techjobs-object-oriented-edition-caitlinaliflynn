package org.launchcode.techjobs.oo.test;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1 instanceof Job);
        assertEquals("Product tester", job1.getName());

        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("ACME", job1.getEmployer().getValue());

        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Desert", job1.getLocation().getValue());

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job1.getPositionType().getValue());

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1 == job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job1.toString().charAt(0), '\n');
        assertEquals(job1.toString().charAt(job1.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: " + job1.getName() + "\n" +
                "Employer: " + job1.getEmployer() + "\n" +
                "Location: " + job1.getLocation() + "\n" +
                "Position Type: " + job1.getPositionType() + "\n" +
                "Core Competency: " + job1.getCoreCompetency() +
                "\n";

        assertEquals(testString, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job job1 = new Job();

        String testString = "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + "Data not available" +
                "\n";

        assertEquals(testString, job1.toString());
    }

}
