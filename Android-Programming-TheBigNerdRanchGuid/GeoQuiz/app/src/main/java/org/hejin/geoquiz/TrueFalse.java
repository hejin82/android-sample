package org.hejin.geoquiz;

public class TrueFalse {

    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean trueQuestion) {
        this.mQuestion = question;
        this.mTrueQuestion = trueQuestion;
    }

    public int getMQuestion() {
        return mQuestion;
    }

    public void setMQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isMTrueQuestion() {
        return mTrueQuestion;
    }

    public void setMTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }
}
