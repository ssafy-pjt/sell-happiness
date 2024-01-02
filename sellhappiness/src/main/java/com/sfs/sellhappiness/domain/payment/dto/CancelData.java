package com.sfs.sellhappiness.domain.payment.dto;

import com.google.gson.annotations.SerializedName;
import com.siot.IamportRestClient.request.ExtraRequesterEntry;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CancelData extends com.siot.IamportRestClient.request.CancelData {
    @SerializedName("imp_uid")
    private String imp_uid;

    @SerializedName("merchant_uid")
    private String merchant_uid;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("tax_free")
    private BigDecimal tax_free;

    @SerializedName("checksum")
    private BigDecimal checksum;

    @SerializedName("reason")
    private String reason;

    @SerializedName("refund_holder")
    private String refund_holder;

    @SerializedName("refund_bank")
    private String refund_bank;

    @SerializedName("refund_account")
    private String refund_account;

    @SerializedName("escrow_confirmed")
    private boolean escrow_confirmed;

    @SerializedName("extra")
    private ExtraRequesterEntry extra;


    public CancelData(String uid, boolean imp_uid_or_not) {
        super(uid, imp_uid_or_not);
    }

    public CancelData(String uid, boolean imp_uid_or_not, BigDecimal amount) {
        super(uid, imp_uid_or_not, amount);
    }
}
