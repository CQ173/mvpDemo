package com.example.myapplication.util.network;



public class UrlUtil {
    //内网服务器地址
    public static final String BASE_URL = "http://116.228.151.160:18002/";
    /**
     * 根据银行名称查询银行信息
     */
    public static final String QUERY_BANK_INFORMATION = "/mapi/o2o/personalstore/platformMerchantService/getSettleBankInfos";


    /**
     * 申请平台商商户进件
     */
    public static final String APPLICATIONFORMERCHANTENTRY = "/mapi/o2o/personalstore/platformMerchantService/applyMerchantEntry";

    /**
     * 首页产品分类
     */
    public static final String HOME_PAGE = "appapi/Index/dome";

    /**
     * 获取短信验证码
     */
    public static final String GET_CODE = "appapi/User/verifiDriver";

    /**
     * 登录
     */
    public static final String LOGIN_USER = "appapi/User/loginact";

    /**
     * 退出登录
     */
    public static final String EXIT_LOGON = "appapi/User/logout";

    /**
     * 用户中心获取用户个人信息
     */
    public static final String GET_USER = "appapi/User/getUserInfo";

    /**
     * 分类页贷款类型
     */
    public static final String TYPE_OF_LOAN = "appapi/Classification/art";

    /**
     *  分类页贷款金额产品/贷款类型产品
     */
    public static final String CLASSIFICATION_PAGE = "appapi/Classification/all";
}
