package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Montgomery F.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId(){
        assertEquals("Asuasuasu1", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name(){
        Team t = Developer.getTeam();
        assertEquals("s25-04", t.getName());
        assertTrue(t.getMembers().contains("Ethan S."), "Team should contain Ethan S.");
        assertTrue(t.getMembers().contains("Fahim Z."), "Team should contain Fahim Z.");
        assertTrue(t.getMembers().contains("Jeremiah W."), "Team should contain Jeremiah W.");
        assertTrue(t.getMembers().contains("Joe L."), "Team should contain Joe L.");
        assertTrue(t.getMembers().contains("Montgomery F."), "Team should contain Montgomery F.");
        assertTrue(t.getMembers().contains("Renbo Z."), "Team should contain Renbo Z.");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
