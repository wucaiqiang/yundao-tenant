package com.yundao.tenant.model.base.customer;

import com.yundao.core.utils.Limit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseUpdateLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = 0;

    protected int limitEnd = 0;

    protected Limit limit;

    public BaseUpdateLogExample() {
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

    public BaseUpdateLogExample setLimit(Limit limit) {
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

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(Long value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(Long value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(Long value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(Long value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<Long> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<Long> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(Long value1, Long value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andUpdateItemIsNull() {
            addCriterion("update_item is null");
            return (Criteria) this;
        }

        public Criteria andUpdateItemIsNotNull() {
            addCriterion("update_item is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateItemEqualTo(String value) {
            addCriterion("update_item =", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemNotEqualTo(String value) {
            addCriterion("update_item <>", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemGreaterThan(String value) {
            addCriterion("update_item >", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemGreaterThanOrEqualTo(String value) {
            addCriterion("update_item >=", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemLessThan(String value) {
            addCriterion("update_item <", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemLessThanOrEqualTo(String value) {
            addCriterion("update_item <=", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemLike(String value) {
            addCriterion("update_item like", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemNotLike(String value) {
            addCriterion("update_item not like", value, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemIn(List<String> values) {
            addCriterion("update_item in", values, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemNotIn(List<String> values) {
            addCriterion("update_item not in", values, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemBetween(String value1, String value2) {
            addCriterion("update_item between", value1, value2, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateItemNotBetween(String value1, String value2) {
            addCriterion("update_item not between", value1, value2, "updateItem");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentIsNull() {
            addCriterion("update_before_content is null");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentIsNotNull() {
            addCriterion("update_before_content is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentEqualTo(String value) {
            addCriterion("update_before_content =", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentNotEqualTo(String value) {
            addCriterion("update_before_content <>", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentGreaterThan(String value) {
            addCriterion("update_before_content >", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentGreaterThanOrEqualTo(String value) {
            addCriterion("update_before_content >=", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentLessThan(String value) {
            addCriterion("update_before_content <", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentLessThanOrEqualTo(String value) {
            addCriterion("update_before_content <=", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentLike(String value) {
            addCriterion("update_before_content like", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentNotLike(String value) {
            addCriterion("update_before_content not like", value, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentIn(List<String> values) {
            addCriterion("update_before_content in", values, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentNotIn(List<String> values) {
            addCriterion("update_before_content not in", values, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentBetween(String value1, String value2) {
            addCriterion("update_before_content between", value1, value2, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateBeforeContentNotBetween(String value1, String value2) {
            addCriterion("update_before_content not between", value1, value2, "updateBeforeContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentIsNull() {
            addCriterion("update_after_content is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentIsNotNull() {
            addCriterion("update_after_content is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentEqualTo(String value) {
            addCriterion("update_after_content =", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentNotEqualTo(String value) {
            addCriterion("update_after_content <>", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentGreaterThan(String value) {
            addCriterion("update_after_content >", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentGreaterThanOrEqualTo(String value) {
            addCriterion("update_after_content >=", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentLessThan(String value) {
            addCriterion("update_after_content <", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentLessThanOrEqualTo(String value) {
            addCriterion("update_after_content <=", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentLike(String value) {
            addCriterion("update_after_content like", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentNotLike(String value) {
            addCriterion("update_after_content not like", value, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentIn(List<String> values) {
            addCriterion("update_after_content in", values, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentNotIn(List<String> values) {
            addCriterion("update_after_content not in", values, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentBetween(String value1, String value2) {
            addCriterion("update_after_content between", value1, value2, "updateAfterContent");
            return (Criteria) this;
        }

        public Criteria andUpdateAfterContentNotBetween(String value1, String value2) {
            addCriterion("update_after_content not between", value1, value2, "updateAfterContent");
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

        public Criteria andClientIsNull() {
            addCriterion("client is null");
            return (Criteria) this;
        }

        public Criteria andClientIsNotNull() {
            addCriterion("client is not null");
            return (Criteria) this;
        }

        public Criteria andClientEqualTo(String value) {
            addCriterion("client =", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotEqualTo(String value) {
            addCriterion("client <>", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThan(String value) {
            addCriterion("client >", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientGreaterThanOrEqualTo(String value) {
            addCriterion("client >=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThan(String value) {
            addCriterion("client <", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLessThanOrEqualTo(String value) {
            addCriterion("client <=", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientLike(String value) {
            addCriterion("client like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotLike(String value) {
            addCriterion("client not like", value, "client");
            return (Criteria) this;
        }

        public Criteria andClientIn(List<String> values) {
            addCriterion("client in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotIn(List<String> values) {
            addCriterion("client not in", values, "client");
            return (Criteria) this;
        }

        public Criteria andClientBetween(String value1, String value2) {
            addCriterion("client between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andClientNotBetween(String value1, String value2) {
            addCriterion("client not between", value1, value2, "client");
            return (Criteria) this;
        }

        public Criteria andClolumnNameIsNull() {
            addCriterion("clolumn_name is null");
            return (Criteria) this;
        }

        public Criteria andClolumnNameIsNotNull() {
            addCriterion("clolumn_name is not null");
            return (Criteria) this;
        }

        public Criteria andClolumnNameEqualTo(String value) {
            addCriterion("clolumn_name =", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameNotEqualTo(String value) {
            addCriterion("clolumn_name <>", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameGreaterThan(String value) {
            addCriterion("clolumn_name >", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("clolumn_name >=", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameLessThan(String value) {
            addCriterion("clolumn_name <", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameLessThanOrEqualTo(String value) {
            addCriterion("clolumn_name <=", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameLike(String value) {
            addCriterion("clolumn_name like", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameNotLike(String value) {
            addCriterion("clolumn_name not like", value, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameIn(List<String> values) {
            addCriterion("clolumn_name in", values, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameNotIn(List<String> values) {
            addCriterion("clolumn_name not in", values, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameBetween(String value1, String value2) {
            addCriterion("clolumn_name between", value1, value2, "clolumnName");
            return (Criteria) this;
        }

        public Criteria andClolumnNameNotBetween(String value1, String value2) {
            addCriterion("clolumn_name not between", value1, value2, "clolumnName");
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