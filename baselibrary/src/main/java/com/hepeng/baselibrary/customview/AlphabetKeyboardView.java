package com.hepeng.baselibrary.customview;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.hepeng.life.baselibrary.R;

public class AlphabetKeyboardView {
    private Context context;
    private KeyboardView alphaKeyboard;
    private Keyboard keyboard;
    private KeyboardViewHCallBack keyboardViewHCallBack;

    public interface KeyboardViewHCallBack {

    }


    public AlphabetKeyboardView(Context context, KeyboardView alphaKeyboard) {
        this.context = context;
        this.alphaKeyboard = alphaKeyboard;
//        this.keyboardViewHCallBack = keyboardViewHCallBack;
        initView();
    }

    public void initView() {
        keyboard = new Keyboard(context, R.xml.keyboard_view);
        alphaKeyboard.setKeyboard(keyboard);
        alphaKeyboard.setEnabled(true);
        alphaKeyboard.setPreviewEnabled(false);
        alphaKeyboard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction() == MotionEvent.ACTION_MOVE;
            }
        });
    }

    public void setEditText(final EditText editText) {
        alphaKeyboard.setOnKeyboardActionListener(new KeyboardView.OnKeyboardActionListener() {
            @Override
            public void onPress(int primaryCode) {

            }

            @Override
            public void onRelease(int primaryCode) {

            }

            @Override
            public void onKey(int primaryCode, int[] keyCodes) {
                try {
                    Editable editable = editText.getText();
                    int start = editText.getSelectionStart();
                    int end = editText.getSelectionEnd();
                    if (primaryCode == Keyboard.KEYCODE_CANCEL) {
                        // 隐藏键盘
                        alphaKeyboard.setVisibility(View.GONE);
                    } else if (primaryCode == Keyboard.KEYCODE_DELETE || primaryCode == -35) {
                        // 回退键,删除字符
                        if (editable != null && editable.length() > 0) {
                            if (start == end) { //光标开始和结束位置相同, 即没有选中内容
                                editable.delete(start - 1, start);
                            } else { //光标开始和结束位置不同, 即选中EditText中的内容
                                editable.delete(start, end);
                            }
                        }
                    } else {
                        editable.replace(start, end, Character.toString((char) primaryCode));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onText(CharSequence text) {

            }

            @Override
            public void swipeLeft() {

            }

            @Override
            public void swipeRight() {

            }

            @Override
            public void swipeDown() {

            }

            @Override
            public void swipeUp() {

            }
        });
    }
}
