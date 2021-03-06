package tests;

import org.junit.*;
import static org.junit.Assert.*;
import sml.Machine;
import sml.Translator;


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

    @Before
    public void buildUp(){
        m = new Machine();
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
        //this should be 12 at the end of execution, as it is executed twice:
        // once at
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
    public void testBnz() {assertEquals(m.getRegisters().getRegister(7),3);}

}
