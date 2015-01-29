package tests;

import org.junit.*;
import static org.junit.Assert.*;
import sml.Machine;
import sml.Translator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for the Instruction classes.
 * Input file is testfile in the current package
 * Register 3: add
 * Register 4: sub
 * Register 5: mul
 * Register 6: div
 */
public class InstructionTests {
    private Machine m;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void buildUp(){
        m = new Machine();
        //System.setOut(new PrintStream(out));
        String testFile = "tests/testfile";
        Translator t = new Translator(testFile);
        //directly calling methods appearing in Machine.main to avoid call to static method
        t.readAndTranslate(m.getLabels(), m.getProg());
        System.out.println("Here is the program; it has " + m.getProg().size() + " instructions.");
        System.out.println(m);

        System.out.println("Beginning program execution.");
        m.execute();
        System.out.println("Ending program execution.");

        System.out.println("Values of registers at program termination:");
        System.out.println(m.getRegisters() + ".");

    }

    @Test
    public void testAdd(){
        assertEquals(m.getRegisters().getRegister(3), 15);
    }

    @Test
    public void testLin(){
        assertEquals(m.getRegisters().getRegister(1), 10);
    }

    @Test
    public void testSub(){
        assertEquals(m.getRegisters().getRegister(4), -5);
    }

    @Test
    public void testMul(){
        assertEquals(m.getRegisters().getRegister(5),50);
    }

    @Test
    public void testDiv(){
        assertEquals(m.getRegisters().getRegister(6), 2);
    }

    @Test
    public void testBnz() {assertEquals(m.getRegisters().getRegister(3),12);}    /*@Test
    public void testOut(){
        assertEquals("10\n", out.toString());
    }*/

    //    @After
//    public void closeDown(){
//        System.setOut(null);
//    }
}
