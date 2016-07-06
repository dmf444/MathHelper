package dmf444.MathHelper.Attempt3.Question;

import java.util.Random;

/**
 * Created by TeamDMFMM on 7/6/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class MathQuestionCreater {

    public static Operator createQuestion() {

        Random random = new Random();

        Operator o = pickOperator(random, 1);
        System.out.println(o.represent());
        System.out.println(o.valueOf());
        return o;
    }

    private static Operator pickOperator(Random rand, int nest) {
        Operator possible = null;
        int base = rand.nextInt(6);
        int max = 99;
        if (base > 3) {
            max = 9;
        }
        IOperand left = getEdge(rand, nest + 1, max);
        IOperand right = getEdge(rand, nest + 1, max);
        while (possible == null || !possible.canUseAsInt()) {
            switch (base) {
                case 0:
                case 1:
                    possible = new Operators.AddOperator(left, right);
                    break;
                case 2:
                case 3:
                    possible = new Operators.SubtractOperator(left, right);
                    break;
                case 4:
                    possible = new Operators.MultiplyOperator(left, right);
                    break;
                case 5:
                    possible = new Operators.DivideOperator(left, right);
                    break;
            }
        }

        return possible;
    }

    private static IOperand getEdge(Random rand) {
        return getEdge(rand, 1, 99);
    }

    private static IOperand getEdge(Random rand, int max) {
        return getEdge(rand, 1, max);
    }

    private static IOperand getEdge(Random rand, int nest, int max) {
        if ((7 / nest) > 3 && rand.nextInt(7 / nest) <= 2) {
            return pickOperator(rand, nest);
        }
        else {
            int num = rand.nextInt(max) + 1;
            return new Operators.NumberOperand(num);
        }
    }

}
