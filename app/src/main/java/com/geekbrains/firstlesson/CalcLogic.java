package com.geekbrains.firstlesson;

public class CalcLogic {
    private int firstArg;
    private int secondArg;
    private State state;

    StringBuilder input = new StringBuilder();

    private enum State {
        firstArgIn,
        secondArgIn,
        resultOut
    }

    public CalcLogic() {
        state = State.firstArgIn;
    }

    public void onNumberClick(int numbersId) {
        switch (numbersId) {
            case R.id.button1:
                input.append("1");
                break;
            case R.id.button2:
                input.append("2");
                break;
        }
    }

    public void onActionClick(int actionId) {

    }

    public String getText() {
        return input.toString();
    }
}
