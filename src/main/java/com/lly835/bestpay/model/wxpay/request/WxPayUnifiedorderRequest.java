package com.lly835.bestpay.model.wxpay.request;

import lombok.Data;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by 廖师兄
 * 2017-07-02 13:42
 */
@Data
@Root(name = "xml", strict = false)
public class WxPayUnifiedorderRequest {

    @Element
    public String appid;

    @Element(name = "mch_id")
    private String mchId;

    @Element(name = "nonce_str")
    private String nonceStr;

    @Element
    private String sign;

    @Element(required = false)
    private String attach;

    @Element
    private String body;

    @Element(required = false, data = true)
    private String detail;

    @Element(name = "notify_url")
    private String notifyUrl;

    @Element
    private String openid;

    @Element(name = "out_trade_no")
    private String outTradeNo;

    @Element(name = "spbill_create_ip")
    private String spbillCreateIp;

    @Element(name = "total_fee")
    private Integer totalFee;

    @Element(name = "trade_type")
    private String tradeType;
}
