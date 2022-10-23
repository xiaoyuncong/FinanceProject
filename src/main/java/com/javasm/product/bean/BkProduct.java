package com.javasm.product.bean;

public class BkProduct {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.product_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.product_name
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.product_line_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer productLineId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.product_type_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer productTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.manage_orgnazition
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private String manageOrgnazition;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.open_time
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private String openTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.currency_type
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private String currencyType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.annual_yield
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Float annualYield;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.audit_state
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer auditState;

    private Integer ordered;

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    private String productLineChineseName;

    public String getProductLineChineseName() {
        return productLineChineseName;
    }

    public void setProductLineChineseName(String productLineChineseName) {
        this.productLineChineseName = productLineChineseName;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.admin_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer adminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.subscription_cycle
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private String subscriptionCycle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.fund_manage_rates
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Float fundManageRates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.subscription_rates
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Float subscriptionRates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.subscription_start_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Float subscriptionStartMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.collect_type
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer collectType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.collect_cycle
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer collectCycle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.collect_start_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Float collectStartMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.collect_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Float collectMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.lock_period
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private Integer lockPeriod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bk_product.examine_massage
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    private String examineMassage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.product_id
     *
     * @return the value of bk_product.product_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.product_id
     *
     * @param productId the value for bk_product.product_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.product_name
     *
     * @return the value of bk_product.product_name
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.product_name
     *
     * @param productName the value for bk_product.product_name
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.product_line_id
     *
     * @return the value of bk_product.product_line_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getProductLineId() {
        return productLineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.product_line_id
     *
     * @param productLineId the value for bk_product.product_line_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setProductLineId(Integer productLineId) {
        this.productLineId = productLineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.product_type_id
     *
     * @return the value of bk_product.product_type_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getProductTypeId() {
        return productTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.product_type_id
     *
     * @param productTypeId the value for bk_product.product_type_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.manage_orgnazition
     *
     * @return the value of bk_product.manage_orgnazition
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public String getManageOrgnazition() {
        return manageOrgnazition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.manage_orgnazition
     *
     * @param manageOrgnazition the value for bk_product.manage_orgnazition
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setManageOrgnazition(String manageOrgnazition) {
        this.manageOrgnazition = manageOrgnazition == null ? null : manageOrgnazition.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.open_time
     *
     * @return the value of bk_product.open_time
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.open_time
     *
     * @param openTime the value for bk_product.open_time
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.currency_type
     *
     * @return the value of bk_product.currency_type
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.currency_type
     *
     * @param currencyType the value for bk_product.currency_type
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType == null ? null : currencyType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.annual_yield
     *
     * @return the value of bk_product.annual_yield
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Float getAnnualYield() {
        return annualYield;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.annual_yield
     *
     * @param annualYield the value for bk_product.annual_yield
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setAnnualYield(Float annualYield) {
        this.annualYield = annualYield;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.audit_state
     *
     * @return the value of bk_product.audit_state
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getAuditState() {
        return auditState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.audit_state
     *
     * @param auditState the value for bk_product.audit_state
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.admin_id
     *
     * @return the value of bk_product.admin_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.admin_id
     *
     * @param adminId the value for bk_product.admin_id
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.subscription_cycle
     *
     * @return the value of bk_product.subscription_cycle
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public String getSubscriptionCycle() {
        return subscriptionCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.subscription_cycle
     *
     * @param subscriptionCycle the value for bk_product.subscription_cycle
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setSubscriptionCycle(String subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle == null ? null : subscriptionCycle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.fund_manage_rates
     *
     * @return the value of bk_product.fund_manage_rates
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Float getFundManageRates() {
        return fundManageRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.fund_manage_rates
     *
     * @param fundManageRates the value for bk_product.fund_manage_rates
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setFundManageRates(Float fundManageRates) {
        this.fundManageRates = fundManageRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.subscription_rates
     *
     * @return the value of bk_product.subscription_rates
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Float getSubscriptionRates() {
        return subscriptionRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.subscription_rates
     *
     * @param subscriptionRates the value for bk_product.subscription_rates
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setSubscriptionRates(Float subscriptionRates) {
        this.subscriptionRates = subscriptionRates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.subscription_start_money
     *
     * @return the value of bk_product.subscription_start_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Float getSubscriptionStartMoney() {
        return subscriptionStartMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.subscription_start_money
     *
     * @param subscriptionStartMoney the value for bk_product.subscription_start_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setSubscriptionStartMoney(Float subscriptionStartMoney) {
        this.subscriptionStartMoney = subscriptionStartMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.collect_type
     *
     * @return the value of bk_product.collect_type
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getCollectType() {
        return collectType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.collect_type
     *
     * @param collectType the value for bk_product.collect_type
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setCollectType(Integer collectType) {
        this.collectType = collectType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.collect_cycle
     *
     * @return the value of bk_product.collect_cycle
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getCollectCycle() {
        return collectCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.collect_cycle
     *
     * @param collectCycle the value for bk_product.collect_cycle
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setCollectCycle(Integer collectCycle) {
        this.collectCycle = collectCycle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.collect_start_money
     *
     * @return the value of bk_product.collect_start_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Float getCollectStartMoney() {
        return collectStartMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.collect_start_money
     *
     * @param collectStartMoney the value for bk_product.collect_start_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setCollectStartMoney(Float collectStartMoney) {
        this.collectStartMoney = collectStartMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.collect_money
     *
     * @return the value of bk_product.collect_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Float getCollectMoney() {
        return collectMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.collect_money
     *
     * @param collectMoney the value for bk_product.collect_money
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setCollectMoney(Float collectMoney) {
        this.collectMoney = collectMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.lock_period
     *
     * @return the value of bk_product.lock_period
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public Integer getLockPeriod() {
        return lockPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.lock_period
     *
     * @param lockPeriod the value for bk_product.lock_period
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setLockPeriod(Integer lockPeriod) {
        this.lockPeriod = lockPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bk_product.examine_massage
     *
     * @return the value of bk_product.examine_massage
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public String getExamineMassage() {
        return examineMassage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bk_product.examine_massage
     *
     * @param examineMassage the value for bk_product.examine_massage
     *
     * @mbggenerated Wed Oct 19 11:00:07 CST 2022
     */
    public void setExamineMassage(String examineMassage) {
        this.examineMassage = examineMassage == null ? null : examineMassage.trim();
    }
}