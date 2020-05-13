package com.example.hmd;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private String word;
    private int color;

    private MutableLiveData<Boolean> finishedCalc;
    private MutableLiveData<Boolean> setChecked;

    public MyViewModel() {
        finishedCalc = new MutableLiveData<>(false);
        setChecked = new MutableLiveData<>(false);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public MutableLiveData<Boolean> getFinishedCalc() {
        return finishedCalc;
    }

    public void postFinishedCalc(Boolean finishedCalc) {
        this.finishedCalc.postValue(finishedCalc);
    }

    public MutableLiveData<Boolean> getSetChecked() {
        return setChecked;
    }

    public void setSetChecked(Boolean setChecked) {
        this.setChecked.setValue(setChecked);
    }

    public void postSetChecked(Boolean setChecked) {
        this.setChecked.postValue(setChecked);
    }
}
