package imcs.cb.com.groupitemdemo.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;

import imcs.cb.com.groupitemdemo.R;

/**
 * Created by Ricky on 2016/10/8.
 */
public class MyExpandableListAdapter implements ExpandableListAdapter {
    private Context context;
    private LayoutInflater inflater;

    public MyExpandableListAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    /**
     * 组的数量
     * @return
     */
    @Override
    public int getGroupCount() {
        return 5;
    }

    /**
     * 第 i 组 的子条目数量
     * @param i
     * @return
     */
    @Override
    public int getChildrenCount(int i) {
        if (i == 0) {
            return 4;
        } else if (i == 1) {
            return 2;
        } else if (i == 2) {
            return 5;
        }else if (i == 3){
            return 3;
        }else if (i == 4){
            return 2;
        }else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int i) {
        return i;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i*100 + i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     *
     * @param i  第 i 个组群
     * @param b
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View groupView = inflater.inflate(R.layout.item_group  ,null);
        TextView tv_title = (TextView) groupView.findViewById(R.id.tv_title);
        tv_title.setText("组群 " + i);
        return groupView;

//        return null;
    }

    /**
     *
     * @param i  第 i 组
     * @param i1  第 i 组 的 第 i1 行
     * @param b
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View childView = inflater.inflate(R.layout.item_child  ,null);
        TextView tv_title_child = (TextView) childView.findViewById(R.id.tv_title_child);
        tv_title_child.setText(i + "组  " + i1 + "子项");
        return childView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }
}
