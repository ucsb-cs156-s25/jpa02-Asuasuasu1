package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_self_returns_correct_bool(){
        assert(team.equals(team));
    }

    @Test
    public void equals_other_class_returns_correct_bool(){
        TeamTest test = new TeamTest();
        assertEquals(team.equals(test), false);
    }

    @Test
    public void equals_returns_correct_bool(){
        Team team1 = new Team("s25-04");
        team1.addMember("Ethan S.");
        team1.addMember("Fahim Z.");
        team1.addMember("Jeremiah W.");
        team1.addMember("Joe L.");
        team1.addMember("Montgomery F.");
        team1.addMember("Renbo Z.");
        
        assertEquals(team.equals(team1), false);

        Team team2 = new Team("s25-04");
        team2.addMember("Ethan S.");
        team2.addMember("Fahim Z.");
        team2.addMember("Jeremiah W.");
        team2.addMember("Joe L.");
        team2.addMember("Montgomery F.");
        
        assertEquals(team1.equals(team2), false);

        team2.addMember("Renbo Z.");

        assertEquals(team1.equals(team2), true);
    }

    @Test
    public void hash_code_returns_correct_hash(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        int result = team.hashCode();
        int expectedResult = -1226298695; // obtained from manually checking result of hashcode
        assertEquals(expectedResult, result);
    }

}
