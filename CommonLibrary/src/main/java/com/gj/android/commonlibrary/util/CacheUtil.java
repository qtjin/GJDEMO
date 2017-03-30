package com.gj.android.commonlibrary.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by guojing on 15/11/16.
 */
public class CacheUtil {


    /**
     * 保存缓存数据
     */
    public static void saveCacheData(String cacheKey, String cacheStr) {
        PreferencesUtils.putString(AbAppUtils.getContext(), cacheKey, cacheStr);
    }
    /**
     * 获取缓存数据
     */
    public static String getCacheData(String cacheKey) {
       return PreferencesUtils.getString(AbAppUtils.getContext(), cacheKey, "");
    }


    /**
     * 查询某个key是否已经存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PreferencesUtils.PREFERENCE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }


    /**
     * 保存首次启动标记
     */
    public static void Launched() {
        PreferencesUtils.putBoolean(AbAppUtils.getContext(), "isLaunched", true);
    }

    /**
     * 获取首次启动标记
     */
    public static boolean getLaunched() {
        return PreferencesUtils.getBoolean(AbAppUtils.getContext(), "isLaunched", false);
    }


    /**
     * 保存首次启动标记
     */
    public static void LaunchedCourseDetail() {
        PreferencesUtils.putBoolean(AbAppUtils.getContext(), "isLaunchedCourseDetail", true);
    }

    /**
     * 获取首次启动标记
     */
    public static boolean getLaunchedCourseDetail() {
        return PreferencesUtils.getBoolean(AbAppUtils.getContext(), "isLaunchedCourseDetail", false);
    }

//    /**
//     *  判断是否免登陆
//     * @return
//     */
//    public static boolean isLogin() {
//        if(!TextUtils.isEmpty(getUserId(AbAppUtils.getContext()))) {
//            return true;  //已经登录
//        }else{
//            return false;  //没有登录
//        }
//    }



    public static void cleanLogin() {
        PreferencesUtils.putString(AbAppUtils.getContext(), "userId", "");
    }

    /**
     * 老师的用户ID
     * @param context
     * @return
     */
    public static void saveUserId(Context context , String UserId){
        PreferencesUtils.putString(context, "userId", UserId);
    }


    /**
     * 获取环信账号
     */
    public static String getHuanxinAccount(Context context) {
        return PreferencesUtils.getString(context, "huanxin_account", "");
    }

    /**
     * 保存环信账号
     */
    public static void saveHuanxinAccount(Context context, String huanxin_account) {
        PreferencesUtils.putString(context, "huanxin_account", huanxin_account);
    }
    /**
     * 获取环信密码
     */
    public static String getHuanxinPassword(Context context) {
        return PreferencesUtils.getString(context, "huanxin_password", "");
    }

    /**
     * 保存环信密码
     */
    public static void saveHuanxinPassword(Context context, String huanxin_password) {
        PreferencesUtils.putString(context, "huanxin_password", huanxin_password);
    }

//    /**
//     *  取出searchHistoryEntity信息
//     */
//    public static SearchHistoryEntity getSearchHistoryEntity(Context context) {
//        String json = PreferencesUtils.getString(context, "search_history_Entity", "");
//        if(TextUtils.isEmpty(json)) {
//            return null;
//        } else {
//            return AbGsonUtil.json2Bean(json, SearchHistoryEntity.class);
//        }
//    }
//
//    /**
//     * 缓存searchHistoryEntity信息
//     */
//    public static void saveSearchHistoryEntity(Context context, SearchHistoryEntity searchHistoryEntity) {
//        String json = AbGsonUtil.bean2Json(searchHistoryEntity);
//        PreferencesUtils.putString(context, "search_history_Entity", json);
//    }

//    /**
//     * 清除searchHistoryEntity信息
//     */
//    public static void clearSearchHistoryEntity(Context context) {
//        PreferencesUtils.putString(context, "search_history_Entity", "");
//    }

}
