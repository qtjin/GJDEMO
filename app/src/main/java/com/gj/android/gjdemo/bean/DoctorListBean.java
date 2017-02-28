package com.gj.android.gjdemo.bean;

import com.gj.gjlibrary.base.BaseBean;

import java.util.List;

/**
 * Created by guojing on 2017/2/27.
 * 医生列表
 *
 *  http://test-api.998jk.com/jkda/mobile/wys/getDoctorListV29.json
     seqType	1
     curPage	1
     drType	1
     SearchStr
     sectionsName
 */

public class DoctorListBean extends BaseBean<DoctorListBean.DataBean> {


    /**
     * data : {"total":46,"isALLLoad":"0","list":[{"age":"0","docId":"172","operatorId":"413","good":"对计生手术（人工流产术）及妇科、产科各类手术，妇产科急诊及危重病人的抢救、妇科常见多发疾病。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288664664_89","hospital":"武汉九州通医院","jobTitle":"主治医师","name":"谭双双","sections":"妇科","sex":"2","brief":"谭双双，主治医师。2004年毕业于华中科技大学同济医学院。从事妇产科工作10余年。熟练掌握妇科常见疾病的诊疗工作。","videoType":"1","terminalNumber":"860139","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":1,"isVideoOnline":1,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":1,"videoDisplay":1,"videoOnline":1},{"age":"0","docId":"175","operatorId":"425","good":"高血压，冠心病，心肌病，心力衰竭，心瓣膜疾病和各种心律失常，以及各种脑血管疾病。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288683233_33","hospital":"武汉九州通医院","jobTitle":"主治医师","name":"杨时雨","sections":"心血管内科","sex":"1","brief":"2003毕业于武汉大学，先后在广州军区武汉总医院急诊科和亚洲心脏病医院心内科工作，熟练掌握高血压，冠心病，心肌病，心力衰竭，心瓣膜疾病和各种心律失常，以及各种出血性脑病，缺血性脑病，脑动脉硬化以及颅脑占位疾病诊断与治疗。对于内科急重症也有丰富的诊疗经验。","videoType":"1","terminalNumber":"370152","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"190","operatorId":"443","good":"熟悉内科常见病，多发病的诊断及治疗。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288701044_6","hospital":"武汉九州通医院","jobTitle":"住院医师","name":"郑欢欢","sections":"普通内科","sex":"1","brief":"郑欢欢，住院医师，从事临床内科工作6年。","videoType":"1","terminalNumber":"480230","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"2","operatorId":"250","good":"慢性代谢疾病的营养治疗、尤其擅长糖尿病降饮食降糖综合营养治疗、并擅长高血压、等慢性病的药膳调理。","headImgUrl":"/g3/M00/00/AB/CgMgOFdrltSAeRh1AAAgKpZlCdc472.jpg","hospital":"武汉九州通医院","jobTitle":"高级营养师","name":"叶九思","sections":"营养科","sex":"1","brief":"中国营养学会会员、湖北省健康管理学会会员、国家、中国医师协会临床营养治疗管理师、二级营养师、二级健康管理师、2006年7月至2007年12月在武汉协和医院临床营养科进修，并就职于纽宾凯健康管理中心、合众养老健康社区高档养老院。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":0,"can_im":1,"praise":5,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":0,"videoOnline":0},{"age":"0","docId":"192","operatorId":"449","good":"擅长慢性疾病及甲状腺的治疗，如：高血压、心脏病、糖尿病、甲状腺囊肿、甲状腺结节等","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288611823_3","hospital":"武汉九州通医院","jobTitle":"副主任医师","name":"李辉","sections":"普通内科","sex":"2","brief":"毕业于同济医科大学，从事临床内科专业20余年，慢病调理5年，临床经验丰富。","videoType":"1","terminalNumber":"915302","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"505","operatorId":"918","good":"善于解决泌尿外科各种疑难杂症，如肾肿瘤、输尿管肿瘤、膀胱肿瘤、睾丸肿瘤等泌尿生殖系肿瘤的治疗方案评估及手术实施","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com//2016/12/19/1482135492301_73","hospital":"武汉九州通医院","jobTitle":"主任医师","name":"阮博为","sections":"男科","sex":"0","brief":"从事泌尿外科临床及科研工作近40年，有着丰富的临床经验，复杂性肾、输尿管、膀胱结石的等泌尿系结石的系统诊治，泌尿生殖系结核的诊治，肾积水的病因分析及治疗，肾、输尿管先天畸形疑难病例的诊治，肾上腺疾病的诊治，尿道狭窄及整形手术，肾脏移植手术等，是国内较早开展输尿管镜、前列腺电切、腹腔镜等泌尿外科腔镜手术的专家之一。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":1,"can_im":1,"praise":4.7,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"569","operatorId":"1000","good":"骨关节炎(osteoarthritis OA) 是一种常见的、发病率随年龄增加的以关节软骨退变、破坏及伴有相邻软骨下骨板、关节边缘骨质增生、骨赘形成为特点，主要影响膝关节、髋关节、远端指间关节及脊柱关节，使其功能受损的慢性、进行性关节疾病。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com//2017/2/23/1487813625116_0.jpg","hospital":"九州通","jobTitle":"主任医师","name":"安小焱","sections":"康复科","sex":"0","brief":"骨关节炎(osteoarthritis OA) 是一种常见的、发病率随年龄增加的以关节软骨退变、破坏及伴有相邻软骨下骨板、关节边缘骨质增生、骨赘形成为特点，主要影响膝关节、髋关节、远端指间关节及脊柱关节，使其功能受损的慢性、进行性关节疾病。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":1,"can_im":1,"praise":4.5,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"438","operatorId":"820","good":"太多","headImgUrl":"http://jkda.998jk.com/g3/M00/00/CC/CgMgOFft_jeAJly_AAAuJMIP8tQ847.jpg","hospital":"中心医院","jobTitle":"副主任医师","name":"李莉","sections":"呼吸科","sex":"0","brief":"擅长","videoType":"1","terminalNumber":null,"telephone":null,"can_video":1,"can_im":1,"praise":5,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"158","operatorId":"406","good":"健康管理,用药咨询,检验结果咨询,亚健康问题咨询,社区慢性病咨询。","headImgUrl":"/g3/M00/00/65/CgMgN1dyMy-AAJLLAAAlCCfJPRE374.jpg","hospital":"广州黄陂医院","jobTitle":"主治医师","name":"陶永顺","sections":"泌尿外科","sex":"1","brief":"大学毕业后十余年的一线工作经验，国家二级健康管理师，执业药师，主管检验师。对妇科炎症，早孕，流产，孕后保健，两性生活保健有独到的见解。对男科前列腺炎，阳萎和早泄等有较为深入的研究。能正确指导合理、安全、有效的用药，对于药物的药理，药性，药效，药动学，药物相互作用及药物不良反应有较熟练的掌握。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":0,"can_im":0,"praise":5,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":0,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":0,"videoOnline":0},{"age":"0","docId":"154","operatorId":"397","good":"擅长中西医结合治疗慢性支气管炎、哮喘、肺气肿、肺心病、肺部感染性疾病、肺部恶性肿瘤等慢性咳喘疾病","headImgUrl":"/g3/M00/00/65/CgMgN1dyMaCAfvUYAAAoBaPZHg0639.jpg","hospital":"荆州市中医医院","jobTitle":"主治医师","name":"胡寒飞","sections":"呼吸科","sex":"2","brief":"男，主治医师，2005年毕业于湖北中医药大学，获得学士学位。先后在荆州市中医医院急诊科，心内科，呼吸内科，神经内科工作。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":0,"can_im":0,"praise":4.9,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":0,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":0,"videoOnline":0}]}
     * msg : 查询成功
     * success : 1
     */

    public static class DataBean {
        /**
         * total : 46
         * isALLLoad : 0
         * list : [{"age":"0","docId":"172","operatorId":"413","good":"对计生手术（人工流产术）及妇科、产科各类手术，妇产科急诊及危重病人的抢救、妇科常见多发疾病。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288664664_89","hospital":"武汉九州通医院","jobTitle":"主治医师","name":"谭双双","sections":"妇科","sex":"2","brief":"谭双双，主治医师。2004年毕业于华中科技大学同济医学院。从事妇产科工作10余年。熟练掌握妇科常见疾病的诊疗工作。","videoType":"1","terminalNumber":"860139","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":1,"isVideoOnline":1,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":1,"videoDisplay":1,"videoOnline":1},{"age":"0","docId":"175","operatorId":"425","good":"高血压，冠心病，心肌病，心力衰竭，心瓣膜疾病和各种心律失常，以及各种脑血管疾病。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288683233_33","hospital":"武汉九州通医院","jobTitle":"主治医师","name":"杨时雨","sections":"心血管内科","sex":"1","brief":"2003毕业于武汉大学，先后在广州军区武汉总医院急诊科和亚洲心脏病医院心内科工作，熟练掌握高血压，冠心病，心肌病，心力衰竭，心瓣膜疾病和各种心律失常，以及各种出血性脑病，缺血性脑病，脑动脉硬化以及颅脑占位疾病诊断与治疗。对于内科急重症也有丰富的诊疗经验。","videoType":"1","terminalNumber":"370152","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"190","operatorId":"443","good":"熟悉内科常见病，多发病的诊断及治疗。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288701044_6","hospital":"武汉九州通医院","jobTitle":"住院医师","name":"郑欢欢","sections":"普通内科","sex":"1","brief":"郑欢欢，住院医师，从事临床内科工作6年。","videoType":"1","terminalNumber":"480230","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"2","operatorId":"250","good":"慢性代谢疾病的营养治疗、尤其擅长糖尿病降饮食降糖综合营养治疗、并擅长高血压、等慢性病的药膳调理。","headImgUrl":"/g3/M00/00/AB/CgMgOFdrltSAeRh1AAAgKpZlCdc472.jpg","hospital":"武汉九州通医院","jobTitle":"高级营养师","name":"叶九思","sections":"营养科","sex":"1","brief":"中国营养学会会员、湖北省健康管理学会会员、国家、中国医师协会临床营养治疗管理师、二级营养师、二级健康管理师、2006年7月至2007年12月在武汉协和医院临床营养科进修，并就职于纽宾凯健康管理中心、合众养老健康社区高档养老院。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":0,"can_im":1,"praise":5,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":0,"videoOnline":0},{"age":"0","docId":"192","operatorId":"449","good":"擅长慢性疾病及甲状腺的治疗，如：高血压、心脏病、糖尿病、甲状腺囊肿、甲状腺结节等","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288611823_3","hospital":"武汉九州通医院","jobTitle":"副主任医师","name":"李辉","sections":"普通内科","sex":"2","brief":"毕业于同济医科大学，从事临床内科专业20余年，慢病调理5年，临床经验丰富。","videoType":"1","terminalNumber":"915302","telephone":null,"can_video":1,"can_im":1,"praise":4.9,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"505","operatorId":"918","good":"善于解决泌尿外科各种疑难杂症，如肾肿瘤、输尿管肿瘤、膀胱肿瘤、睾丸肿瘤等泌尿生殖系肿瘤的治疗方案评估及手术实施","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com//2016/12/19/1482135492301_73","hospital":"武汉九州通医院","jobTitle":"主任医师","name":"阮博为","sections":"男科","sex":"0","brief":"从事泌尿外科临床及科研工作近40年，有着丰富的临床经验，复杂性肾、输尿管、膀胱结石的等泌尿系结石的系统诊治，泌尿生殖系结核的诊治，肾积水的病因分析及治疗，肾、输尿管先天畸形疑难病例的诊治，肾上腺疾病的诊治，尿道狭窄及整形手术，肾脏移植手术等，是国内较早开展输尿管镜、前列腺电切、腹腔镜等泌尿外科腔镜手术的专家之一。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":1,"can_im":1,"praise":4.7,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"569","operatorId":"1000","good":"骨关节炎(osteoarthritis OA) 是一种常见的、发病率随年龄增加的以关节软骨退变、破坏及伴有相邻软骨下骨板、关节边缘骨质增生、骨赘形成为特点，主要影响膝关节、髋关节、远端指间关节及脊柱关节，使其功能受损的慢性、进行性关节疾病。","headImgUrl":"http://jkda.oss-cn-beijing.aliyuncs.com//2017/2/23/1487813625116_0.jpg","hospital":"九州通","jobTitle":"主任医师","name":"安小焱","sections":"康复科","sex":"0","brief":"骨关节炎(osteoarthritis OA) 是一种常见的、发病率随年龄增加的以关节软骨退变、破坏及伴有相邻软骨下骨板、关节边缘骨质增生、骨赘形成为特点，主要影响膝关节、髋关节、远端指间关节及脊柱关节，使其功能受损的慢性、进行性关节疾病。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":1,"can_im":1,"praise":4.5,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"438","operatorId":"820","good":"太多","headImgUrl":"http://jkda.998jk.com/g3/M00/00/CC/CgMgOFft_jeAJly_AAAuJMIP8tQ847.jpg","hospital":"中心医院","jobTitle":"副主任医师","name":"李莉","sections":"呼吸科","sex":"0","brief":"擅长","videoType":"1","terminalNumber":null,"telephone":null,"can_video":1,"can_im":1,"praise":5,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":1,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":1,"videoOnline":0},{"age":"0","docId":"158","operatorId":"406","good":"健康管理,用药咨询,检验结果咨询,亚健康问题咨询,社区慢性病咨询。","headImgUrl":"/g3/M00/00/65/CgMgN1dyMy-AAJLLAAAlCCfJPRE374.jpg","hospital":"广州黄陂医院","jobTitle":"主治医师","name":"陶永顺","sections":"泌尿外科","sex":"1","brief":"大学毕业后十余年的一线工作经验，国家二级健康管理师，执业药师，主管检验师。对妇科炎症，早孕，流产，孕后保健，两性生活保健有独到的见解。对男科前列腺炎，阳萎和早泄等有较为深入的研究。能正确指导合理、安全、有效的用药，对于药物的药理，药性，药效，药动学，药物相互作用及药物不良反应有较熟练的掌握。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":0,"can_im":0,"praise":5,"isBopsOnline":1,"isAppOnline":1,"isOnline":2,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":0,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":0,"videoOnline":0},{"age":"0","docId":"154","operatorId":"397","good":"擅长中西医结合治疗慢性支气管炎、哮喘、肺气肿、肺心病、肺部感染性疾病、肺部恶性肿瘤等慢性咳喘疾病","headImgUrl":"/g3/M00/00/65/CgMgN1dyMaCAfvUYAAAoBaPZHg0639.jpg","hospital":"荆州市中医医院","jobTitle":"主治医师","name":"胡寒飞","sections":"呼吸科","sex":"2","brief":"男，主治医师，2005年毕业于湖北中医药大学，获得学士学位。先后在荆州市中医医院急诊科，心内科，呼吸内科，神经内科工作。","videoType":"1","terminalNumber":null,"telephone":null,"can_video":0,"can_im":0,"praise":4.9,"isBopsOnline":0,"isAppOnline":1,"isOnline":1,"isOnlineDoctorVideo":0,"isVideoOnline":0,"isTextOnline":0,"docType":1,"passtype":9,"signFee":null,"discount":null,"signedNum":null,"serviceTerms":null,"noPay":0,"onlineDoctorVideo":0,"videoDisplay":0,"videoOnline":0}]
         */

        private int total;
        private String isALLLoad;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getIsALLLoad() {
            return isALLLoad;
        }

        public void setIsALLLoad(String isALLLoad) {
            this.isALLLoad = isALLLoad;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * age : 0
             * docId : 172
             * operatorId : 413
             * good : 对计生手术（人工流产术）及妇科、产科各类手术，妇产科急诊及危重病人的抢救、妇科常见多发疾病。
             * headImgUrl : http://jkda.oss-cn-beijing.aliyuncs.com/2016/12/21/1482288664664_89
             * hospital : 武汉九州通医院
             * jobTitle : 主治医师
             * name : 谭双双
             * sections : 妇科
             * sex : 2
             * brief : 谭双双，主治医师。2004年毕业于华中科技大学同济医学院。从事妇产科工作10余年。熟练掌握妇科常见疾病的诊疗工作。
             * videoType : 1
             * terminalNumber : 860139
             * telephone : null
             * can_video : 1
             * can_im : 1
             * praise : 4.9
             * isBopsOnline : 1
             * isAppOnline : 1
             * isOnline : 2
             * isOnlineDoctorVideo : 1
             * isVideoOnline : 1
             * isTextOnline : 1
             * docType : 1
             * passtype : 9
             * signFee : null
             * discount : null
             * signedNum : null
             * serviceTerms : null
             * noPay : 0
             * onlineDoctorVideo : 1
             * videoDisplay : 1
             * videoOnline : 1
             */

            private String age;
            private String docId;
            private String operatorId;
            private String good;
            private String headImgUrl;
            private String hospital;
            private String jobTitle;
            private String name;
            private String sections;
            private String sex;
            private String brief;
            private String videoType;
            private String terminalNumber;
            private Object telephone;
            private int can_video;
            private int can_im;
            private double praise;
            private int isBopsOnline;
            private int isAppOnline;
            private int isOnline;
            private int isOnlineDoctorVideo;
            private int isVideoOnline;
            private int isTextOnline;
            private int docType;
            private int passtype;
            private Object signFee;
            private Object discount;
            private Object signedNum;
            private Object serviceTerms;
            private int noPay;
            private int onlineDoctorVideo;
            private int videoDisplay;
            private int videoOnline;

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getDocId() {
                return docId;
            }

            public void setDocId(String docId) {
                this.docId = docId;
            }

            public String getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(String operatorId) {
                this.operatorId = operatorId;
            }

            public String getGood() {
                return good;
            }

            public void setGood(String good) {
                this.good = good;
            }

            public String getHeadImgUrl() {
                return headImgUrl;
            }

            public void setHeadImgUrl(String headImgUrl) {
                this.headImgUrl = headImgUrl;
            }

            public String getHospital() {
                return hospital;
            }

            public void setHospital(String hospital) {
                this.hospital = hospital;
            }

            public String getJobTitle() {
                return jobTitle;
            }

            public void setJobTitle(String jobTitle) {
                this.jobTitle = jobTitle;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSections() {
                return sections;
            }

            public void setSections(String sections) {
                this.sections = sections;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getVideoType() {
                return videoType;
            }

            public void setVideoType(String videoType) {
                this.videoType = videoType;
            }

            public String getTerminalNumber() {
                return terminalNumber;
            }

            public void setTerminalNumber(String terminalNumber) {
                this.terminalNumber = terminalNumber;
            }

            public Object getTelephone() {
                return telephone;
            }

            public void setTelephone(Object telephone) {
                this.telephone = telephone;
            }

            public int getCan_video() {
                return can_video;
            }

            public void setCan_video(int can_video) {
                this.can_video = can_video;
            }

            public int getCan_im() {
                return can_im;
            }

            public void setCan_im(int can_im) {
                this.can_im = can_im;
            }

            public double getPraise() {
                return praise;
            }

            public void setPraise(double praise) {
                this.praise = praise;
            }

            public int getIsBopsOnline() {
                return isBopsOnline;
            }

            public void setIsBopsOnline(int isBopsOnline) {
                this.isBopsOnline = isBopsOnline;
            }

            public int getIsAppOnline() {
                return isAppOnline;
            }

            public void setIsAppOnline(int isAppOnline) {
                this.isAppOnline = isAppOnline;
            }

            public int getIsOnline() {
                return isOnline;
            }

            public void setIsOnline(int isOnline) {
                this.isOnline = isOnline;
            }

            public int getIsOnlineDoctorVideo() {
                return isOnlineDoctorVideo;
            }

            public void setIsOnlineDoctorVideo(int isOnlineDoctorVideo) {
                this.isOnlineDoctorVideo = isOnlineDoctorVideo;
            }

            public int getIsVideoOnline() {
                return isVideoOnline;
            }

            public void setIsVideoOnline(int isVideoOnline) {
                this.isVideoOnline = isVideoOnline;
            }

            public int getIsTextOnline() {
                return isTextOnline;
            }

            public void setIsTextOnline(int isTextOnline) {
                this.isTextOnline = isTextOnline;
            }

            public int getDocType() {
                return docType;
            }

            public void setDocType(int docType) {
                this.docType = docType;
            }

            public int getPasstype() {
                return passtype;
            }

            public void setPasstype(int passtype) {
                this.passtype = passtype;
            }

            public Object getSignFee() {
                return signFee;
            }

            public void setSignFee(Object signFee) {
                this.signFee = signFee;
            }

            public Object getDiscount() {
                return discount;
            }

            public void setDiscount(Object discount) {
                this.discount = discount;
            }

            public Object getSignedNum() {
                return signedNum;
            }

            public void setSignedNum(Object signedNum) {
                this.signedNum = signedNum;
            }

            public Object getServiceTerms() {
                return serviceTerms;
            }

            public void setServiceTerms(Object serviceTerms) {
                this.serviceTerms = serviceTerms;
            }

            public int getNoPay() {
                return noPay;
            }

            public void setNoPay(int noPay) {
                this.noPay = noPay;
            }

            public int getOnlineDoctorVideo() {
                return onlineDoctorVideo;
            }

            public void setOnlineDoctorVideo(int onlineDoctorVideo) {
                this.onlineDoctorVideo = onlineDoctorVideo;
            }

            public int getVideoDisplay() {
                return videoDisplay;
            }

            public void setVideoDisplay(int videoDisplay) {
                this.videoDisplay = videoDisplay;
            }

            public int getVideoOnline() {
                return videoOnline;
            }

            public void setVideoOnline(int videoOnline) {
                this.videoOnline = videoOnline;
            }
        }
    }
}
