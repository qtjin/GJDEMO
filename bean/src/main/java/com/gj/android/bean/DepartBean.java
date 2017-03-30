package com.gj.android.bean;

import java.util.List;

/**
 * Created by guojing on 2017/3/30 0030.
 */

public class DepartBean {


    /**
     * data : [{"departId":1,"departName":"妇科","relationId":57,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/fk.png"},{"departId":2,"departName":"儿科","relationId":5,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/erke.png"},{"departId":3,"departName":"内科","relationId":1,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/neike.png"},{"departId":4,"departName":"皮肤性病科","relationId":11,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/pifuxingbingke.png"},{"departId":6,"departName":"营养科","relationId":26,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/yingyangke.png"},{"departId":7,"departName":"骨伤科","relationId":6,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/guke.png"},{"departId":8,"departName":"男科","relationId":12,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/nanke.png"},{"departId":9,"departName":"外科","relationId":2,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/waike.png"},{"departId":11,"departName":"肿瘤及防治科","relationId":10,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/zhongliu.png"},{"departId":12,"departName":"中医科","relationId":16,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/zhongyixue.png"},{"departId":13,"departName":"口腔颌面科","relationId":8,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/kouqiangke.png"},{"departId":14,"departName":"耳鼻咽喉科","relationId":9,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/erbihoutou.png"},{"departId":15,"departName":"眼科","relationId":7,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/yanke.png"},{"departId":16,"departName":"整形美容科","relationId":13,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/pifumeirong.png"},{"departId":17,"departName":"精神心理科","relationId":15,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/jinshenxinli.png"},{"departId":21,"departName":"产科","relationId":3,"imgUrl":"https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/yunchankexue.png"}]
     * success : 1
     * msg : 获取春雨科室成功
     */

    public int success;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * departId : 1
         * departName : 妇科
         * relationId : 57
         * imgUrl : https://jkda.oss-cn-beijing.aliyuncs.com/static/html/ksimg/fk.png
         */

        public int departId;
        public String departName;
        public int relationId;
        public String imgUrl;
    }
}
