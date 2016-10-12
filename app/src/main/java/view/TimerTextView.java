package view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ricky on 2016/10/11.
 */
public class TimerTextView extends TextView implements Runnable{
    private boolean isRun = false;
    private long secondCount = 60;

    public TimerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setFocusable(true);
        this.setClickable(true);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRun){
                    beginRun();
                }
            }
        });
    }

    @Override
    public void run() {
        if(isRun){
            Log.v("aa:","********************************** > " + Thread.currentThread().getName());
            this.setText(ComputeTime());

            postDelayed(this, 1000);
        }else {
            removeCallbacks(this);
        }
    }

    /**
     * 倒计时计算
     */
    private String ComputeTime() {
        String backTime = "";
        secondCount--;
        if (secondCount <= 0) {
            backTime = "重新获取";

            secondCount = 60;
            this.isRun = false;
            this.setFocusable(true);
            this.setClickable(true);
        }else{
            backTime = secondCount + "秒";
        }
        return backTime;
    }

    public void setSecondCount(long secondCount){
        this.secondCount = secondCount;
    }

    public boolean isRun() {
        return isRun;
    }

    public void beginRun() {
        this.isRun = true;
        this.setFocusable(false);
        this.setClickable(false);
        run();
    }

    public void stopRun(){
        this.isRun = false;
    }
}