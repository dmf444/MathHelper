package dmf444.MathHelper.Attempt3.Question;

/**
 * Created by TeamDMFMM on 7/6/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class Operators {
    public static class AddOperator extends Operator {
        public AddOperator(IOperand left, IOperand right) {
            super(left, right);
        }

        @Override
        protected float operateOn(float v1, float v2) {
            return v1 + v2;
        }

        @Override
        protected String humanOperatorType() {
            return "+";
        }

        @Override
        public int priority() {
            return 1;
        }
    }

    public static class SubtractOperator extends Operator {
        public SubtractOperator(IOperand left, IOperand right) {
            super(left, right);
        }

        @Override
        protected float operateOn(float v1, float v2) {
            return v1 - v2;
        }

        @Override
        protected String humanOperatorType() {
            return "-";
        }

        @Override
        public int priority() {
            return 1;
        }
    }

    public static class MultiplyOperator extends Operator {
        public MultiplyOperator(IOperand left, IOperand right) {
            super(left, right);
        }

        @Override
        protected float operateOn(float v1, float v2) {
            return v1 * v2;
        }

        @Override
        protected String humanOperatorType() {
            return "x";
        }

        @Override
        public int priority() {
            return 2;
        }
    }

    public static class DivideOperator extends Operator {
        public DivideOperator(IOperand left, IOperand right) {
            super(left, right);
        }

        @Override
        public boolean canUseAsInt() {
            return (double)left.valueOf() / right.valueOf() == (int)((double)left.valueOf() / right.valueOf());
        }

        @Override
        protected float operateOn(float v1, float v2) {
            return v1 / v2;
        }

        @Override
        protected String humanOperatorType() {
            return String.valueOf((char)(247));
        }

        @Override
        public int priority() {
            return 2;
        }
    }

    public static class NumberOperand implements IOperand {
        int value;

        public NumberOperand(int value) {
            this.value = value;
        }

        @Override
        public String represent() {
            return String.valueOf(value);
        }

        @Override
        public float valueOf() {
            return value;
        }

        @Override
        public int priority() {
            return 10;
        }
    }
}
