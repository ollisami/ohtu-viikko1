/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ollisami
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;
    
    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    } 
    
    @Test
    public void searchToimii() {
        Player p = stats.search("asdasd");
        assertTrue(p == null);
        
        p = stats.search("Kurri");
        assertFalse(p == null);
        assertTrue(p.getName().contains("Kurri"));
    }
    
    @Test
    public void teamToimii() {
        Player p = stats.search("asdasd");
        assertFalse(stats.team("EDM").isEmpty());
        assertTrue(stats.team("TEST").isEmpty());
    }
    
    @Test
    public void topScorersToimii() {
        List<Player> p = stats.topScorers(0);
        assertFalse(p.isEmpty());
        
        p = stats.topScorers(0);
        assertEquals(1, p.size());
        
        p = stats.topScorers(3);
        assertEquals(4, p.size());
    }

}
