package com.javasm.product.bean;

public class ProductNet {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_net.net_id
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    private Integer netId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_net.product_id
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_net.unit_net
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    private Float unitNet;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_net.net_base
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    private String netBase;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_net.growth_rate
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    private Float growthRate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_net.net_id
     *
     * @return the value of product_net.net_id
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public Integer getNetId() {
        return netId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_net.net_id
     *
     * @param netId the value for product_net.net_id
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public void setNetId(Integer netId) {
        this.netId = netId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_net.product_id
     *
     * @return the value of product_net.product_id
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_net.product_id
     *
     * @param productId the value for product_net.product_id
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_net.unit_net
     *
     * @return the value of product_net.unit_net
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public Float getUnitNet() {
        return unitNet;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_net.unit_net
     *
     * @param unitNet the value for product_net.unit_net
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public void setUnitNet(Float unitNet) {
        this.unitNet = unitNet;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_net.net_base
     *
     * @return the value of product_net.net_base
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public String getNetBase() {
        return netBase;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_net.net_base
     *
     * @param netBase the value for product_net.net_base
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public void setNetBase(String netBase) {
        this.netBase = netBase == null ? null : netBase.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_net.growth_rate
     *
     * @return the value of product_net.growth_rate
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public Float getGrowthRate() {
        return growthRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_net.growth_rate
     *
     * @param growthRate the value for product_net.growth_rate
     *
     * @mbggenerated Wed Oct 19 22:35:03 CST 2022
     */
    public void setGrowthRate(Float growthRate) {
        this.growthRate = growthRate;
    }
}