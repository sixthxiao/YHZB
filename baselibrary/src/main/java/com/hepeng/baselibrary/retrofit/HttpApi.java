package com.hepeng.baselibrary.retrofit;

import com.hepeng.baselibrary.bean.AccountBean;
import com.hepeng.baselibrary.bean.ArticleDetailBean;
import com.hepeng.baselibrary.bean.AskHistoryBean;
import com.hepeng.baselibrary.bean.AuthenticationBean;
import com.hepeng.baselibrary.bean.CalendarBan;
import com.hepeng.baselibrary.bean.CategoryBean;
import com.hepeng.baselibrary.bean.CategoryDiseaseBean;
import com.hepeng.baselibrary.bean.ChatBean;
import com.hepeng.baselibrary.bean.ChatInfoBean;
import com.hepeng.baselibrary.bean.ChatListBean;
import com.hepeng.baselibrary.bean.CommonManageBean;
import com.hepeng.baselibrary.bean.ContactsBean;
import com.hepeng.baselibrary.bean.CosTempBean;
import com.hepeng.baselibrary.bean.DiagnoseBean;
import com.hepeng.baselibrary.bean.DoctorFlagBean;
import com.hepeng.baselibrary.bean.DoctorInfoBean;
import com.hepeng.baselibrary.bean.DoctorStrongBean;
import com.hepeng.baselibrary.bean.EvaluateBean;
import com.hepeng.baselibrary.bean.EvaluateTitleBean;
import com.hepeng.baselibrary.bean.FamilyPatientBean;
import com.hepeng.baselibrary.bean.FansListBean;
import com.hepeng.baselibrary.bean.FileUrlBean;
import com.hepeng.baselibrary.bean.FollowBean;
import com.hepeng.baselibrary.bean.GeneralBean;
import com.hepeng.baselibrary.bean.HospitalListBean;
import com.hepeng.baselibrary.bean.InquiryListBean;
import com.hepeng.baselibrary.bean.InquiryPageBean;
import com.hepeng.baselibrary.bean.InquiryPageBean1;
import com.hepeng.baselibrary.bean.InquirySendBean;
import com.hepeng.baselibrary.bean.InquirySetInfoBean;
import com.hepeng.baselibrary.bean.ListBean;
import com.hepeng.baselibrary.bean.LoginBean;
import com.hepeng.baselibrary.bean.MedicineBean;
import com.hepeng.baselibrary.bean.MemberFlowTotalBean;
import com.hepeng.baselibrary.bean.MemberWithdrawBean;
import com.hepeng.baselibrary.bean.MixUserInfo;
import com.hepeng.baselibrary.bean.MoneyFlowWaterBean;
import com.hepeng.baselibrary.bean.MoneyInfoBean;
import com.hepeng.baselibrary.bean.NoticeBean;
import com.hepeng.baselibrary.bean.PatientDetailBean;
import com.hepeng.baselibrary.bean.PatientInfoBean;
import com.hepeng.baselibrary.bean.PharmBean;
import com.hepeng.baselibrary.bean.PresDetailBean;
import com.hepeng.baselibrary.bean.PresListBean;
import com.hepeng.baselibrary.bean.PresTitleBean;
import com.hepeng.baselibrary.bean.RegDetailBean;
import com.hepeng.baselibrary.bean.RegListBean;
import com.hepeng.baselibrary.bean.RegionListBean;
import com.hepeng.baselibrary.bean.ReturnVisitBean;
import com.hepeng.baselibrary.bean.SavePresBean;
import com.hepeng.baselibrary.bean.SkilledSearchBean;
import com.hepeng.baselibrary.bean.StateInfoBean;
import com.hepeng.baselibrary.bean.TempMedicineBean;
import com.hepeng.baselibrary.bean.TemplateBean;
import com.hepeng.baselibrary.bean.UpdateBean;
import com.hepeng.baselibrary.bean.VerifyInfo;
import com.hepeng.baselibrary.bean.VisitHospListBean;
import com.hepeng.baselibrary.bean.WebArticleBean;
import com.hepeng.baselibrary.bean.WebChannelBean;
import com.hepeng.baselibrary.bean.WebKeycodeBean;
import com.hepeng.baselibrary.bean.WelcomeInfoBean;
import com.hepeng.baselibrary.bean.WxSendNumBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface HttpApi {

//        String baseUrl = "http://192.168.8.23:9090";
    String baseUrl = "http://api.dev.tcm166.cn";
//    String baseUrl = "http://api.tcm166.cn";

    @FormUrlEncoded
    @POST("api/v1/Passport/Login")
    Observable<HttpResult<MixUserInfo>> login(@Body VerifyInfo body);

    @GET("/healtycity/order/getDocList")
    Observable<HttpResult<ListBean>> getList(@Query("orderType") String did,
                                             @Query("page") String flagm,
                                             @Query("status") String status);

    //更新
    @POST("/indexdata/getAndriodIsupdate")
    Observable<HttpResult<UpdateBean>> appUpdate();

    //获取地区列表
    @POST("/region/list")
    Observable<HttpResult<List<RegionListBean>>> regionList();

    //获取医院列表
    @FormUrlEncoded
    @POST("/hospital/list")
    Observable<HttpResult<List<HospitalListBean>>> hospitalList(@Field("regionid") String regionid,
                                                                @Field("title") String title);

    //注册
    @FormUrlEncoded
    @POST("/doctorRegister/register")
    Observable<HttpResult<LoginBean>> register(@Field("hospitalid") String hospitalid,
                                               @Field("phone") String phone,
                                               @Field("phoneCode") String phoneCode,
                                               @Field("pwd") String pwd,
                                               @Field("realname") String realname);

    //获取验证码
    @FormUrlEncoded
    @POST("/sms/sendPhoneCode")
    Observable<HttpResult<Object>> sendPhoneCode(@Field("phone") String username,
                                                 @Field("sendType") String sendType);

    //账号密码登录
    @FormUrlEncoded
    @POST("/doctorLogin/loginPwd")
    Observable<HttpResult<LoginBean>> loginPwd(@Field("username") String username,
                                               @Field("password") String pwd);

    //验证码登录
    @FormUrlEncoded
    @POST("/doctorLogin/loginCode")
    Observable<HttpResult<LoginBean>> loginCode(@Field("username") String username,
                                                @Field("phoneCode") String phoneCode);

    //忘记密码
    @FormUrlEncoded
    @POST("/doctorLogin/retrievePwd")
    Observable<HttpResult<LoginBean>> forgetPwd(@Field("username") String username,
                                                @Field("phoneCode") String phoneCode,
                                                @Field("pwd") String pwd);

    //修改密码
    @FormUrlEncoded
    @POST("/doctor/updateDoctorLoginPwd")
    Observable<HttpResult<Object>> changePwd(@Field("phone") String phone,
                                             @Field("phonecode") String phoneCode,
                                             @Field("pwd") String pwd);

    //提现密码
    @FormUrlEncoded
    @POST("/doctor/updatePaypwd")
    Observable<HttpResult<Object>> withdrawalPwd(@Field("phone") String phone,
                                                 @Field("phonecode") String phonecode,
                                                 @Field("paypwd") String paypwd);

    //token登录获取医生信息
    @POST("/doctor/doctorInfo")
    Observable<HttpResult<DoctorInfoBean>> tokenLogin();

    //退出登录
    @POST("/doctorLogin/outLogin")
    Observable<HttpResult<Object>> exitLogin();

    //认证
    @POST("/doctorAccept/getAccept")
    Observable<HttpResult<AuthenticationBean>> getAuthenInfo();

    //提交认证
    @FormUrlEncoded
    @POST("/doctorAccept/saveAccept")
    Observable<HttpResult<Object>> saveAuthenInfo(@FieldMap Map<String, Object> map);

    //获取配置信息（上传图片到腾讯云）
    @POST("/indexdata/cosTemp")
    Observable<HttpResult<CosTempBean>> costemp();

    @FormUrlEncoded
    @POST("/indexdata/uploadpath")
    Observable<HttpResult<FileUrlBean>> setFileUrl(@Field("define") String define,
                                                   @Field("extname") String extname);

    //获取问诊设置信息
    @POST("/doctor/getDoctorConfigInfo")
    Observable<HttpResult<InquirySetInfoBean>> getInquirySet();

    //保存问诊设置
    @PUT("/doctorConfig/saveAccept")
    Observable<HttpResult<Object>> saveInquirySet(@Body RequestBody requestBody);

    //获取欢迎语信息
    @POST("/doctor/getWelcomeInfo")
    Observable<HttpResult<WelcomeInfoBean>> getWelcome();

    //保存欢迎语信息
    @FormUrlEncoded
    @POST("/doctor/saveWelcome")
    Observable<HttpResult<Object>> setWelcome(@Field("title") String title,
                                              @Field("welcome") String welcome,
                                              @Field("welcomeadd") String welcomeadd);

    //个人中心
    @POST("/doctor/doctorFlag")
    Observable<HttpResult<DoctorFlagBean>> doctorFlag();

    //修改个人简介
    @FormUrlEncoded
    @POST("/doctor/updateResume")
    Observable<HttpResult<Object>> savePersonalData1(@Field("intro") String resume);

    //修改个人简历
    @FormUrlEncoded
    @POST("/doctor/updateResume")
    Observable<HttpResult<Object>> savePersonalData2(@Field("resume") String resume);

    //修改研究成果
    @FormUrlEncoded
    @POST("/doctor/updateResume")
    Observable<HttpResult<Object>> savePersonalData3(@Field("scientific") String resume);

    //擅长诊治
    @POST("/doctor/getDoctorStrong")
    Observable<HttpResult<List<DoctorStrongBean>>> skilledSelectData();

    @POST("/doctor/getCategoryDiseaseList")
    Observable<HttpResult<List<CategoryDiseaseBean.ListBean>>> skilledListData();

    @FormUrlEncoded
    @POST("/doctor/saveDisease")
    Observable<HttpResult<Object>> skilledSave(@Field("ids") String ids);

    @FormUrlEncoded
    @POST("/doctor/getDiseaseList")
    Observable<HttpResult<SkilledSearchBean>> skilledSearch(@Field("page") String page,
                                                            @Field("title") String title);

    //常用语管理
    @POST("/doctor/getPhrases")
    Observable<HttpResult<List<CommonManageBean>>> getCommonManageList();

    @FormUrlEncoded
    @POST("/doctor/delPhrases")
    Observable<HttpResult<Object>> delateCommonManage(@Field("ids") String ids);

    @FormUrlEncoded
    @POST("/doctor/savePhrases")
    Observable<HttpResult<Object>> addCommonManage(@Field("phrasestype") int ids,
                                                   @Field("title") String title);

    //意见反馈
    @FormUrlEncoded
    @POST("/doctor/getOtrOpinion")
    Observable<HttpResult<ChatBean>> feedBackList(@Field("page") int page,
                                                  @Field("size") int size);

    @FormUrlEncoded
    @POST("/doctor/saveOtrOpinion")
    Observable<HttpResult<Object>> sendFeedBackList(@Field("content") String content,
                                                    @Field("typecode") String typecode);

    @POST("/doctor/updateOtrOpinionRead")
    Observable<HttpResult<Object>> readFeedBackList();

    //钱包
    @POST("/doctor/getFunds")
    Observable<HttpResult<MoneyInfoBean>> getMoney();

    @FormUrlEncoded
    @POST("/doctor/getMemberFlowTotal")
    Observable<HttpResult<MemberFlowTotalBean>> getFlowWater(@Field("time") String time,
                                                             @Field("typecode") String typecode);

    @FormUrlEncoded
    @POST("/doctor/getFlowList")
    Observable<HttpResult<MoneyFlowWaterBean>> getFlowList(@Field("time") String time,
                                                           @Field("page") int page,
                                                           @Field("typecode") String typecode);

    @FormUrlEncoded
    @POST("/doctortMemberPayaccount/getMemberWithdraw")
    Observable<HttpResult<MemberWithdrawBean>> getMemberWithdraw(@Field("page") int page,
                                                                 @Field("starttime") String starttime,
                                                                 @Field("endtime") String endtime);

    @POST("/doctortMemberPayaccount/getMemberPayaccountList")
    Observable<HttpResult<AccountBean>> getWexinAccount();

    @FormUrlEncoded
    @POST("/doctortMemberPayaccount/getDoctorOpenid")
    Observable<HttpResult<String>> getWXopenid(@Field("appid") String appid,
                                               @Field("code") String code);

    @FormUrlEncoded
    @POST("/doctortMemberPayaccount/bindMemberPayaccount")
    Observable<HttpResult<Object>> bindWXaccount(@Field("account") String account,
                                                 @Field("type") String type);

    @FormUrlEncoded
    @POST("/doctortMemberPayaccount/saveMemberWithdraw")
    Observable<HttpResult<Object>> withdraw(@Field("accountId") String accountId,
                                            @Field("outMoney") String outMoney,
                                            @Field("pwd") String pwd);

    //坐诊设置
    @POST("/doctorRegAsk/getRegAskAddressList")
    Observable<HttpResult<List<VisitHospListBean>>> getvisitSetHospList();

    @POST("/doctorRegAsk/getRegAsk")
    Observable<HttpResult<CalendarBan>> getvisitSetInfo();

    @FormUrlEncoded
    @POST("/doctorRegAsk/saveRegAskAddress")
    Observable<HttpResult<Object>> saveRegAskAddress(@Field("hospitalid") String hospitalid);

    @FormUrlEncoded
    @POST("/doctorRegAsk/deleteRegAskAddress")
    Observable<HttpResult<Object>> delateRegAskAddress(@Field("id") String id);

    @FormUrlEncoded
    @POST("/doctorRegAsk/updateRegAskAddress")
    Observable<HttpResult<Object>> updateRegAskAddress(@Field("hospitalid") String hospitalid,
                                                       @Field("id") String id);

    @FormUrlEncoded
    @POST("/doctorRegAsk/saveRegAskStop")
    Observable<HttpResult<Object>> stopRegAskAddress(@Field("askid") String askid,
                                                     @Field("nowDate") String nowDate,
                                                     @Field("resion") String resion,
                                                     @Field("type") String type);

    @FormUrlEncoded
    @POST("/doctorRegAsk/updateRegAsk")
    Observable<HttpResult<Object>> updateRegAsk(@Field("addressid") String addressid,
                                                @Field("timetype") String timetype,
                                                @Field("weekDay") String weekDay,
                                                @Field("starttime") String starttime,
                                                @Field("endtime") String endtime);

    //资讯
    @FormUrlEncoded
    @POST("/webarticle/getWebChannel")
    Observable<HttpResult<List<WebChannelBean>>> getWebChannel(@Field("keycode") String keycode);

    @FormUrlEncoded
    @POST("/webarticle/getWebArticle")
    Observable<HttpResult<WebArticleBean>> getWebArticle(@Field("title") String title,
                                                         @Field("webchannelid") String webchannelid,
                                                         @Field("page") int page);

    @FormUrlEncoded
    @POST("/webarticle/getWebArticleById")
    Observable<HttpResult<ArticleDetailBean>> ArticleDetail(@Field("id") String id);

    @FormUrlEncoded
    @POST("/webarticle/getWebArticleByKeycode")
    Observable<HttpResult<List<WebKeycodeBean>>> getWebKeycodeBean(@Field("keycode") String keycode);

    @POST("/webarticle/getHotWebArticle")
    Observable<HttpResult<List<WebArticleBean.ListBean>>> getHotWebArticle();

    /**
     * 开方
     */
    //搜索辨病
    @FormUrlEncoded
    @POST("/Disease/getSreDisease")
    Observable<HttpResult<List<DiagnoseBean>>> getDiagnoseData(@Field("categoryid") String categoryid,
                                                               @Field("title") String title,
                                                               @Field("typecode") String typecode);

    //获取药房列表
    @POST("/Disease/getSrePharmacy")
    Observable<HttpResult<List<PharmBean>>> getPharmData();

    //药材编辑（搜索药材）
    @FormUrlEncoded
    @POST("/Disease/getMedicinePharmacy")
    Observable<HttpResult<List<MedicineBean>>> getmedicineData(@Field("kindid") int kindid,
                                                               @Field("pharmacyid") int pharmacyid,
                                                               @Field("title") String title);

    //从药材总表中搜索药材
    @FormUrlEncoded
    @POST("/doctorAdvTemplate/getSreMedicineList")
    Observable<HttpResult<List<MedicineBean>>> searchmedicineList(@Field("title") String title);

    //模板添加药材
    @FormUrlEncoded
    @POST("/doctorPrescript/checkPrescriptMedicine")
    Observable<HttpResult<List<TempMedicineBean>>> getTempMedicine(@Field("kindid") String kindid,
                                                                   @Field("pharmacyid") String pharmacyid,
                                                                   @Field("templateid") String templateid);

    //开方
    @PUT("/doctorPrescript/savePrescript")
    Observable<HttpResult<SavePresBean>> prescribe(@Body RequestBody requestBody);

    //编辑药方
    @PUT("/doctorPrescript/updatePrescript")
    Observable<HttpResult<Object>> editPrescribe(@Body RequestBody requestBody);

    //面对面开方
    @PUT("/doctorPrescript/saveFacePrescript")
    Observable<HttpResult<SavePresBean>> facePrescribe(@Body RequestBody requestBody);

    //更换药材获取药材信息
    @PUT("/doctorPrescript/checkPrescriptPharmacyMedicine")
    Observable<HttpResult<List<MedicineBean>>> changePharMedicine(@Body RequestBody requestBody);

    //常量数据问题
    @FormUrlEncoded
    @POST("/diccontent/conbydicid")
    Observable<HttpResult<List<GeneralBean>>> getGeneralData(@Field("sysdicid") String sysdicid);

    //科室列表
    @FormUrlEncoded
    @POST("/doctorConfig/getDoctorCategory")
    Observable<HttpResult<List<CategoryBean>>> getCategoryList(@Field("categoryid") String categoryid,
                                                               @Field("hospitalid") String hospitalid,
                                                               @Field("title") String title);

    //聊天
    @FormUrlEncoded
    @POST("/doctorAskHistory/getAskHistory")
    Observable<HttpResult<AskHistoryBean>> getAdvidoryList(@Field("status") String status,
                                                           @Field("page") int page);

    @FormUrlEncoded
    @POST("/doctorAskHistory/getAdvAskInfo")
    Observable<HttpResult<ChatInfoBean>> getChatInfo(@Field("adviceid") String adviceid);

    @FormUrlEncoded
    @POST("/doctorAskHistory/getChatHistory")
    Observable<HttpResult<List<ChatListBean>>> getChatList(@Field("adviceid") String adviceid,
                                                           @Field("standard") int standard);

    //就诊人病历
    @FormUrlEncoded
    @POST("/doctorAdvAdvice/getAdvPatient")
    Observable<HttpResult<PatientInfoBean>> getPatientInfo(@Field("adviceid") String adviceid);

    @FormUrlEncoded
    @POST("/doctorAskHistory/saveAdvChatHistory")
    Observable<HttpResult<Object>> saveChatContent(@FieldMap Map<String, Object> map);

    //结束会话
    @FormUrlEncoded
    @POST("/doctorAskHistory/doctorEndAdv")
    Observable<HttpResult<Object>> overChat(@Field("adviceid") String adviceid);

    //发起回访
    @FormUrlEncoded
    @POST("/doctorPrescript/saveDoctorFollowUp")
    Observable<HttpResult<ReturnVisitBean>> sendReturnVisit(@Field("adviceid") String adviceid);

    //退款
    @FormUrlEncoded
    @POST("/doctorAskHistory/doctorCancelAdv")
    Observable<HttpResult<Object>> refund(@Field("adviceid") String adviceid,
                                          @Field("remark") String remark);

    //催促回复
    @FormUrlEncoded
    @POST("/doctorAskHistory/doctorPrompt")
    Observable<HttpResult<Object>> urge(@Field("adviceid") String adviceid);

    //举报用户
    @FormUrlEncoded
    @POST("/doctorAskHistory/doctorReport")
    Observable<HttpResult<Object>> report(@Field("adviceid") String adviceid,
                                          @Field("content") String content,
                                          @Field("imgs") String imgs,
                                          @Field("tomemberid") String tomemberid);

    //帮助中心
    @FormUrlEncoded
    @POST("/webarticle/getHelpSearch")
    Observable<HttpResult<List<WebChannelBean.ListBeanX.ListBean>>> searchHelpList(@Field("title") String title);

    //模板
    @FormUrlEncoded
    @POST("/doctorAdvTemplate/getDoctorAdvTemplate")
    Observable<HttpResult<TemplateBean>> getTemplateList(@Field("page") int page,
                                                         @Field("typecode") int typecode);

    //模板(历史方)
    @FormUrlEncoded
    @POST("/doctorPrescript/getprescriptwithcontent")
    Observable<HttpResult<TemplateBean>> getTemplateHistoryList(@Field("page") int page,
                                                                @Field("patientid") int patientid);

    //模板搜索
    @FormUrlEncoded
    @POST("/doctorAdvTemplate/getDoctorAdvTemplate")
    Observable<HttpResult<TemplateBean>> getTemplateList(@Field("page") int page,
                                                         @Field("title") String title);

    @FormUrlEncoded
    @POST("/doctorAdvTemplate/deleteAdvTemplate")
    Observable<HttpResult<Object>> delateTemplate(@Field("id") String id);

    @PUT("/doctorAdvTemplate/saveAdvTemplate")
    Observable<HttpResult<Object>> addTemplate(@Body RequestBody requestBody);

    @PUT("/doctorAdvTemplate/updateAdvTemplate")
    Observable<HttpResult<Object>> editTemplate(@Body RequestBody requestBody);

    //患者评价
    @FormUrlEncoded
    @POST("/comment/list/comment/count")
    Observable<HttpResult<EvaluateTitleBean>> getEvaluateTitle(@Field("doctorId") String doctorid);

    @FormUrlEncoded
    @POST("/comment/list/comment")
    Observable<HttpResult<List<EvaluateBean>>> getEvaluateList(@Field("doctorId") String doctorid,
                                                               @Field("page") int page,
                                                               @Field("typeCode") String typecode);

    //家庭医生患者服务列表
    @POST("/doctorFamily/getDoctorFamilyList")
    Observable<HttpResult<List<FamilyPatientBean>>> getFamilyPatientList();

    //待随访患者列表
    @POST("/doctorPrescript/getDoctorFollowUp")
    Observable<HttpResult<List<FollowBean>>> getFollowList();

    //问诊单
    @POST("/doctor/getStateInfo")
    Observable<HttpResult<StateInfoBean>> getStateInfo();

    @FormUrlEncoded
    @POST("/doctor/updateSendstate")
    Observable<HttpResult<Object>> updateSendstate(@Field("id") String doctorid,
                                                   @Field("issendstate") int issendstate);

    //查看问诊单详情
    @FormUrlEncoded
    @POST("/doctor/getStateDetails")
    Observable<HttpResult<List<InquiryPageBean1>>> getStateDetail(@Field("id") String id);

    //聊天页面查看问诊单
    @FormUrlEncoded
    @POST("/doctor/getAdvStateAnswer")
    Observable<HttpResult<List<InquiryPageBean>>> getAdvStateDetail(@Field("id") String id);


    //发送问诊单(获取id)
    @FormUrlEncoded
    @POST("/doctorAskHistory/snedAdvState")
    Observable<HttpResult<InquirySendBean>> sendInquiry(@Field("adviceid") String adviceid,
                                                        @Field("patientid") String patientid,
                                                        @Field("statetype") String statetype);

    //医生二维码
    @POST("/doctor/ticket")
    Observable<HttpResult<Object>> getDoctorQRCode();

    //首页列表页
    //药方列表
    @FormUrlEncoded
    @POST("/doctorPrescript/getPrescript")
    Observable<HttpResult<PresListBean>> getPresList(@Field("doctorid") String doctorid,
                                                     @Field("page") int page,
                                                     @Field("status") int status,
                                                     @Field("typecode") String typecode);

    //处方列表数量
    @FormUrlEncoded
    @POST("/doctorPrescript/getDoctorPrescriptOrderCount")
    Observable<HttpResult<List<PresTitleBean>>> getPresTitle(@Field("typecode") String typecode);

    //问诊列表数量
    @FormUrlEncoded
    @POST("/doctorAdvAdvice/getDoctorAskCount")
    Observable<HttpResult<List<PresTitleBean>>> getInquiryTitle(@Field("typecode") String typecode);

    //预约订单列表数量
    @POST("/doctorRegRegisterOrder/getDoctorRegRegisterOrderCount")
    Observable<HttpResult<List<PresTitleBean>>> getReserveTitle();

    //处方详情
    @FormUrlEncoded
    @POST("/doctorPrescript/getPrescriptById")
    Observable<HttpResult<PresDetailBean>> getPresDetail(@Field("id") String id);

    //面对面开方详情二维码
    @FormUrlEncoded
    @POST("/doctorPrescript/getPrescriptCodeUrl")
    Observable<HttpResult<Object>> getPresDetailQrCode(@Field("id") String id);

    //问诊列表
    @FormUrlEncoded
    @POST("/doctorAdvAdvice/getAskList")
    Observable<HttpResult<InquiryListBean>> getInquiryList(@Field("doctorid") String doctorid,
                                                           @Field("page") int page,
                                                           @Field("status") int status,
                                                           @Field("typecode") String typecode);


    //粉丝列表
    @FormUrlEncoded
    @POST("/doctorFocus/getDoctorFocus")
    Observable<HttpResult<List<FansListBean>>> getFanseList(@Field("doctorid") String doctorid,
                                                            @Field("page") int page,
                                                            @Field("realname") String realname);

    //邀请就诊
    @FormUrlEncoded
    @POST("/doctorFocus/doctorInvitationTreatment")
    Observable<HttpResult<Object>> seeDoctor(@Field("memberids") String memberids,
                                             @Field("content") String content);

    //预约挂号列表
    @FormUrlEncoded
    @POST("/doctorRegRegisterOrder/getDoctorRegRegisterOrder")
    Observable<HttpResult<RegListBean>> getRegList(@Field("doctorid") String doctorid,
                                                   @Field("page") int page,
                                                   @Field("status") int status);

    //挂号详情
    @FormUrlEncoded
    @POST("/doctorRegRegisterOrder/getDoctorRegRegisterOrderById")
    Observable<HttpResult<RegDetailBean>> getRegDetail(@Field("id") String id);

    //患者主页
    @FormUrlEncoded
    @POST("/doctorAskHistory/getAccountPatient")
    Observable<HttpResult<PatientDetailBean>> getPatientDetail(@Field("accountid") String accountid,
                                                               @Field("patientid") String patientid);

    //帮助上传
    @FormUrlEncoded
    @POST("/doctorAskHistory/saveMemAccountPatientDisease")
    Observable<HttpResult<Object>> patientUploadImg(@Field("img") String img,
                                                    @Field("patientid") String patientid);

    //通讯录
    @FormUrlEncoded
    @POST("/doctorMail/getMail")
    Observable<HttpResult<ContactsBean>> getcontacts(@Field("searchname") String searchname,
                                                     @Field("page") int page,
                                                     @Field("typecode") Integer typecode);

    //群发
    @FormUrlEncoded
    @POST("/doctorMail/doctorGroupInformation")
    Observable<HttpResult<Object>> sendMessage(@Field("memberids") String searchname,
                                               @Field("remark") String remark);

    //获取公告信息
    @FormUrlEncoded
    @POST("/doctorNotice/getNotice")
    Observable<HttpResult<NoticeBean>> getNotice(@Field("page") int page);

    //获取置顶公告信息
    @POST("doctorNotice/getTopNotice")
    Observable<HttpResult<NoticeBean.ListBean>> getTopNotice();

    //获取发送次数
    @POST("/doctorNotice/getWxSendNum")
    Observable<HttpResult<WxSendNumBean>> getWxSendNum();

    //添加公告
    @FormUrlEncoded
    @POST("/doctorNotice/saveNotice")
    Observable<HttpResult<Object>> saveNotice(@Field("content") String content,
                                              @Field("imgs") String imgs,
                                              @Field("issendwx") String issendwx,
                                              @Field("istop") String istop);

    //编辑公告
    @FormUrlEncoded
    @POST("/doctorNotice/updateNotice")
    Observable<HttpResult<Object>> updateNotice(@Field("content") String content,
                                                @Field("id") String id,
                                                @Field("imgs") String imgs,
                                                @Field("issendwx") String issendwx,
                                                @Field("istop") String istop);

    //置顶公告
    @FormUrlEncoded
    @POST("/doctorNotice/topNotice")
    Observable<HttpResult<Object>> topNotice(@Field("id") String id);

    //删除公告
    @FormUrlEncoded
    @POST("/doctorNotice/deleteNotice")
    Observable<HttpResult<Object>> deleteNotice(@Field("id") String id);

}
