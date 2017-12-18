package com.yundao.tenant.model.base.product;

import com.yundao.core.utils.Limit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseProductSaleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = 0;

    protected int limitEnd = 0;

    protected Limit limit;

    public BaseProductSaleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        criteria.andIsDeleteEqualTo(0);
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    public BaseProductSaleExample setLimit(Limit limit) {
        this.limit=limit;
        return this;
    }

    public Limit getLimit() {
        return limit;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateIsNull() {
            addCriterion("sale_start_date is null");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateIsNotNull() {
            addCriterion("sale_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("sale_start_date =", value, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sale_start_date <>", value, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sale_start_date >", value, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sale_start_date >=", value, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateLessThan(Date value) {
            addCriterionForJDBCDate("sale_start_date <", value, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sale_start_date <=", value, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("sale_start_date in", values, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sale_start_date not in", values, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sale_start_date between", value1, value2, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sale_start_date not between", value1, value2, "saleStartDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateIsNull() {
            addCriterion("sale_end_date is null");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateIsNotNull() {
            addCriterion("sale_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("sale_end_date =", value, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sale_end_date <>", value, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sale_end_date >", value, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sale_end_date >=", value, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateLessThan(Date value) {
            addCriterionForJDBCDate("sale_end_date <", value, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sale_end_date <=", value, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("sale_end_date in", values, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sale_end_date not in", values, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sale_end_date between", value1, value2, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andSaleEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sale_end_date not between", value1, value2, "saleEndDate");
            return (Criteria) this;
        }

        public Criteria andIsScaleIsNull() {
            addCriterion("is_scale is null");
            return (Criteria) this;
        }

        public Criteria andIsScaleIsNotNull() {
            addCriterion("is_scale is not null");
            return (Criteria) this;
        }

        public Criteria andIsScaleEqualTo(Integer value) {
            addCriterion("is_scale =", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleNotEqualTo(Integer value) {
            addCriterion("is_scale <>", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleGreaterThan(Integer value) {
            addCriterion("is_scale >", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_scale >=", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleLessThan(Integer value) {
            addCriterion("is_scale <", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleLessThanOrEqualTo(Integer value) {
            addCriterion("is_scale <=", value, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleIn(List<Integer> values) {
            addCriterion("is_scale in", values, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleNotIn(List<Integer> values) {
            addCriterion("is_scale not in", values, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleBetween(Integer value1, Integer value2) {
            addCriterion("is_scale between", value1, value2, "isScale");
            return (Criteria) this;
        }

        public Criteria andIsScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_scale not between", value1, value2, "isScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleIsNull() {
            addCriterion("product_scale is null");
            return (Criteria) this;
        }

        public Criteria andProductScaleIsNotNull() {
            addCriterion("product_scale is not null");
            return (Criteria) this;
        }

        public Criteria andProductScaleEqualTo(Double value) {
            addCriterion("product_scale =", value, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleNotEqualTo(Double value) {
            addCriterion("product_scale <>", value, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleGreaterThan(Double value) {
            addCriterion("product_scale >", value, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleGreaterThanOrEqualTo(Double value) {
            addCriterion("product_scale >=", value, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleLessThan(Double value) {
            addCriterion("product_scale <", value, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleLessThanOrEqualTo(Double value) {
            addCriterion("product_scale <=", value, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleIn(List<Double> values) {
            addCriterion("product_scale in", values, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleNotIn(List<Double> values) {
            addCriterion("product_scale not in", values, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleBetween(Double value1, Double value2) {
            addCriterion("product_scale between", value1, value2, "productScale");
            return (Criteria) this;
        }

        public Criteria andProductScaleNotBetween(Double value1, Double value2) {
            addCriterion("product_scale not between", value1, value2, "productScale");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNull() {
            addCriterion("pay_account is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountIsNotNull() {
            addCriterion("pay_account is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountEqualTo(String value) {
            addCriterion("pay_account =", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotEqualTo(String value) {
            addCriterion("pay_account <>", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThan(String value) {
            addCriterion("pay_account >", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account >=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThan(String value) {
            addCriterion("pay_account <", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLessThanOrEqualTo(String value) {
            addCriterion("pay_account <=", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountLike(String value) {
            addCriterion("pay_account like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotLike(String value) {
            addCriterion("pay_account not like", value, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountIn(List<String> values) {
            addCriterion("pay_account in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotIn(List<String> values) {
            addCriterion("pay_account not in", values, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountBetween(String value1, String value2) {
            addCriterion("pay_account between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andPayAccountNotBetween(String value1, String value2) {
            addCriterion("pay_account not between", value1, value2, "payAccount");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andRaiseBankIsNull() {
            addCriterion("raise_bank is null");
            return (Criteria) this;
        }

        public Criteria andRaiseBankIsNotNull() {
            addCriterion("raise_bank is not null");
            return (Criteria) this;
        }

        public Criteria andRaiseBankEqualTo(String value) {
            addCriterion("raise_bank =", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankNotEqualTo(String value) {
            addCriterion("raise_bank <>", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankGreaterThan(String value) {
            addCriterion("raise_bank >", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankGreaterThanOrEqualTo(String value) {
            addCriterion("raise_bank >=", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankLessThan(String value) {
            addCriterion("raise_bank <", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankLessThanOrEqualTo(String value) {
            addCriterion("raise_bank <=", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankLike(String value) {
            addCriterion("raise_bank like", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankNotLike(String value) {
            addCriterion("raise_bank not like", value, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankIn(List<String> values) {
            addCriterion("raise_bank in", values, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankNotIn(List<String> values) {
            addCriterion("raise_bank not in", values, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankBetween(String value1, String value2) {
            addCriterion("raise_bank between", value1, value2, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andRaiseBankNotBetween(String value1, String value2) {
            addCriterion("raise_bank not between", value1, value2, "raiseBank");
            return (Criteria) this;
        }

        public Criteria andPayRemarkIsNull() {
            addCriterion("pay_remark is null");
            return (Criteria) this;
        }

        public Criteria andPayRemarkIsNotNull() {
            addCriterion("pay_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPayRemarkEqualTo(String value) {
            addCriterion("pay_remark =", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotEqualTo(String value) {
            addCriterion("pay_remark <>", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkGreaterThan(String value) {
            addCriterion("pay_remark >", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pay_remark >=", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkLessThan(String value) {
            addCriterion("pay_remark <", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkLessThanOrEqualTo(String value) {
            addCriterion("pay_remark <=", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkLike(String value) {
            addCriterion("pay_remark like", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotLike(String value) {
            addCriterion("pay_remark not like", value, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkIn(List<String> values) {
            addCriterion("pay_remark in", values, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotIn(List<String> values) {
            addCriterion("pay_remark not in", values, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkBetween(String value1, String value2) {
            addCriterion("pay_remark between", value1, value2, "payRemark");
            return (Criteria) this;
        }

        public Criteria andPayRemarkNotBetween(String value1, String value2) {
            addCriterion("pay_remark not between", value1, value2, "payRemark");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Long value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Long value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Long value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Long value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Long> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Long> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}