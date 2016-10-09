package imcs.cb.com.groupitemdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import imcs.cb.com.groupitemdemo.adapter.MyExpandableListAdapter;

public class MainActivity extends Activity {
    private ExpandableListView elv_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elv_demo = (ExpandableListView) findViewById(R.id.elv_demo);

        MyExpandableListAdapter myExpandableListAdapter = new MyExpandableListAdapter(this);
        elv_demo.setAdapter(myExpandableListAdapter);
    }
}
