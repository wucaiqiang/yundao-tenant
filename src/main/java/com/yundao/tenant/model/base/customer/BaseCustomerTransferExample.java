package com.yundao.tenant.model.base.customer;

import com.yundao.core.utils.Limit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseCustomerTransferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = 0;

    protected int limitEnd = 0;

    protected Limit limit;

    public BaseCustomerTransferExample() {
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

    public BaseCustomerTransferExample setLimit(Limit limit) {
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIsNull() {
            addCriterion("after_user is null");
            return (Criteria) this;
        }

        public Criteria andAfterUserIsNotNull() {
            addCriterion("after_user is not null");
            return (Criteria) this;
        }

        public Criteria andAfterUserEqualTo(String value) {
            addCriterion("after_user =", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotEqualTo(String value) {
            addCriterion("after_user <>", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserGreaterThan(String value) {
            addCriterion("after_user >", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserGreaterThanOrEqualTo(String value) {
            addCriterion("after_user >=", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserLessThan(String value) {
            addCriterion("after_user <", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserLessThanOrEqualTo(String value) {
            addCriterion("after_user <=", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserLike(String value) {
            addCriterion("after_user like", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotLike(String value) {
            addCriterion("after_user not like", value, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserIn(List<String> values) {
            addCriterion("after_user in", values, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotIn(List<String> values) {
            addCriterion("after_user not in", values, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserBetween(String value1, String value2) {
            addCriterion("after_user between", value1, value2, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserNotBetween(String value1, String value2) {
            addCriterion("after_user not between", value1, value2, "afterUser");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdIsNull() {
            addCriterion("after_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdIsNotNull() {
            addCriterion("after_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdEqualTo(Long value) {
            addCriterion("after_user_id =", value, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdNotEqualTo(Long value) {
            addCriterion("after_user_id <>", value, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdGreaterThan(Long value) {
            addCriterion("after_user_id >", value, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("after_user_id >=", value, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdLessThan(Long value) {
            addCriterion("after_user_id <", value, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdLessThanOrEqualTo(Long value) {
            addCriterion("after_user_id <=", value, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdIn(List<Long> values) {
            addCriterion("after_user_id in", values, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdNotIn(List<Long> values) {
            addCriterion("after_user_id not in", values, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdBetween(Long value1, Long value2) {
            addCriterion("after_user_id between", value1, value2, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andAfterUserIdNotBetween(Long value1, Long value2) {
            addCriterion("after_user_id not between", value1, value2, "afterUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIsNull() {
            addCriterion("before_user is null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIsNotNull() {
            addCriterion("before_user is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserEqualTo(String value) {
            addCriterion("before_user =", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotEqualTo(String value) {
            addCriterion("before_user <>", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserGreaterThan(String value) {
            addCriterion("before_user >", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserGreaterThanOrEqualTo(String value) {
            addCriterion("before_user >=", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserLessThan(String value) {
            addCriterion("before_user <", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserLessThanOrEqualTo(String value) {
            addCriterion("before_user <=", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserLike(String value) {
            addCriterion("before_user like", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotLike(String value) {
            addCriterion("before_user not like", value, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIn(List<String> values) {
            addCriterion("before_user in", values, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotIn(List<String> values) {
            addCriterion("before_user not in", values, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserBetween(String value1, String value2) {
            addCriterion("before_user between", value1, value2, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserNotBetween(String value1, String value2) {
            addCriterion("before_user not between", value1, value2, "beforeUser");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdIsNull() {
            addCriterion("before_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdIsNotNull() {
            addCriterion("before_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdEqualTo(Long value) {
            addCriterion("before_user_id =", value, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdNotEqualTo(Long value) {
            addCriterion("before_user_id <>", value, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdGreaterThan(Long value) {
            addCriterion("before_user_id >", value, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("before_user_id >=", value, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdLessThan(Long value) {
            addCriterion("before_user_id <", value, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdLessThanOrEqualTo(Long value) {
            addCriterion("before_user_id <=", value, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdIn(List<Long> values) {
            addCriterion("before_user_id in", values, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdNotIn(List<Long> values) {
            addCriterion("before_user_id not in", values, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdBetween(Long value1, Long value2) {
            addCriterion("before_user_id between", value1, value2, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andBeforeUserIdNotBetween(Long value1, Long value2) {
            addCriterion("before_user_id not between", value1, value2, "beforeUserId");
            return (Criteria) this;
        }

        public Criteria andTransferDateIsNull() {
            addCriterion("transfer_date is null");
            return (Criteria) this;
        }

        public Criteria andTransferDateIsNotNull() {
            addCriterion("transfer_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransferDateEqualTo(Date value) {
            addCriterion("transfer_date =", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotEqualTo(Date value) {
            addCriterion("transfer_date <>", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateGreaterThan(Date value) {
            addCriterion("transfer_date >", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateGreaterThanOrEqualTo(Date value) {
            addCriterion("transfer_date >=", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLessThan(Date value) {
            addCriterion("transfer_date <", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLessThanOrEqualTo(Date value) {
            addCriterion("transfer_date <=", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateIn(List<Date> values) {
            addCriterion("transfer_date in", values, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotIn(List<Date> values) {
            addCriterion("transfer_date not in", values, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateBetween(Date value1, Date value2) {
            addCriterion("transfer_date between", value1, value2, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotBetween(Date value1, Date value2) {
            addCriterion("transfer_date not between", value1, value2, "transferDate");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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