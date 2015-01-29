package sml;

/**
 * This class takes a register number, checks if the contents are zero, and if not, repeats the given instruction
 * @see Instruction
 */

public class BnzInstruction extends Instruction {
	private int register;
	private String instruction;

	public BnzInstruction(String label, String opcode) {
		super(label, opcode);
	}

	public BnzInstruction(String label, int register, String instruction) {
		super(label, "out");
		this.register = register;
		this.instruction = instruction;

	}

	@Override
	public void execute(Machine m) {
		if (m.getRegisters().getRegister(register) != 0){
			//run last instruction
		}
	}

	@Override
	public String toString() {
		return super.toString() + " register " + register + " value printed";
	}
}
