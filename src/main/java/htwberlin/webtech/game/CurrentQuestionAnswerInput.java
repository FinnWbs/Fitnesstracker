package htwberlin.webtech.game;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CurrentQuestionAnswerInput {

    public CurrentQuestionAnswerInput() {}

    @NotNull
    public String currentQuestion;
    public List<String> possibleAnswers;
    public String givenSongName;

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public String getCurrentQuestion() {
        return this.currentQuestion;
    }

    public void setCurrentQuestion(String currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public String getGivenSongName() {
        return givenSongName;
    }

    public void setGivenSongName(String givenSongName) {
        this.givenSongName = givenSongName;
    }

}
