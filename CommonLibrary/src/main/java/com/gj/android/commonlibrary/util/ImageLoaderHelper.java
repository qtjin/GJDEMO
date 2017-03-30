/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gj.android.commonlibrary.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.gj.android.commonlibrary.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Author:      qiyunfeng
 * Email:       510568444@qq.com | qiyunfeng0618@163.com
 * GitHub:      https://github.com/qiyunfeng0618
 * Date:        15/10/15 上午12:37
 * Description: ImageLoaderHelper
 * <p>
 * <uses-permission android:name="android.permission.INTERNET" />
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 * <p>
 * Acceptable URIs examples
 * "http://site.com/image.png" // from Web
 * "file:///mnt/sdcard/image.png" // from SD card
 * "file:///mnt/sdcard/video.mp4" // from SD card (video thumbnail)
 * "content://media/external/images/media/13" // from content provider
 * "content://media/external/video/media/13" // from content provider (video thumbnail)
 * "assets://image.png" // from assets
 * "drawable://" + R.drawable.img // from drawables (non-9patch images)
 * NOTE: Use drawable:// only if you really need it! Always consider the native way to load drawables - ImageView.setImageResource(...) instead of using of ImageLoader.
 * <p>
 * 注意事项
 * 1.上述提到的2个权限必须加入，否则会出错
 * 2.ImageLoaderConfiguration必须配置并且全局化的初始化这个配置ImageLoader.getInstance().init(config);  否则也会出现错误提示
 * 3.ImageLoader是根据ImageView的height，width确定图片的宽高。
 * 4.如果经常出现OOM（别人那边看到的，觉得很有提的必要）
 * ①减少配置之中线程池的大小.threadPoolSize(3).推荐1-5；
 * ②使用.bitmapConfig(Bitmap.config.RGB_565)代替ARGB_8888;
 * ③使用.imageScaleType(ImageScaleType.IN_SAMPLE_INT)或者try.imageScaleType(ImageScaleType.EXACTLY)；
 * ④避免使用RoundedBitmapDisplayer,他会创建新的ARGB_8888格式的Bitmap对象；
 * ⑤使用.memoryCache(new WeakMemoryCache());
 * ⑥不要使用.cacheInMemory();
 */
@SuppressWarnings("unused")
public class ImageLoaderHelper {

    public static DisplayImageOptions roundedOptions;

    private static Context mContext = null;
    private static volatile ImageLoaderHelper instance = null;

    private ImageLoaderHelper() {

    }

    private ImageLoaderHelper(Context context) {
        mContext = context;
    }

    public static void init(Context context) {
        ImageLoader.getInstance().init(getInstance(context).getImageLoaderConfiguration());
    }

    public static ImageLoaderHelper getInstance(Context context) {
        if (null == instance) {
            synchronized (ImageLoaderHelper.class) {
                if (null == instance) {
                    instance = new ImageLoaderHelper(context);
                    mContext = context;
                }
            }
        }
        return instance;
    }

    public DisplayImageOptions getDisplayOptionsPic() {
        return new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.drawable.ic_picture_loading)//设置图片Uri为空或是错误的时候显示的图片
            .showImageOnLoading(R.drawable.ic_picture_loading)//设置图片在下载期间显示的图片
            .showImageOnFail(R.drawable.ic_picture_loadfailed)//设置图片加载/解码过程中错误时候显示的图片
            .cacheInMemory(true)//设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)//设置下载的图片是否缓存在SD卡中
            .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型
            .imageScaleType(ImageScaleType.EXACTLY)//设置图片以如何的编码方式显示
            .considerExifParams(true)//是否考虑JPEG图像EXIF参数（旋转，翻转）
//            .decodingOptions(android.graphics.BitmapFactory.Options decodingOptions)//设置图片的解码配置
//            .delayBeforeLoading(int delayInMillis)//int delayInMillis为你设置的下载前的延迟时间
//            .preProcessor(BitmapProcessor preProcessor)  //设置图片加入缓存前，对bitmap进行设置
//            .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
//            .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少
//            .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间
            .build();

        /**

         以上配置中的：

         1）.imageScaleType(ImageScaleType imageScaleType)  是设置 图片的缩放方式

         缩放类型mageScaleType:

         EXACTLY :图像将完全按比例缩小的目标大小

         EXACTLY_STRETCHED:图片会缩放到目标大小完全

         IN_SAMPLE_INT:图像将被二次采样的整数倍

         IN_SAMPLE_POWER_OF_2:图片将降低2倍，直到下一减少步骤，使图像更小的目标大小

         NONE:图片不会调整

         2）.displayer(BitmapDisplayer displayer)   是设置 图片的显示方式

         显示方式displayer：

         RoundedBitmapDisplayer（int roundPixels）设置圆角图片

         FakeBitmapDisplayer（）这个类什么都没做

         FadeInBitmapDisplayer（int durationMillis）设置图片渐显的时间

         SimpleBitmapDisplayer()正常显示一张图片　　
         */
    }

    public DisplayImageOptions getDisplayOptions() {
        return new DisplayImageOptions.Builder()
            .showImageOnLoading(R.color.default_image_background)
            .showImageForEmptyUri(R.color.default_image_background)
            .showImageOnFail(R.color.default_image_background)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .imageScaleType(ImageScaleType.EXACTLY)
            .considerExifParams(true)
            .build();
    }

    public DisplayImageOptions getDisplayOptions(Drawable drawable) {
        return new DisplayImageOptions.Builder()
            .showImageOnLoading(drawable)
            .showImageForEmptyUri(drawable)
            .showImageOnFail(drawable)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .imageScaleType(ImageScaleType.EXACTLY)
            .considerExifParams(true)
            .build();
    }

    public DisplayImageOptions getDisplayOptions(int round) {
        return new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .imageScaleType(ImageScaleType.EXACTLY)
            .considerExifParams(true)
            .displayer(new RoundedBitmapDisplayer(AbDensityUtils.dip2px(mContext, round)))
            .build();
    }

    public DisplayImageOptions getDisplayOptions(int round, Drawable drawable) {
        return new DisplayImageOptions.Builder()
            .showImageOnLoading(drawable)
            .showImageForEmptyUri(drawable)
            .showImageOnFail(drawable)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .imageScaleType(ImageScaleType.EXACTLY)
            .considerExifParams(true)
            .displayer(new RoundedBitmapDisplayer(AbDensityUtils.dip2px(mContext, round)))
            .build();

    }

    public DisplayImageOptions getDisplayOptions(boolean isCacheOnDisk) {
        return new DisplayImageOptions.Builder()
            .showImageOnLoading(R.color.default_image_background)
            .showImageForEmptyUri(R.color.default_image_background)
            .showImageOnFail(R.color.default_image_background)
            .cacheInMemory(true)
            .cacheOnDisk(isCacheOnDisk)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .imageScaleType(ImageScaleType.EXACTLY)
            .considerExifParams(true)
            .build();
    }

    public ImageLoaderConfiguration getImageLoaderConfiguration() {
        return getImageLoaderConfiguration(null, null);
    }

    public ImageLoaderConfiguration getImageLoaderConfiguration(String filePath) {
        return getImageLoaderConfiguration(filePath, null);
    }

    public ImageLoaderConfiguration getImageLoaderConfiguration(DisplayImageOptions displayImageOptions) {
        return getImageLoaderConfiguration(null, displayImageOptions);
    }


    /**
     *   1.只使用的是强引用缓存
         LruMemoryCache（这个类就是这个开源框架默认的内存缓存类，缓存的是bitmap的强引用，下面我会从源码上面分析这个类）
         2.使用强引用和弱引用相结合的缓存有
         UsingFreqLimitedMemoryCache（如果缓存的图片总量超过限定值，先删除使用频率最小的bitmap）
         LRULimitedMemoryCache（这个也是使用的lru算法，和LruMemoryCache不同的是，他缓存的是bitmap的弱引用）
         FIFOLimitedMemoryCache（先进先出的缓存策略，当超过设定值，先删除最先加入缓存的bitmap）
         LargestLimitedMemoryCache(当超过缓存限定值，先删除最大的bitmap对象)
         LimitedAgeMemoryCache（当 bitmap加入缓存中的时间超过我们设定的值，将其删除）
         3.只使用弱引用缓存
         WeakMemoryCache（这个类缓存bitmap的总大小没有限制，唯一不足的地方就是不稳定，缓存的图片容易被回收掉）
     *
     *
     *   FileCountLimitedDiscCache（可以设定缓存图片的个数，当超过设定值，删除掉最先加入到硬盘的文件）
         LimitedAgeDiscCache（设定文件存活的最长时间，当超过这个值，就删除该文件）
         TotalSizeLimitedDiscCache（设定缓存bitmap的最大值，当超过这个值，删除最先加入到硬盘的文件）
         UnlimitedDiscCache（这个缓存类没有任何的限制）
     * @param filePath
     * @param displayImageOptions
     * @return
     */
    public ImageLoaderConfiguration getImageLoaderConfiguration(String filePath, DisplayImageOptions displayImageOptions) {

        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(mContext);

        // Memory
        builder.memoryCache(new LruMemoryCache(2 * 1024 * 1024));//你可以通过自己的内存缓存实现
        builder.memoryCacheSize(2 * 1024 * 1024);//内存缓存大小
        builder.memoryCacheSizePercentage(15);//内存缓存百分比大小
        builder.denyCacheImageMultipleSizesInMemory(); //拒绝缓存多个图片。
        builder.memoryCacheExtraOptions(720, 1280);//保存的每个缓存文件的最大长宽

        // Disk
        File cacheDir;
        if (AbStringUtils.isEmpty(filePath)) {
            cacheDir = StorageUtils.getOwnCacheDirectory(mContext, AbDirUtils.getCacheDir());//自定义默认缓存目录
        } else {
            cacheDir = StorageUtils.getOwnCacheDirectory(mContext, filePath);//自定义缓存目录
//            cacheDir = StorageUtils.getCacheDirectory(mContext);//默认缓存目录，查看源码了解储存在哪
        }

        /**************************************************************/
//        LruDiskCache mLruDiskCache = null;
//        try {
//            mLruDiskCache = new LruDiskCache(cacheDir, new Md5FileNameGenerator(), 2* 1024 * 1024);
//        } catch (Exception e) {
//            // TODO: handle exception
//            //Log.e("Waring", "SD卡缓存失败");
//        }
//        finally{
//            //Log.d("Waring", "SD卡缓存初建立");
//        }
//        builder.diskCache(mLruDiskCache);//自定义缓存路径
        /**************************************************************/


        builder.diskCache(new UnlimitedDiskCache(cacheDir));//自定义缓存路径
        builder.diskCacheSize(50 * 1024 * 1024);//缓存的文件大小
        builder.diskCacheFileCount(1000);//缓存的文件数量
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());//将保存的时候的URI名称用MD5加密
        builder.tasksProcessingOrder(QueueProcessingType.LIFO); //设置图片下载和显示的工作队列排序

        // Thread
        builder.threadPoolSize(ImageLoaderConfiguration.Builder.DEFAULT_THREAD_POOL_SIZE);//线程池内加载的数量
        builder.threadPriority(ImageLoaderConfiguration.Builder.DEFAULT_THREAD_PRIORITY);//线程执行的优先权

//        builder.imageDownloader(new BaseImageDownloader(mContext, 5 * 1000, 30 * 1000)); // connectTimeout (5 s), readTimeout (30 s)超时时间
//        builder.writeDebugLogs(); //打开调试日志

        // DisplayImageOptions
        if (displayImageOptions == null) {
            builder.defaultDisplayImageOptions(getDisplayOptions());
        } else {
            builder.defaultDisplayImageOptions(displayImageOptions);
        }

        return builder.build();
    }
}

