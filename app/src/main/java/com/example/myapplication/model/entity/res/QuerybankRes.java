package com.example.myapplication.model.entity.res;

public class QuerybankRes {

    private String bankName ; //银行支行名称
    private String bankLineNumber ; //银行联行号
    private String financeAreaCode ; //结算地区码

    public QuerybankRes() {

    }

    public QuerybankRes(String bankName, String bankLineNumber, String financeAreaCode) {

        this.bankName = bankName;
        this.bankLineNumber = bankLineNumber;
        this.financeAreaCode = financeAreaCode;
    }

    public String getBankName() {

        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLineNumber() {
        return bankLineNumber;
    }

    public void setBankLineNumber(String bankLineNumber) {
        this.bankLineNumber = bankLineNumber;
    }

    public String getFinanceAreaCode() {
        return financeAreaCode;
    }

    public void setFinanceAreaCode(String financeAreaCode) {
        this.financeAreaCode = financeAreaCode;
    }
}
