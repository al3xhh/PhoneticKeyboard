package com.example.al3x_hh.phonetickeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

/**
 * Created by Alejandro Huertas Herrero on 01/08/2017.
 *
 * Clase que controla todos los eventos del teclado desde su creación.
 */
public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private int lastCode;

    @Override
    public View onCreateInputView() {
        KeyboardView kv = (KeyboardView) getLayoutInflater().inflate(R.layout.input, null);
        Keyboard keyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        kv.setPreviewEnabled(false);

        return kv;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();

        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                ic.commitText(String.valueOf((char)primaryCode), 1);
        }

        lastCode = -13;
    }

    @Override
    public void onPress(int primaryCode) {
        InputConnection ic = getCurrentInputConnection();

        if(primaryCode == 0) {
            if(lastCode == 101 || lastCode == 603) {
                lastCode = 603;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 114 || lastCode == 638) {
                lastCode = 638;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 111 || lastCode == 596) {
                lastCode = 596;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 97 || lastCode == 601) {
                lastCode = 601;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 115 || lastCode == 122) {
                lastCode = 122;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 100 || lastCode == 240) {
                lastCode = 240;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 103 || lastCode == 611) {
                lastCode = 611;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 108 || lastCode == 619) {
                lastCode = 619;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 98 || lastCode == 946) {
                lastCode = 946;
                ic.commitText(String.valueOf((char)lastCode), 1);
            } else if(lastCode == 109 || lastCode == 625) {
                lastCode = 625;
                ic.commitText(String.valueOf((char)lastCode), 1);
            }
        } else {
            lastCode = primaryCode;
        }
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }
}



