package tests;

import org.junit.*;
import static org.junit.Assert.*;
import sml.Machine;
import sml.Translator;

/**
 * Tests for the Instruction classes.
 * Input file stored in array and passed into Machine.main()
 * Register 3: add
 * Register 4: sub
 * Register 5: mul
 * Register 6: div
 */
public class InstructionTests {
    private Machine m;
    private Translator t;
    private final String testFile = "tests/testfile";

    @Before
    public void buildUp(){
        m = new Machine();
        t = new Translator(testFile);
        //directly calling methods appearing in Machine.main to avoid call to static method
        t.readAndTranslate(m.getLabels(), m.getProg());
        m.execute();

    }

    @Test
    public void testAdd(){
        assertEquals(m.getRegisters().getRegister(3), 15);
    }
}
