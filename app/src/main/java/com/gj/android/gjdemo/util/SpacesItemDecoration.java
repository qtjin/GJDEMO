package com.gj.android.gjdemo.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by guojing on 2017/3/24 0024.
 */

public class SpacesItemDecoration  extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        //outRect.right = space;

        //不是第一个的格子都设一个左边和底部的间距
        outRect.left = space;
        //outRect.bottom = space;

        int position = parent.getChildLayoutPosition(view);



        if (position == 0){
            outRect.left = 0; //放置banner
        }else if (position == 1){
            outRect.left = 0; //放置title
        }else if (2<=position && position <= 7){ //放两个
            if ((parent.getChildLayoutPosition(view)-1)%2==0) {
                outRect.right = space;
            }
        }else if (position == 8){
            outRect.left = 0; //放置title
        }else if (9<=position && position <= 14){ //放三个
            //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
            if ((parent.getChildLayoutPosition(view)-8)%3==0) {
                outRect.right = space;
            }
        }else if (position == 15){
            outRect.left = 0; //放置title
        }else if (16<=position && position <= 18){ //放一个
            outRect.left = 0;
        }else if (position == 19){
            outRect.left = 0; //放置title
        }else {
            if ((parent.getChildLayoutPosition(view)-18)%2==0) {
                outRect.right = space;
            }
        }


//        // Add top margin only for the first item to avoid double space between items
//        if (parent.getChildLayoutPosition(view) == 0) {
//            outRect.top = space;
//        } else {
//            outRect.top = 0;
//        }
    }
}