package com.javasm.product.bean;

public class ProductRelated {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_related.product_id
     *
     * @mbggenerated Tue Oct 18 14:55:34 CST 2022
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_related.related_product_id
     *
     * @mbggenerated Tue Oct 18 14:55:34 CST 2022
     */
    private Integer relatedProductId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_related.product_id
     *
     * @return the value of product_related.product_id
     *
     * @mbggenerated Tue Oct 18 14:55:34 CST 2022
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_related.product_id
     *
     * @param productId the value for product_related.product_id
     *
     * @mbggenerated Tue Oct 18 14:55:34 CST 2022
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_related.related_product_id
     *
     * @return the value of product_related.related_product_id
     *
     * @mbggenerated Tue Oct 18 14:55:34 CST 2022
     */
    public Integer getRelatedProductId() {
        return relatedProductId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_related.related_product_id
     *
     * @param relatedProductId the value for product_related.related_product_id
     *
     * @mbggenerated Tue Oct 18 14:55:34 CST 2022
     */
    public void setRelatedProductId(Integer relatedProductId) {
        this.relatedProductId = relatedProductId;
    }
}