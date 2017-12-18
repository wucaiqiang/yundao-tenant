package com.yundao.tenant.model.base.product;

import com.yundao.core.utils.Limit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseProductCommissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = 0;

    protected int limitEnd = 0;

    protected Limit limit;

    public BaseProductCommissionExample() {
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

    public BaseProductCommissionExample setLimit(Limit limit) {
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

        public Criteria andCommissionRuleIdIsNull() {
            addCriterion("commission_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdIsNotNull() {
            addCriterion("commission_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdEqualTo(Long value) {
            addCriterion("commission_rule_id =", value, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdNotEqualTo(Long value) {
            addCriterion("commission_rule_id <>", value, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdGreaterThan(Long value) {
            addCriterion("commission_rule_id >", value, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("commission_rule_id >=", value, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdLessThan(Long value) {
            addCriterion("commission_rule_id <", value, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdLessThanOrEqualTo(Long value) {
            addCriterion("commission_rule_id <=", value, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdIn(List<Long> values) {
            addCriterion("commission_rule_id in", values, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdNotIn(List<Long> values) {
            addCriterion("commission_rule_id not in", values, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdBetween(Long value1, Long value2) {
            addCriterion("commission_rule_id between", value1, value2, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andCommissionRuleIdNotBetween(Long value1, Long value2) {
            addCriterion("commission_rule_id not between", value1, value2, "commissionRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleMaxIsNull() {
            addCriterion("sale_max is null");
            return (Criteria) this;
        }

        public Criteria andSaleMaxIsNotNull() {
            addCriterion("sale_max is not null");
            return (Criteria) this;
        }

        public Criteria andSaleMaxEqualTo(Double value) {
            addCriterion("sale_max =", value, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxNotEqualTo(Double value) {
            addCriterion("sale_max <>", value, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxGreaterThan(Double value) {
            addCriterion("sale_max >", value, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxGreaterThanOrEqualTo(Double value) {
            addCriterion("sale_max >=", value, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxLessThan(Double value) {
            addCriterion("sale_max <", value, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxLessThanOrEqualTo(Double value) {
            addCriterion("sale_max <=", value, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxIn(List<Double> values) {
            addCriterion("sale_max in", values, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxNotIn(List<Double> values) {
            addCriterion("sale_max not in", values, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxBetween(Double value1, Double value2) {
            addCriterion("sale_max between", value1, value2, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMaxNotBetween(Double value1, Double value2) {
            addCriterion("sale_max not between", value1, value2, "saleMax");
            return (Criteria) this;
        }

        public Criteria andSaleMinIsNull() {
            addCriterion("sale_min is null");
            return (Criteria) this;
        }

        public Criteria andSaleMinIsNotNull() {
            addCriterion("sale_min is not null");
            return (Criteria) this;
        }

        public Criteria andSaleMinEqualTo(Double value) {
            addCriterion("sale_min =", value, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinNotEqualTo(Double value) {
            addCriterion("sale_min <>", value, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinGreaterThan(Double value) {
            addCriterion("sale_min >", value, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinGreaterThanOrEqualTo(Double value) {
            addCriterion("sale_min >=", value, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinLessThan(Double value) {
            addCriterion("sale_min <", value, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinLessThanOrEqualTo(Double value) {
            addCriterion("sale_min <=", value, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinIn(List<Double> values) {
            addCriterion("sale_min in", values, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinNotIn(List<Double> values) {
            addCriterion("sale_min not in", values, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinBetween(Double value1, Double value2) {
            addCriterion("sale_min between", value1, value2, "saleMin");
            return (Criteria) this;
        }

        public Criteria andSaleMinNotBetween(Double value1, Double value2) {
            addCriterion("sale_min not between", value1, value2, "saleMin");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIsNull() {
            addCriterion("commission_type is null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIsNotNull() {
            addCriterion("commission_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeEqualTo(String value) {
            addCriterion("commission_type =", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotEqualTo(String value) {
            addCriterion("commission_type <>", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeGreaterThan(String value) {
            addCriterion("commission_type >", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("commission_type >=", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLessThan(String value) {
            addCriterion("commission_type <", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLessThanOrEqualTo(String value) {
            addCriterion("commission_type <=", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeLike(String value) {
            addCriterion("commission_type like", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotLike(String value) {
            addCriterion("commission_type not like", value, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeIn(List<String> values) {
            addCriterion("commission_type in", values, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotIn(List<String> values) {
            addCriterion("commission_type not in", values, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeBetween(String value1, String value2) {
            addCriterion("commission_type between", value1, value2, "commissionType");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeNotBetween(String value1, String value2) {
            addCriterion("commission_type not between", value1, value2, "commissionType");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionIsNull() {
            addCriterion("front_commission is null");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionIsNotNull() {
            addCriterion("front_commission is not null");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionEqualTo(Double value) {
            addCriterion("front_commission =", value, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionNotEqualTo(Double value) {
            addCriterion("front_commission <>", value, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionGreaterThan(Double value) {
            addCriterion("front_commission >", value, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("front_commission >=", value, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionLessThan(Double value) {
            addCriterion("front_commission <", value, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionLessThanOrEqualTo(Double value) {
            addCriterion("front_commission <=", value, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionIn(List<Double> values) {
            addCriterion("front_commission in", values, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionNotIn(List<Double> values) {
            addCriterion("front_commission not in", values, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionBetween(Double value1, Double value2) {
            addCriterion("front_commission between", value1, value2, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andFrontCommissionNotBetween(Double value1, Double value2) {
            addCriterion("front_commission not between", value1, value2, "frontCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionIsNull() {
            addCriterion("back_commission is null");
            return (Criteria) this;
        }

        public Criteria andBackCommissionIsNotNull() {
            addCriterion("back_commission is not null");
            return (Criteria) this;
        }

        public Criteria andBackCommissionEqualTo(Double value) {
            addCriterion("back_commission =", value, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionNotEqualTo(Double value) {
            addCriterion("back_commission <>", value, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionGreaterThan(Double value) {
            addCriterion("back_commission >", value, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("back_commission >=", value, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionLessThan(Double value) {
            addCriterion("back_commission <", value, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionLessThanOrEqualTo(Double value) {
            addCriterion("back_commission <=", value, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionIn(List<Double> values) {
            addCriterion("back_commission in", values, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionNotIn(List<Double> values) {
            addCriterion("back_commission not in", values, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionBetween(Double value1, Double value2) {
            addCriterion("back_commission between", value1, value2, "backCommission");
            return (Criteria) this;
        }

        public Criteria andBackCommissionNotBetween(Double value1, Double value2) {
            addCriterion("back_commission not between", value1, value2, "backCommission");
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

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Long value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Long value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Long value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Long value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Long value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Long> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Long> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Long value1, Long value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Long value1, Long value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
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