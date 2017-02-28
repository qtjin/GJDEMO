package com.gj.android.gjlibrary.api;


import com.gj.android.bean.BaseBean;
import com.gj.android.bean.DoctorListBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by guojing on 2016/11/25.
 * 业务接口
 */

public interface Api {


    /**
    * 我的动态列表
    */
   @FormUrlEncoded
   @POST("mobile/wys/getDoctorListV29.json")
   Observable<BaseBean<DoctorListBean.DataBean>> getDoctorList(@Field("seqType") String seqType, @Field("drType") String drType
           , @Field("SearchStr") String SearchStr, @Field("sectionsName") String sectionsName, @Field("curPage") String curPage);

//    /***********************************  朋友圈  ***********************************/
//    /**
//     * 朋友圈大厅（好友动态列表）
//     */
//   @GET("app/app/weiquan/steacher")
//   Observable<BaseBean<FriendNewsEntitiy.DataEntity>> getHallList(@Query("userId") String userId, @Query("page") String page, @Query("rows") String rows, @Query("sign") String sign);
//
//    /**
//     * 点赞
//     */
//    @FormUrlEncoded
//    @POST("app/app/support/add")
//    Observable<BaseBean> addZan(@Field("userId") String userId, @Field("wqId") String wqId, @Field("sign") String sign);
//
//    /**
//     * 取消赞
//     */
//    @FormUrlEncoded
//    @POST("app/app/support/cancle")
//    Observable<BaseBean> cancleZan(@Field("userId") String userId, @Field("wqId") String wqId, @Field("sign") String sign);
//
//    /**
//     * 添加评论
//     */
//    @FormUrlEncoded
//    @POST("app/app/comment/add")
//    Observable<BaseBean> addCommment(@Field("userId") String userId, @Field("wqId") String wqId,
//                                       @Field("content") String content, @Field("commentId") String commentId, @Field("sign") String sign);
//   /**
//    * 我的动态列表
//    */
//   @FormUrlEncoded
//   @POST("app/app/weiquan/my")
//   Observable<BaseBean<MyNewsEntitiy.DataEntity>> getMyNewsList(@Field("userId") String userId, @Field("page") String page, @Field("rows") String rows, @Field("sign") String sign);
//
//   /**
//    * 我的动态详情
//    */
//   @FormUrlEncoded
//   @POST("app/app/weiquan/detail")
//   Observable<BaseBean<MyNewsDetailEntitiy.DataEntity>> getMyNewsDetail(@Field("userId") String userId, @Field("wqId") String wqId, @Field("sign") String sign);
//
//   /**
//    * 我的动态消息列表
//    */
//   @FormUrlEncoded
//   @POST("app/app/sxqmessage/index")
//   Observable<BaseBean<MyNewsMsgEntitiy.DataEntity>> getMyNewsMessageList(@Field("userId") String userId, @Field("page") String page, @Field("rows") String rows, @Field("sign") String sign);
//
//   /**
//    * 发朋友圈
//    */
//   @FormUrlEncoded
//   @POST("app/app/weiquan/add")
//   Observable<BaseBean> addNews(@Field("userId") String userId, @Field("content") String content, @Field("fileId") String fileId, @Field("sign") String sign);
//
//    /***********************************  朋友圈  ***********************************/
//
//    /**
//     * 上传图片
//     */
//    @Multipart
//    @POST("app/app/upload/image")
//    Observable<BaseBean<UpLoadImageEntity.DataEntity>> uploadImage(@Part("userId") RequestBody requestUserId, @Part MultipartBody.Part file, @Part("sign") RequestBody requestSign);


}
