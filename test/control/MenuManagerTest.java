/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius.lemos
 */
public class MenuManagerTest {
    
    public MenuManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of logout method, of class MenuManager.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        MenuManager instance = new MenuManager();
        String expResult = "";
        String result = instance.logout();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuUsuario method, of class MenuManager.
     */
    @Test
    public void testMenuUsuario() {
        System.out.println("menuUsuario");
        MenuManager instance = new MenuManager();
        String expResult = "";
        String result = instance.menuUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuGrupo method, of class MenuManager.
     */
    @Test
    public void testMenuGrupo() {
        System.out.println("menuGrupo");
        MenuManager instance = new MenuManager();
        String expResult = "";
        String result = instance.menuGrupo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
