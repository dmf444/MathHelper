package dmf444.MathHelper.Attempt3.Question;

/**
 * Created by TeamDMFMM on 7/6/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public abstract class Operator implements IOperand {
    protected abstract float operateOn(float v1, float v2);

    protected abstract String humanOperatorType();

    public abstract int priority();
    public IOperand left;
    public IOperand right;

    public Operator(IOperand left, IOperand right) {
        this.left = left;
        this.right = right;
    }

    public float calculate() {
        return this.operateOn(this.left.valueOf(), this.right.valueOf());
    }

    public boolean canUseAsInt() {
        return true;
    }

    public float valueOf() {
        return this.calculate();
    }

    public String represent() {
        String left = "";
        String right = "";
        if (this.left.priority() < this.priority()) {
            left = "(" + this.left.represent() + ")";
        }
        else {
            left = this.left.represent();
        }
        if (this.right.priority() < this.priority()) {
            right = "(" + this.right.represent() + ")";
        }
        else {
            right = this.right.represent();
        }
        return left + " " + this.humanOperatorType() + " " + right;
    }
}
