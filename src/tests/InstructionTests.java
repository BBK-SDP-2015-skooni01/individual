package tests;

import org.junit.*;
import static org.junit.Assert.*;
import sml.Machine;

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
    private final String[] testFile = {"tests/testfile"};

    @Before
    public void buildUp(){
        m = new Machine();
    }
}
