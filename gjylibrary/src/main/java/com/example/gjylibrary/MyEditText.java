package com.example.gjylibrary;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

import androidx.appcompat.widget.AppCompatEditText;

public class MyEditText extends AppCompatEditText {

    public interface onTextContextMenuItemListener {
        public boolean onTextContextMenuItem(int id, String content);
    }
    private onTextContextMenuItemListener onTextContextMenuItemListener;
    //设置监听回调
    public void setZTListener(onTextContextMenuItemListener listener){
        this.onTextContextMenuItemListener = listener;
    }
    public MyEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context) {
        super(context);
    }
    @Override
    public boolean onTextContextMenuItem(int id) {
        if (id == android.R.id.paste) {
            ClipboardManager clip = (ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            onTextContextMenuItemListener.onTextContextMenuItem(id,clip.getText().toString());
        }
        return false;
    }
    /**
     * 屏蔽回车
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                return true;
        }
        return super.dispatchKeyEvent(event);
    }
}