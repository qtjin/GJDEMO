package com.gj.android.gjdemo.widget.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gj.android.commonlibrary.util.AbDensityUtils;
import com.gj.android.commonlibrary.widget.GlideImageLoader;
import com.gj.android.gjdemo.MyApplication;
import com.gj.android.gjdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/24.
 */
public class OneRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    //private List<Cheese> results;

    //type
    public static final int TYPE_SLIDER = 0xff01;
    public static final int TYPE_TYPE2_HEAD = 0xff02;
    public static final int TYPE_TYPE2 = 0xff03;
    public static final int TYPE_TYPE3_HEAD = 0xff04;
    public static final int TYPE_TYPE3 = 0xff05;
    public static final int TYPE_TYPE4 = 0xff06;

    public OneRecycleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_SLIDER:
                return new HolderSlider(LayoutInflater.from(parent.getContext()).inflate(R.layout.onerecycle_banner, parent, false));
            case TYPE_TYPE2_HEAD:
            case TYPE_TYPE3_HEAD:
                return new HolderType2Head(LayoutInflater.from(parent.getContext()).inflate(R.layout.onerecycle_item_head, parent, false));
            case TYPE_TYPE2:
            case TYPE_TYPE3:
            case TYPE_TYPE4:
                return new HolderType2(LayoutInflater.from(parent.getContext()).inflate(R.layout.onerecycle_item, parent, false));
            default:
                Log.d("error","viewholder is null");
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HolderSlider){
            bindTypeSlider((HolderSlider) holder, position);
        }else if (holder instanceof HolderType2Head){
            bindType2Head((HolderType2Head) holder, position);
        }else if (holder instanceof HolderType2){
            bindType2((HolderType2) holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return TYPE_SLIDER;
        }else if (position == 1){
            return TYPE_TYPE2_HEAD;
        }else if (2<=position && position <= 7){
            return TYPE_TYPE2;
        }else if (position == 8){
            return TYPE_TYPE3_HEAD;
        }else if (9<=position && position <= 14){
            return TYPE_TYPE3;
        }else if (position == 15){
            return TYPE_TYPE3_HEAD;
        }else if (16<=position && position <= 18){
            return TYPE_TYPE4;
        }else if (position == 19){
            return TYPE_TYPE3_HEAD;
        }else if(position > 19){
            return TYPE_TYPE2;
        }else{
            return -1;
        }
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    switch (type){
                        case TYPE_SLIDER:
                        case TYPE_TYPE2_HEAD:
                        case TYPE_TYPE3_HEAD:
                        case TYPE_TYPE4:
                            return gridManager.getSpanCount(); //getSpanSize方法，返回值就表示当前item占多少列，例如如果我们列数设置的为3列，返回3就表示铺满，也就是和列表一样了。
                        case TYPE_TYPE2:
                            return 3;
                        case TYPE_TYPE3:
                            return 2;
                        default:
                            return 3;
                    }
                }
            });
        }
    }

    /////////////////////////////

    private void bindTypeSlider(HolderSlider holder, int position){
        //String img = "http://pic16.nipic.com/20110921/7247268_215811562102_2.jpg";
        //String[] imgs= new String[]{img,img,img,img,img,img,img};
//        holder.slideShowView.setImageUrls(imgs);
//        holder.slideShowView.startPlay();
        initBanner(holder.banner,initImages());
        
    }

    private List initImages(){
        List images = new ArrayList();
        images.add("http://fdfs.xmcdn.com/group27/M04/6F/19/wKgJW1jSRfWRjY8IAANcGy2lIlg411_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group26/M03/72/74/wKgJWFjSNRixLtfpAALI_ao_WUI918_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group26/M06/73/5C/wKgJWFjSRqCRtMU0AAJAS1Nc8Qk463_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group26/M05/73/5D/wKgJRljSRwugukA7AAI2I3x9Hf8482_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group27/M09/6F/2B/wKgJW1jSR0HR4JGCAAJqkNNrfmw977_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group27/M0B/6E/CD/wKgJW1jSQD2hdHVQAAEI37_VSsY209_android_large.jpg");
        images.add("http://fdfs.xmcdn.com/group24/M06/D3/BE/wKgJMFi74t2g5FWLAAFG4rZ-hbI011_android_large.jpg");
        return images;
    }

    
    private void initBanner(Banner banner, List images){
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);

        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
    

    private void bindType2Head(HolderType2Head holder, int position){
    }

    private void bindType2(HolderType2 holder, int position){
        String url = "http://fdfs.xmcdn.com/group20/M09/E5/EB/wKgJJ1fO6sbjNgT-AAE04GeNhPI824_mobile_x_large.jpg";
        final ImageView imgView = holder.item_img_type2;

        ViewGroup.LayoutParams params = imgView.getLayoutParams();

        if (2<=position && position <= 7){
            params.height = MyApplication.SCREEN_WIDTH/2 - AbDensityUtils.dip2px(context,9);
        }else if (9<=position && position <= 14){
            params.height = MyApplication.SCREEN_WIDTH/3 - AbDensityUtils.dip2px(context,12);
        }else if(position>19){
            params.height = MyApplication.SCREEN_WIDTH/2 - AbDensityUtils.dip2px(context,9);
        }

        imgView.setLayoutParams(params);
//        ImageLoader.getInstance().displayImage(url, imgView);

        Glide.with(context).load(url).placeholder(R.drawable.ic_picture_loading)
                .error(R.drawable.ic_picture_loadfailed).into(imgView);

    }


    /////////////////////////////

    public class HolderSlider extends RecyclerView.ViewHolder {
        public Banner banner;

        public HolderSlider(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    public class HolderType2Head extends RecyclerView.ViewHolder {
        public HolderType2Head(View itemView) {
            super(itemView);
        }
    }
    public class HolderType2 extends RecyclerView.ViewHolder {
        public ImageView item_img_type2;

        public HolderType2(View itemView) {
            super(itemView);
            item_img_type2 = (ImageView) itemView.findViewById(R.id.item_img_type2);
        }
    }

}
