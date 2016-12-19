package com.hindustaniandroidapps.anuptiwari.bharatkojano.samanyagyan_bhartiyadharmaursanskriti;

/**
 * Created by anuptiwari on 11/28/2016.
 */

public class QuestionAnswers {

    private String mShortText;
    private String mQuestionText;
    private String mAnswerText;

    public QuestionAnswers(String shortText, String questionText, String answerText){
        this.mShortText = shortText;
        this.mQuestionText = questionText;
        this.mAnswerText = answerText;
    }

    public String getShortText(){
        return mShortText;
    }

    public String getQuestionText(){
        return mQuestionText;
    }

    public String getAnswerText(){
        return mAnswerText;
    }
}
