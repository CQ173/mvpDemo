//package com.example.myapplication.view.activity;
//
//import android.graphics.Color;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.alibaba.sdk.android.oss.ClientException;
//import com.alibaba.sdk.android.oss.ServiceException;
//import com.alibaba.sdk.android.oss.model.PutObjectRequest;
//import com.alibaba.sdk.android.oss.model.PutObjectResult;
//import com.bumptech.glide.Glide;
//import com.example.myapplication.R;
//import com.example.myapplication.view.activity.base.BaseActivity;
//import com.example.myapplication.view.widget.TitleView;
//import com.google.gson.Gson;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//import cn.addapp.pickers.common.LineConfig;
//import cn.addapp.pickers.listeners.OnItemPickListener;
//import cn.addapp.pickers.picker.DatePicker;
//import cn.addapp.pickers.picker.SinglePicker;
//import okhttp3.RequestBody;
//
//public class NormalEntryActivity extends BaseActivity {
//    @BindView(R.id.title_bar)
//    TitleView title_bar;
//    @BindView(R.id.iv_id_card_z)     //身份证正面
//    ImageView ivIdCardZ;
//    @BindView(R.id.iv_id_card_f)    //身份证反面
//    ImageView ivIdCardF;
//    @BindView(R.id.tv_select_address)   //营业地址
//    TextView tv_select_address;
//    @BindView(R.id.iv_Business_permit)  //营业许可证照片
//    ImageView iv_Business_permit;
//    @BindView(R.id.iv_Shop_view)    //店铺内景照片
//    ImageView iv_Shop_view;
//    @BindView(R.id.iv_Shop_signs)   //店铺招牌照片
//    ImageView iv_Shop_signs;
//    @BindView(R.id.tv_Bank_name)    //结算银行名称
//    TextView tv_Bank_name;
//    @BindView(R.id.tv_License_type) //营业许可证类型
//    TextView tv_License_type;
//    @BindView(R.id.tv_Choicedate)   //营业期限
//    TextView tv_Choicedate;
//    @BindView(R.id.tv_Bank_coding)  //结算银行编码
//    TextView tv_Bank_coding;
//    @BindView(R.id.tv_Joint_line_number)    //银行卡联行号
//    TextView tv_Joint_line_number;
//    @BindView(R.id.tv_Area_code)    //银行卡结算地区码
//    TextView tv_Area_code;
//    @BindView(R.id.tv_Province_coding)  //省份编码
//    TextView tv_Province_coding;
//    @BindView(R.id.tv_City_coding)  //城市编码
//    TextView tv_City_coding;
//    @BindView(R.id.tv_Merchant_ID)  //商户ID
//    EditText tv_Merchant_ID;
////    @BindView(R.id.et_Merchant_name)    //商户名称
////    EditText et_Merchant_name;
////    @BindView(R.id.et_Merchant_short)   //商户简称
////    EditText et_Merchant_short;
////    @BindView(R.id.et_Detailed_address) //详细地址
////    EditText et_Detailed_address;
////    @BindView(R.id.et_Contact_phone_number)     //联系人手机号
////    EditText et_Contact_phone_number;
////    @BindView(R.id.et_User_name)    //用户姓名
////    EditText et_User_name;
////    @BindView(R.id.et_ID_number)   //身份证号
////    EditText et_ID_number;
////    @BindView(R.id.et_Business_license_number)  //营业执照号
////    EditText et_Business_license_number;
////    @BindView(R.id.et_Name_business_license)  //营业执照用户姓名
////    EditText et_Name_business_license;
////    @BindView(R.id.et_Bank_card_number)  //结算银行卡号
////    EditText et_Bank_card_number;
////    @BindView(R.id.et_Name_bank_card)  //结算银行卡用户姓名
////    EditText et_Name_bank_card;
////    @BindView(R.id.et_Bank_reserve_cellphone)   //结算银行卡预留手机号
////    EditText et_Bank_reserve_cellphone;
////    @BindView(R.id.et_Contract_rate)   //签约费率
////    EditText et_Contract_rate;
////    @BindView(R.id.tv_Settlement_cycle)   //商户交易结算周期
////    TextView tv_Settlement_cycle;
////    @BindView(R.id.tv_Agent_household_number)   //代理商商户号
////    TextView tv_Agent_household_number;
////    @BindView(R.id.et_Employee_account_number)   //员工账号
////    EditText et_Employee_account_number;
//
//    private String idCardZ;
//    private String idCardF;
//    private String idBusinesspermit;
//    private String idShopview;
//    private String idShopsigns;
//    private final int ID_CARD_Z = 1;
//    private final int ID_CARD_F = 2;
//    private final int ID_Business_permit = 3;
//    private final int ID_Shop_view = 4;
//    private final int ID_Shop_signs = 5;
//    private int type;
//    private int selecttype ;
//
//
//    CityPickerView mCityPickerView = new CityPickerView();
//    @Override
//    protected void setContentLayout() {
//        setContentView(R.layout.activity_normal_entry);
//    }
//
//    @Override
//    protected void initView() {
//        title_bar.setTitleText("商户进件入口");
//        title_bar.setLeftButtonListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                 finish();
//            }
//        });
//        mCityPickerView.init(this);
//        MD5Util.md5Password("睿鹏信息科技" + "ruipeng");
//    }
//
//    @OnClick({R.id.tv_Choicedate, R.id.tv_License_type, R.id.tv_select_address , R.id.tv_Bank_name ,
//            R.id.tv_Start_query , R.id.tv_Application_submission , R.id.tv_generate})
//    public void select(View view){
//        switch (view.getId()) {
//            //营业期限
//            case R.id.tv_Choicedate:
//                onYearMonthDayPicker();
//                break;
//            //营业许可证类型
//            case R.id.tv_License_type:
//                selecttype = 1 ;
//                onConstellationPicker(selecttype , null);
//                break;
//                //地址选择款
//            case R.id.tv_select_address:
//                wheel();
//                break;
//                //银行名称选择
//            case R.id.tv_Bank_name:
//                selecttype = 2 ;
//                onConstellationPicker(selecttype , null);
//                break;
//                //查询银行卡信息
//            case R.id.tv_Start_query:
//                Startquery();
//                break;
//                //提交申请信息
//            case R.id.tv_Application_submission:
////                submission();
//                break;
//                //生成商户ID
//            case R.id.tv_generate:
//                int merchantID = RandomUtil.getrandomnumber();
//                tv_Merchant_ID.setText("RP" + merchantID);
////                Log.i("随机数" , numcode + "--"+ RandomUtil.getrandomnumber());
//                break;
//        }
//    }
//
//    @OnClick({ R.id.iv_id_card_z, R.id.iv_id_card_f , R.id.iv_Business_permit , R.id.iv_Shop_view
//            , R.id.iv_Shop_signs})
//    public void onClick(View view){
//        switch (view.getId()){
//                //身份证正面照片
//            case R.id.iv_id_card_z:
//                type = ID_CARD_Z;
//                break;
//            //身份证反面照片
//            case R.id.iv_id_card_f:
//                type = ID_CARD_F;
//                break;
//                //营业许可证照片
//            case R.id.iv_Business_permit:
//                type = ID_Business_permit;
//                break;
//                //店铺内景照片
//            case R.id.iv_Shop_view:
//                type = ID_Shop_view;
//                break;
//                //店铺招牌照片
//            case R.id.iv_Shop_signs:
//                type = ID_Shop_signs;
//                break;
//            default:
//        }
//        new ChoosePicUtil.Builder(this)
//                .setResultCallback(picPathList ->
//                        uploadPic("android" + System.currentTimeMillis() + ".jpg", picPathList.get(0), view))
//                .create().show();
//    }
//
//    //地址选择框
//    private void wheel() {
//        CityConfig cityConfig = new CityConfig.Builder().title("选择城市").build();//标题
//        mCityPickerView.setConfig(cityConfig);
//        mCityPickerView.setOnCityItemClickListener(new OnCityItemClickListener() {
//            @Override
//            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
//                StringBuilder sb = new StringBuilder();
//                if (province != null) {
//                    sb.append(province.getName() + "\t");
//                }
//                if (city != null) {
//                    sb.append(city.getName() + ("\t"));
//                }
//                if (district != null) {
//                    sb.append(district.getName() + ("\t"));
//                }
//                tv_select_address.setText("" + sb.toString());
//                //省份编码
//                tv_Province_coding.setText(province.getId());
//                //城市编码
//                tv_City_coding.setText(city.getId());
//            }
//            @Override
//            public void onCancel() {
//                ToastUtils.showLongToast(getContext(), "已取消");
//            }
//        });
//        mCityPickerView.showCityPicker();
//    }
//    //图片上传
//    private void uploadPic(String key, String path, View view) {
//        new UploadImgUtil(this, key, path) {
//
//            @Override
//            public void _onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
//                uploadSucceed(Constant.IMG_URL + key, view);
//            }
//
//            @Override
//            public void _onFailure(PutObjectRequest putObjectRequest, ClientException e, ServiceException e1) {
//
//            }
//        };
//    }
//
//    //图片上传
//    private void uploadSucceed(String url, View view) {
//        switch (type) {
//            case ID_CARD_Z:
//                idCardZ = url;
//                break;
//            case ID_CARD_F:
//                idCardF = url;
//                break;
//            case ID_Business_permit:
//                idBusinesspermit = url;
//                break;
//            case ID_Shop_view:
//                idShopview = url;
//                break;
//            case ID_Shop_signs:
//                idShopsigns = url;
//                break;
//            default:
//        }
////        changeSubmitStatus();
//        Glide.with(this).load(url).into((ImageView) view);
//    }
//        //提交页面数据
////    private void changeSubmitStatus() {
////        if (!StringUtils.isEmpty(etRealName.getText()) && !StringUtils.isEmpty(tvSex.getText())
////                && !StringUtils.isEmpty(etIdCard.getText()) && !StringUtils.isEmpty(idCardZ)
////                && !StringUtils.isEmpty(idCardF) && !StringUtils.isEmpty(handheldPhoto)) {
////            btSubmit.setEnabled(true);
////            btSubmit.setBackgroundResource(R.drawable.oval_black_bg_5dp);
////        } else {
////            btSubmit.setEnabled(false);
////            btSubmit.setBackgroundResource(R.drawable.oval_gray_bg_5dp);
////        }
////    }
//
//    //日期选择
//    public void onYearMonthDayPicker() {
//        final DatePicker picker = new DatePicker(this);
//        picker.setCanLoop(false );
//        picker.setWheelModeEnable(true);
//        picker.setTopPadding(15);
//        picker.setRangeStart(2016, 8, 29);
//        picker.setRangeEnd(2111, 1, 11);
//        picker.setSelectedItem(2050, 10, 14);
//        picker.setWeightEnable(true);
//        picker.setLineColor(Color.BLACK);
//        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
//            @Override
//            public void onDatePicked(String year, String month, String day) {
////                Toast.makeText(NormalEntryActivity.this, year + "-" + month + "-" + day, Toast.LENGTH_SHORT).show();
//                tv_Choicedate.setText(year + "-" + month + "-" + day);
//            }
//        });
//        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
//            @Override
//            public void onYearWheeled(int index, String year) {
//                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
//            }
//
//            @Override
//            public void onMonthWheeled(int index, String month) {
//                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
//            }
//
//            @Override
//            public void onDayWheeled(int index, String day) {
//                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
//            }
//        });
//        picker.show();
//    }
//
//    //营业执照类型
//    public void onConstellationPicker(int selecttype , List<QuerybankRes> querybankRes) {
//        boolean isChinese = Locale.getDefault().getDisplayLanguage().contains("中文");
//        SinglePicker<String> picker = new SinglePicker<String>(this , isChinese ? new String[]{} : new String[]{
//                "Aquarius", "Pisces"});
//        if (selecttype == 1 ) {
//            picker = new SinglePicker<>(this,
//                    isChinese ? new String[]{"三证合一", "普通营业执照"} : new String[]{
//                            "Aquarius", "Pisces"});
//        }else if (selecttype == 2){
//            picker = new SinglePicker<>(this,
//                    isChinese ? new String[]{"农业银行", "交通银行" , "东亚银行" , "贵州银行" , "江西银行" ,
//                            "北京银行" , "中国银行" , "上海银行" , "包商银行" , "渤海银行" , "建设银行" , "光大银行" ,
//                            "兴业银行" , "中信银行" , "招商银行" , "民生银行" , "重庆银行" , "浙商银行" ,
//                            "恒丰银行" , "广发银行" , "广东南粤银行" , "广州银行", "汉口银行" , "徽商银行" , "华夏银行" ,
//                            "联合村镇银行", "中国工商银行" , "江苏银行" , "南京银行" , "农信社/农村合作银行/农商行",
//                            "平安银行" , "中国邮政储蓄银行" , "河北银行", "上海浦东发展银行" , "乌鲁木齐银行" ,
//                            "温州银行" , "西安银行", "其他银行" } : new String[]{
//                            "Aquarius", "Pisces"});
//        }else if (selecttype == 3){
//            String[] arr = new String[querybankRes.size()];
//            for (int i = 0; i < querybankRes.size(); i++) {
//                arr[i] = querybankRes.get(i).getBankName();
//            }
//            picker = new SinglePicker<>(this,
//                    isChinese ? arr : new String[]{
//                            "Aquarius", "Pisces"});
//        }
//        picker.setCanLoop(true);//不禁用循环
//        picker.setTopBackgroundColor(0xFFEEEEEE);
//        picker.setTopHeight(50);
//        picker.setTopLineColor(0xFF33B5E5);
//        picker.setTopLineHeight(1);
//        picker.setTitleText(isChinese ? "请选择" : "Please pick");
//        picker.setTitleTextColor(0xFF999999);
//        picker.setTitleTextSize(12);
//        picker.setCancelTextColor(0xFF33B5E5);
//        picker.setCancelTextSize(13);
//        picker.setSubmitTextColor(0xFF33B5E5);
//        picker.setSubmitTextSize(13);
//        picker.setSelectedTextColor(0xFFEE0000);
//        picker.setUnSelectedTextColor(0xFF999999);
//        picker.setWheelModeEnable(false);
//        LineConfig config = new LineConfig();
//        config.setColor(Color.BLUE);//线颜色
//        config.setAlpha(120);//线透明度
//        picker.setLineConfig(config);
//        picker.setItemWidth(350);
//        picker.setBackgroundColor(0xFFE1E1E1);
//        picker.setSelectedIndex(0);
//        picker.setOnItemPickListener(new OnItemPickListener<String>() {
//            @Override
//            public void onItemPicked(int index, String item) {
//                if (selecttype == 1 ) {
//                    tv_License_type.setText(item);
//                }else if (selecttype == 2 ){
//                    tv_Bank_name.setText(item);
//                    switch (index) {
//                        case 0:
//                            tv_Bank_coding.setText(BankcodingUtil.ABC_D_QB2C);
//                            break;
//                        case 1:
//                            tv_Bank_coding.setText(BankcodingUtil.BCOM_D_QB2C);
//                            break;
//                        case 2:
//                            tv_Bank_coding.setText(BankcodingUtil.BEA_D_QB2C);
//                            break;
//                        case 3:
//                            tv_Bank_coding.setText(BankcodingUtil.BGZ_D_QB2C);
//                            break;
//                        case 4:
//                            tv_Bank_coding.setText(BankcodingUtil.BJX_D_QB2C);
//                            break;
//                        case 5:
//                            tv_Bank_coding.setText(BankcodingUtil.BOB_D_QB2C);
//                            break;
//                        case 6:
//                            tv_Bank_coding.setText(BankcodingUtil.BOC_D_QB2C);
//                            break;
//                        case 7:
//                            tv_Bank_coding.setText(BankcodingUtil.BOSH_D_QB2C);
//                            break;
//                        case 8:
//                            tv_Bank_coding.setText(BankcodingUtil.BSB_D_QB2C);
//                            break;
//                        case 9:
//                            tv_Bank_coding.setText(BankcodingUtil.CBHB_D_QB2C);
//                            break;
//                        case 10:
//                            tv_Bank_coding.setText(BankcodingUtil.CCB_D_QB2C);
//                            break;
//                        case 11:
//                            tv_Bank_coding.setText(BankcodingUtil.CEB_D_QB2C);
//                            break;
//                        case 12:
//                            tv_Bank_coding.setText(BankcodingUtil.CIB_D_QB2C);
//                            break;
//                        case 13:
//                            tv_Bank_coding.setText(BankcodingUtil.CITIC_D_QB2C);
//                            break;
//                        case 14:
//                            tv_Bank_coding.setText(BankcodingUtil.CMB_D_QB2C);
//                            break;
//                        case 15:
//                            tv_Bank_coding.setText(BankcodingUtil.CMBC_D_QB2C);
//                            break;
//                        case 16:
//                            tv_Bank_coding.setText(BankcodingUtil.CQBK_D_QB2C);
//                            break;
//                        case 17:
//                            tv_Bank_coding.setText(BankcodingUtil.CZB_D_QB2C);
//                            break;
//                        case 18:
//                            tv_Bank_coding.setText(BankcodingUtil.EGF_D_QB2C);
//                            break;
//                        case 19:
//                            tv_Bank_coding.setText(BankcodingUtil.GDB_D_QB2C);
//                            break;
//                        case 20:
//                            tv_Bank_coding.setText(BankcodingUtil.GDNYB_D_QB2C);
//                            break;
//                        case 21:
//                            tv_Bank_coding.setText(BankcodingUtil.GZBC_D_QB2C);
//                            break;
//                        case 22:
//                            tv_Bank_coding.setText(BankcodingUtil.HKB_D_QB2C);
//                            break;
//                        case 23:
//                            tv_Bank_coding.setText(BankcodingUtil.HSB_D_QB2C);
//                            break;
//                        case 24:
//                            tv_Bank_coding.setText(BankcodingUtil.HXB_D_QB2C);
//                            break;
//                        case 25:
//                            tv_Bank_coding.setText(BankcodingUtil.HZLHB_D_QB2C);
//                            break;
//                        case 26:
//                            tv_Bank_coding.setText(BankcodingUtil.ICBC_D_QB2C);
//                            break;
//                        case 27:
//                            tv_Bank_coding.setText(BankcodingUtil.JSB_D_QB2C);
//                            break;
//                        case 28:
//                            tv_Bank_coding.setText(BankcodingUtil.NJCB_D_QB2C);
//                            break;
//                        case 29:
//                            tv_Bank_coding.setText(BankcodingUtil.NONGCUN);
//                            break;
//                        case 30:
//                            tv_Bank_coding.setText(BankcodingUtil.PAB_D_QB2C);
//                            break;
//                        case 31:
//                            tv_Bank_coding.setText(BankcodingUtil.POST_D_QB2C);
//                            break;
//                        case 32:
//                            tv_Bank_coding.setText(BankcodingUtil.SCCB_D_QB2C);
//                            break;
//                        case 33:
//                            tv_Bank_coding.setText(BankcodingUtil.SPDB_D_QB2C);
//                            break;
//                        case 34:
//                            tv_Bank_coding.setText(BankcodingUtil.UCCB_D_QB2C);
//                            break;
//                        case 35:
//                            tv_Bank_coding.setText(BankcodingUtil.WZBK_D_QB2C);
//                            break;
//                        case 36:
//                            tv_Bank_coding.setText(BankcodingUtil.XIANBANK_D_QB2C);
//                            break;
//                        case 37:
//                            tv_Bank_coding.setText(BankcodingUtil.OTHER);
//                            break;
//                    }
//                }else if (selecttype == 3){
//                    for (int i = 0; i < querybankRes.size(); i++) {
//                        tv_Joint_line_number.setText(querybankRes.get(index).getBankLineNumber());
//                        tv_Area_code.setText(querybankRes.get(index).getFinanceAreaCode());
//                    }
//                }
//            }
//        });
//        picker.show();
//    }
//    public void Startquery(){
//        //随机数
//        String uuid = RandomUtil.getuuid();
//        String str = MD5Util.md5Password(BankcodingUtil.PLATFORMCODING + uuid + tv_Bank_name.getText().toString() + BankcodingUtil.PLATFORMVENDORKEY);
//        String mac = str.toUpperCase();
////        Log.i("shuju" , "请求系统--"+ BankcodingUtil.PLATFORMCODING + "请求流水号--" + uuid + "银行名称--" +
////                tv_Bank_name.getText().toString() + "银行编码--" +  tv_Bank_coding.getText().toString() + "mac检验码--" + mac);
//        Map<String, Object> map = new HashMap<>();
//        map.put("bankName",tv_Bank_name.getText().toString());
//        map.put("bankCode",tv_Bank_coding.getText().toString());
//        map.put("requestSystem",BankcodingUtil.PLATFORMCODING);
//        map.put("requestSeqId",uuid);
//        map.put("mac",mac);
//        String json= new Gson().toJson(map);//要传递的json
//        RequestBody requestBody=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),json);
//        Api.getDefault().getBankcardinformation( requestBody )
//                .compose(RxHelper.handleResult())
//                .subscribe(new RxSubscriber<List<QuerybankRes>>(this) {
//                    @Override
//                    protected void _onNext(List<QuerybankRes> list) {
//                        selecttype = 3 ;
//                        onConstellationPicker(selecttype , list);
//                    }
//
//                    @Override
//                    protected void _onError(String msg) {
//
//                    }
//                });
//    }
//
//    //提交申请进件信息
////    public void submission(){
////        String businessAddress = tv_select_address.getText() +""+ et_Detailed_address.getText();
////        String a = "快递服务";
////        String b = "4215";
////        //随机数
////        String uuid = RandomUtil.getuuid();
////        String str = MD5Util.md5Password(BankcodingUtil.PLATFORMCODING + uuid + tv_Merchant_ID.getText().toString() +
////                et_Merchant_name.getText().toString() + et_Merchant_short.getText().toString() + a + tv_Choicedate.getText() +
////                tv_Province_coding.getText().toString() + tv_City_coding.getText().toString() + businessAddress + b + et_Contact_phone_number.getText().toString() +
////                et_User_name.getText().toString() + et_ID_number.getText().toString() + et_Business_license_number.getText().toString() +
////                et_Name_business_license.getText().toString() + tv_License_type.getText().toString() + tv_Bank_name.getText().toString() +
////                tv_Bank_coding.getText().toString() + et_Bank_card_number.getText().toString() + et_Name_bank_card.getText().toString() +
////                tv_Joint_line_number.getText().toString() + tv_Area_code.getText().toString() + et_Contract_rate.getText().toString() +
////                tv_Settlement_cycle.getText().toString() + BankcodingUtil.PLATFORMVENDORKEY);
////
////        String mac = str.toUpperCase();
////
//////        Log.i("shuju" , "请求系统--"+ BankcodingUtil.PLATFORMCODING + "请求流水号--" + uuid + "银行名称--" +
//////                tv_Bank_name.getText().toString() + "银行编码--" +  tv_Bank_coding.getText().toString() + "mac检验码--" + mac);
////        Map<String, Object> map = new HashMap<>();
////        map.put("requestSystem",BankcodingUtil.PLATFORMCODING);
////        map.put("requestSeqId",uuid);
////        map.put("platformMerchantNo",BankcodingUtil.TESTINGPLATFORMBUSINESSNUMBER);
////        map.put("merchantNo",tv_Merchant_ID.getText());
////        map.put("merchantName",et_Merchant_name.getText());
////        map.put("merchantNameShort",et_Merchant_short.getText());
////        map.put("businessScope",a); //暂时没有   营业范围
////        map.put("businessTerm",tv_Choicedate.getText());
////        map.put("provinceCode",tv_Province_coding.getText());
////        map.put("cityCode",tv_City_coding.getText());
////        map.put("businessAddress",businessAddress);
////        map.put("mccCode",b); //暂时没有   行业类型编码
////        map.put("contactPhone",et_Contact_phone_number.getText());
////        map.put("identityCardUserName",et_User_name.getText());
////        map.put("identityCardNo",et_ID_number.getText());
////        map.put("identityCardFrontPic",idCardZ);
////        map.put("identityCardReversePic",idCardF);
////        map.put("busiLicenseNo",et_Business_license_number.getText());
////        map.put("busiLicenseUserName" , et_Name_business_license.getText());
////        map.put("licenseType" ,tv_License_type.getText() );
////        map.put("licensePic" , idBusinesspermit);
////        map.put("storeInteriorPic" , idShopview );
////        map.put("storeSignBoardPic" , idShopsigns );
////        map.put("settleBankName" ,tv_Bank_name.getText() );
////        map.put("settleBankNo" , tv_Bank_coding.getText());
////        map.put("settleBankcardNo" , et_Bank_card_number.getText() );
////        map.put("settleBankcardUserName" ,et_Name_bank_card.getText() );
////        map.put("settleBankcardLineNumber" , tv_Joint_line_number.getText());
////        map.put("settleBankcardFinanceAreaCode" , tv_Area_code.getText());
////        map.put("settlePhoneNo" ,et_Bank_reserve_cellphone.getText() );
////        map.put("merchantTxnRate" , et_Contract_rate.getText());
////        map.put("merchantTxnSettlePeriod" , tv_Settlement_cycle.getText());
////        map.put("agentMerchantCode" ,tv_Agent_household_number.getText() );
////        map.put("recommendNo" , et_Employee_account_number.getText());
////        map.put("mac" , mac );  //待定
////        String json= new Gson().toJson(map);//要传递的json
////        RequestBody requestBody=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),json);
////
////        Api.getDefault().getMerchantentry( requestBody )
////                .compose(RxHelper.handleResult())
////                .subscribe(new RxSubscriber<String>(this) {
////                    @Override
////                    protected void _onNext(String str) {
////                        Toast.makeText(NormalEntryActivity.this, "成功", Toast.LENGTH_SHORT).show();
////                    }
////
////                    @Override
////                    protected void _onError(String msg) {
////
////                    }
////                });
////    }
//
//    @Override
//    protected void obtainData() {
//
//    }
//
//    @Override
//    protected void initEvent() {
//
//    }
//}
