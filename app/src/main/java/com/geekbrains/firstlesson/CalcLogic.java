package com.geekbrains.firstlesson;

public class CalcLogic {
    private int firstArg;
    private int secondArg;
    private State state;
    private int actionChoose;

    StringBuilder input = new StringBuilder();

    private enum State {
        firstArgIn,
        secondArgIn,
        resultOut,
        operationChoose
    }

    public CalcLogic() {
        state = State.firstArgIn;
    }

    public void onNumberClick(int numbersId) {
        if (state == State.resultOut) {
            state = State.firstArgIn;
            input.setLength(0);
        }

        if (state == State.operationChoose) {
            state = State.secondArgIn;
            input.setLength(0);
        }

        if (input.length() < 9) {
            switch (numbersId) {
                case R.id.button0:
                    if (input.length() != 0) {
                        input.append("0");
                    }
                    break;
                case R.id.button1:
                    input.append("1");
                    break;
                case R.id.button2:
                    input.append("2");
                    break;
                case R.id.button3:
                    input.append("3");
                    break;
                case R.id.button4:
                    input.append("4");
                    break;
                case R.id.button5:
                    input.append("5");
                    break;
                case R.id.button6:
                    input.append("6");
                    break;
                case R.id.button7:
                    input.append("7");
                    break;
                case R.id.button8:
                    input.append("8");
                    break;
                case R.id.button9:
                    input.append("9");
                    break;
            }
        }
    }

    public void onActionClick(int actionId) {
        if (actionId == R.id.buttonEqually && state == State.secondArgIn && input.length() > 0) {
            secondArg = Integer.parseInt(input.toString());
            state = State.resultOut;
            input.setLength(0);
            switch (actionChoose) {
                case R.id.buttonPlus:
                    input.append(firstArg + secondArg);
                    break;
                case R.id.buttonSubtraction:
                    input.append(firstArg - secondArg);
                    break;
                case R.id.buttonMultiplication:
                    input.append(firstArg * secondArg);
                    break;
                case R.id.buttonDivision:
                    input.append(firstArg / secondArg);
                    break;
                case R.id.buttonClear:
                    state = State.firstArgIn;
                    input.setLength(0);
                    break;
            }
        } else if (input.length() > 0 && state == State.firstArgIn) {
            firstArg = Integer.parseInt(input.toString());
            state = State.operationChoose;
            actionChoose = actionId;
        }
    }

    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (state) {
            default:
                return input.toString();
            case operationChoose:
                return stringBuilder.append(firstArg).append(" ").append(getOperationChar()).toString();
            case secondArgIn:
                return stringBuilder.append(firstArg).append(" ").append(getOperationChar()).append(" ").append(input).toString();
            case resultOut:
                return stringBuilder.append(getOperationChar()).append(" ").append(secondArg).append(" = ").append(input).toString();
        }
    }

    private char getOperationChar() {
        switch (actionChoose) {
            case R.id.buttonPlus:
                return '+';
            case R.id.buttonSubtraction:
                return '-';
            case R.id.buttonMultiplication:
                return '*';
            case R.id.buttonDivision:
            default:
                return '/';
        }
    }

    public void reset(int actionId) {
        if (actionId == R.id.buttonClear) {
            state = State.firstArgIn;
            input.setLength(0);
        }
    }
}
