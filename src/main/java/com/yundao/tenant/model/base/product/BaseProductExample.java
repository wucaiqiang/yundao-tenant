package com.yundao.tenant.model.base.product;

import com.yundao.core.utils.Limit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = 0;

    protected int limitEnd = 0;

    protected Limit limit;

    public BaseProductExample() {
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

    public BaseProductExample setLimit(Limit limit) {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Long value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Long value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Long value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Long value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Long> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Long> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Long value1, Long value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelIsNull() {
            addCriterion("issued_channel is null");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelIsNotNull() {
            addCriterion("issued_channel is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelEqualTo(String value) {
            addCriterion("issued_channel =", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelNotEqualTo(String value) {
            addCriterion("issued_channel <>", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelGreaterThan(String value) {
            addCriterion("issued_channel >", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelGreaterThanOrEqualTo(String value) {
            addCriterion("issued_channel >=", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelLessThan(String value) {
            addCriterion("issued_channel <", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelLessThanOrEqualTo(String value) {
            addCriterion("issued_channel <=", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelLike(String value) {
            addCriterion("issued_channel like", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelNotLike(String value) {
            addCriterion("issued_channel not like", value, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelIn(List<String> values) {
            addCriterion("issued_channel in", values, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelNotIn(List<String> values) {
            addCriterion("issued_channel not in", values, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelBetween(String value1, String value2) {
            addCriterion("issued_channel between", value1, value2, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andIssuedChannelNotBetween(String value1, String value2) {
            addCriterion("issued_channel not between", value1, value2, "issuedChannel");
            return (Criteria) this;
        }

        public Criteria andInvestDomainIsNull() {
            addCriterion("invest_domain is null");
            return (Criteria) this;
        }

        public Criteria andInvestDomainIsNotNull() {
            addCriterion("invest_domain is not null");
            return (Criteria) this;
        }

        public Criteria andInvestDomainEqualTo(String value) {
            addCriterion("invest_domain =", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainNotEqualTo(String value) {
            addCriterion("invest_domain <>", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainGreaterThan(String value) {
            addCriterion("invest_domain >", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainGreaterThanOrEqualTo(String value) {
            addCriterion("invest_domain >=", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainLessThan(String value) {
            addCriterion("invest_domain <", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainLessThanOrEqualTo(String value) {
            addCriterion("invest_domain <=", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainLike(String value) {
            addCriterion("invest_domain like", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainNotLike(String value) {
            addCriterion("invest_domain not like", value, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainIn(List<String> values) {
            addCriterion("invest_domain in", values, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainNotIn(List<String> values) {
            addCriterion("invest_domain not in", values, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainBetween(String value1, String value2) {
            addCriterion("invest_domain between", value1, value2, "investDomain");
            return (Criteria) this;
        }

        public Criteria andInvestDomainNotBetween(String value1, String value2) {
            addCriterion("invest_domain not between", value1, value2, "investDomain");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNull() {
            addCriterion("time_limit is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNotNull() {
            addCriterion("time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitEqualTo(String value) {
            addCriterion("time_limit =", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotEqualTo(String value) {
            addCriterion("time_limit <>", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThan(String value) {
            addCriterion("time_limit >", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThanOrEqualTo(String value) {
            addCriterion("time_limit >=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThan(String value) {
            addCriterion("time_limit <", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThanOrEqualTo(String value) {
            addCriterion("time_limit <=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLike(String value) {
            addCriterion("time_limit like", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotLike(String value) {
            addCriterion("time_limit not like", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIn(List<String> values) {
            addCriterion("time_limit in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotIn(List<String> values) {
            addCriterion("time_limit not in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitBetween(String value1, String value2) {
            addCriterion("time_limit between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotBetween(String value1, String value2) {
            addCriterion("time_limit not between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andMechanismIsNull() {
            addCriterion("mechanism is null");
            return (Criteria) this;
        }

        public Criteria andMechanismIsNotNull() {
            addCriterion("mechanism is not null");
            return (Criteria) this;
        }

        public Criteria andMechanismEqualTo(String value) {
            addCriterion("mechanism =", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismNotEqualTo(String value) {
            addCriterion("mechanism <>", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismGreaterThan(String value) {
            addCriterion("mechanism >", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismGreaterThanOrEqualTo(String value) {
            addCriterion("mechanism >=", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismLessThan(String value) {
            addCriterion("mechanism <", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismLessThanOrEqualTo(String value) {
            addCriterion("mechanism <=", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismLike(String value) {
            addCriterion("mechanism like", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismNotLike(String value) {
            addCriterion("mechanism not like", value, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismIn(List<String> values) {
            addCriterion("mechanism in", values, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismNotIn(List<String> values) {
            addCriterion("mechanism not in", values, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismBetween(String value1, String value2) {
            addCriterion("mechanism between", value1, value2, "mechanism");
            return (Criteria) this;
        }

        public Criteria andMechanismNotBetween(String value1, String value2) {
            addCriterion("mechanism not between", value1, value2, "mechanism");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointIsNull() {
            addCriterion("buy_start_point is null");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointIsNotNull() {
            addCriterion("buy_start_point is not null");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointEqualTo(Double value) {
            addCriterion("buy_start_point =", value, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointNotEqualTo(Double value) {
            addCriterion("buy_start_point <>", value, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointGreaterThan(Double value) {
            addCriterion("buy_start_point >", value, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointGreaterThanOrEqualTo(Double value) {
            addCriterion("buy_start_point >=", value, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointLessThan(Double value) {
            addCriterion("buy_start_point <", value, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointLessThanOrEqualTo(Double value) {
            addCriterion("buy_start_point <=", value, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointIn(List<Double> values) {
            addCriterion("buy_start_point in", values, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointNotIn(List<Double> values) {
            addCriterion("buy_start_point not in", values, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointBetween(Double value1, Double value2) {
            addCriterion("buy_start_point between", value1, value2, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andBuyStartPointNotBetween(Double value1, Double value2) {
            addCriterion("buy_start_point not between", value1, value2, "buyStartPoint");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountIsNull() {
            addCriterion("incremental_amount is null");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountIsNotNull() {
            addCriterion("incremental_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountEqualTo(Double value) {
            addCriterion("incremental_amount =", value, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountNotEqualTo(Double value) {
            addCriterion("incremental_amount <>", value, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountGreaterThan(Double value) {
            addCriterion("incremental_amount >", value, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("incremental_amount >=", value, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountLessThan(Double value) {
            addCriterion("incremental_amount <", value, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountLessThanOrEqualTo(Double value) {
            addCriterion("incremental_amount <=", value, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountIn(List<Double> values) {
            addCriterion("incremental_amount in", values, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountNotIn(List<Double> values) {
            addCriterion("incremental_amount not in", values, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountBetween(Double value1, Double value2) {
            addCriterion("incremental_amount between", value1, value2, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andIncrementalAmountNotBetween(Double value1, Double value2) {
            addCriterion("incremental_amount not between", value1, value2, "incrementalAmount");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitIsNull() {
            addCriterion("buy_person_limit is null");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitIsNotNull() {
            addCriterion("buy_person_limit is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitEqualTo(Integer value) {
            addCriterion("buy_person_limit =", value, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitNotEqualTo(Integer value) {
            addCriterion("buy_person_limit <>", value, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitGreaterThan(Integer value) {
            addCriterion("buy_person_limit >", value, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_person_limit >=", value, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitLessThan(Integer value) {
            addCriterion("buy_person_limit <", value, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitLessThanOrEqualTo(Integer value) {
            addCriterion("buy_person_limit <=", value, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitIn(List<Integer> values) {
            addCriterion("buy_person_limit in", values, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitNotIn(List<Integer> values) {
            addCriterion("buy_person_limit not in", values, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitBetween(Integer value1, Integer value2) {
            addCriterion("buy_person_limit between", value1, value2, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andBuyPersonLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_person_limit not between", value1, value2, "buyPersonLimit");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNull() {
            addCriterion("risk_level is null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNotNull() {
            addCriterion("risk_level is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelEqualTo(String value) {
            addCriterion("risk_level =", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotEqualTo(String value) {
            addCriterion("risk_level <>", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThan(String value) {
            addCriterion("risk_level >", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("risk_level >=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThan(String value) {
            addCriterion("risk_level <", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("risk_level <=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLike(String value) {
            addCriterion("risk_level like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotLike(String value) {
            addCriterion("risk_level not like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIn(List<String> values) {
            addCriterion("risk_level in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotIn(List<String> values) {
            addCriterion("risk_level not in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelBetween(String value1, String value2) {
            addCriterion("risk_level between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotBetween(String value1, String value2) {
            addCriterion("risk_level not between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNull() {
            addCriterion("receiver_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("receiver_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdEqualTo(Long value) {
            addCriterion("receiver_id =", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotEqualTo(Long value) {
            addCriterion("receiver_id <>", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThan(Long value) {
            addCriterion("receiver_id >", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_id >=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThan(Long value) {
            addCriterion("receiver_id <", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThanOrEqualTo(Long value) {
            addCriterion("receiver_id <=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIn(List<Long> values) {
            addCriterion("receiver_id in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotIn(List<Long> values) {
            addCriterion("receiver_id not in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdBetween(Long value1, Long value2) {
            addCriterion("receiver_id between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotBetween(Long value1, Long value2) {
            addCriterion("receiver_id not between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIsNull() {
            addCriterion("assistant_id is null");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIsNotNull() {
            addCriterion("assistant_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssistantIdEqualTo(Long value) {
            addCriterion("assistant_id =", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotEqualTo(Long value) {
            addCriterion("assistant_id <>", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdGreaterThan(Long value) {
            addCriterion("assistant_id >", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assistant_id >=", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLessThan(Long value) {
            addCriterion("assistant_id <", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLessThanOrEqualTo(Long value) {
            addCriterion("assistant_id <=", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIn(List<Long> values) {
            addCriterion("assistant_id in", values, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotIn(List<Long> values) {
            addCriterion("assistant_id not in", values, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdBetween(Long value1, Long value2) {
            addCriterion("assistant_id between", value1, value2, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotBetween(Long value1, Long value2) {
            addCriterion("assistant_id not between", value1, value2, "assistantId");
            return (Criteria) this;
        }

        public Criteria andHighlightIsNull() {
            addCriterion("highlight is null");
            return (Criteria) this;
        }

        public Criteria andHighlightIsNotNull() {
            addCriterion("highlight is not null");
            return (Criteria) this;
        }

        public Criteria andHighlightEqualTo(String value) {
            addCriterion("highlight =", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotEqualTo(String value) {
            addCriterion("highlight <>", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightGreaterThan(String value) {
            addCriterion("highlight >", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightGreaterThanOrEqualTo(String value) {
            addCriterion("highlight >=", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightLessThan(String value) {
            addCriterion("highlight <", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightLessThanOrEqualTo(String value) {
            addCriterion("highlight <=", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightLike(String value) {
            addCriterion("highlight like", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotLike(String value) {
            addCriterion("highlight not like", value, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightIn(List<String> values) {
            addCriterion("highlight in", values, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotIn(List<String> values) {
            addCriterion("highlight not in", values, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightBetween(String value1, String value2) {
            addCriterion("highlight between", value1, value2, "highlight");
            return (Criteria) this;
        }

        public Criteria andHighlightNotBetween(String value1, String value2) {
            addCriterion("highlight not between", value1, value2, "highlight");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeIsNull() {
            addCriterion("on_line_time is null");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeIsNotNull() {
            addCriterion("on_line_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeEqualTo(Date value) {
            addCriterion("on_line_time =", value, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeNotEqualTo(Date value) {
            addCriterion("on_line_time <>", value, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeGreaterThan(Date value) {
            addCriterion("on_line_time >", value, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("on_line_time >=", value, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeLessThan(Date value) {
            addCriterion("on_line_time <", value, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeLessThanOrEqualTo(Date value) {
            addCriterion("on_line_time <=", value, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeIn(List<Date> values) {
            addCriterion("on_line_time in", values, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeNotIn(List<Date> values) {
            addCriterion("on_line_time not in", values, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeBetween(Date value1, Date value2) {
            addCriterion("on_line_time between", value1, value2, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andOnLineTimeNotBetween(Date value1, Date value2) {
            addCriterion("on_line_time not between", value1, value2, "onLineTime");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusIsNull() {
            addCriterion("issued_status is null");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusIsNotNull() {
            addCriterion("issued_status is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusEqualTo(Integer value) {
            addCriterion("issued_status =", value, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusNotEqualTo(Integer value) {
            addCriterion("issued_status <>", value, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusGreaterThan(Integer value) {
            addCriterion("issued_status >", value, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("issued_status >=", value, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusLessThan(Integer value) {
            addCriterion("issued_status <", value, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusLessThanOrEqualTo(Integer value) {
            addCriterion("issued_status <=", value, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusIn(List<Integer> values) {
            addCriterion("issued_status in", values, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusNotIn(List<Integer> values) {
            addCriterion("issued_status not in", values, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusBetween(Integer value1, Integer value2) {
            addCriterion("issued_status between", value1, value2, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andIssuedStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("issued_status not between", value1, value2, "issuedStatus");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelIsNull() {
            addCriterion("declaration_model is null");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelIsNotNull() {
            addCriterion("declaration_model is not null");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelEqualTo(Integer value) {
            addCriterion("declaration_model =", value, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelNotEqualTo(Integer value) {
            addCriterion("declaration_model <>", value, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelGreaterThan(Integer value) {
            addCriterion("declaration_model >", value, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("declaration_model >=", value, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelLessThan(Integer value) {
            addCriterion("declaration_model <", value, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelLessThanOrEqualTo(Integer value) {
            addCriterion("declaration_model <=", value, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelIn(List<Integer> values) {
            addCriterion("declaration_model in", values, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelNotIn(List<Integer> values) {
            addCriterion("declaration_model not in", values, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelBetween(Integer value1, Integer value2) {
            addCriterion("declaration_model between", value1, value2, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andDeclarationModelNotBetween(Integer value1, Integer value2) {
            addCriterion("declaration_model not between", value1, value2, "declarationModel");
            return (Criteria) this;
        }

        public Criteria andWxContentIsNull() {
            addCriterion("wx_content is null");
            return (Criteria) this;
        }

        public Criteria andWxContentIsNotNull() {
            addCriterion("wx_content is not null");
            return (Criteria) this;
        }

        public Criteria andWxContentEqualTo(String value) {
            addCriterion("wx_content =", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentNotEqualTo(String value) {
            addCriterion("wx_content <>", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentGreaterThan(String value) {
            addCriterion("wx_content >", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentGreaterThanOrEqualTo(String value) {
            addCriterion("wx_content >=", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentLessThan(String value) {
            addCriterion("wx_content <", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentLessThanOrEqualTo(String value) {
            addCriterion("wx_content <=", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentLike(String value) {
            addCriterion("wx_content like", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentNotLike(String value) {
            addCriterion("wx_content not like", value, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentIn(List<String> values) {
            addCriterion("wx_content in", values, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentNotIn(List<String> values) {
            addCriterion("wx_content not in", values, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentBetween(String value1, String value2) {
            addCriterion("wx_content between", value1, value2, "wxContent");
            return (Criteria) this;
        }

        public Criteria andWxContentNotBetween(String value1, String value2) {
            addCriterion("wx_content not between", value1, value2, "wxContent");
            return (Criteria) this;
        }

        public Criteria andMaturityDateIsNull() {
            addCriterion("maturity_date is null");
            return (Criteria) this;
        }

        public Criteria andMaturityDateIsNotNull() {
            addCriterion("maturity_date is not null");
            return (Criteria) this;
        }

        public Criteria andMaturityDateEqualTo(Date value) {
            addCriterion("maturity_date =", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateNotEqualTo(Date value) {
            addCriterion("maturity_date <>", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateGreaterThan(Date value) {
            addCriterion("maturity_date >", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateGreaterThanOrEqualTo(Date value) {
            addCriterion("maturity_date >=", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateLessThan(Date value) {
            addCriterion("maturity_date <", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateLessThanOrEqualTo(Date value) {
            addCriterion("maturity_date <=", value, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateIn(List<Date> values) {
            addCriterion("maturity_date in", values, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateNotIn(List<Date> values) {
            addCriterion("maturity_date not in", values, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateBetween(Date value1, Date value2) {
            addCriterion("maturity_date between", value1, value2, "maturityDate");
            return (Criteria) this;
        }

        public Criteria andMaturityDateNotBetween(Date value1, Date value2) {
            addCriterion("maturity_date not between", value1, value2, "maturityDate");
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