package com.yundao.tenant.model.base;

import com.yundao.core.utils.Limit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseObjectFieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = 0;

    protected int limitEnd = 0;

    protected Limit limit;

    public BaseObjectFieldExample() {
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

    public BaseObjectFieldExample setLimit(Limit limit) {
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

        public Criteria andFieldIdIsNull() {
            addCriterion("field_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("field_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(Long value) {
            addCriterion("field_id =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(Long value) {
            addCriterion("field_id <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(Long value) {
            addCriterion("field_id >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(Long value) {
            addCriterion("field_id >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(Long value) {
            addCriterion("field_id <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(Long value) {
            addCriterion("field_id <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<Long> values) {
            addCriterion("field_id in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<Long> values) {
            addCriterion("field_id not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(Long value1, Long value2) {
            addCriterion("field_id between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(Long value1, Long value2) {
            addCriterion("field_id not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdIsNull() {
            addCriterion("business_object_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdIsNotNull() {
            addCriterion("business_object_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdEqualTo(Long value) {
            addCriterion("business_object_id =", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdNotEqualTo(Long value) {
            addCriterion("business_object_id <>", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdGreaterThan(Long value) {
            addCriterion("business_object_id >", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_object_id >=", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdLessThan(Long value) {
            addCriterion("business_object_id <", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdLessThanOrEqualTo(Long value) {
            addCriterion("business_object_id <=", value, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdIn(List<Long> values) {
            addCriterion("business_object_id in", values, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdNotIn(List<Long> values) {
            addCriterion("business_object_id not in", values, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdBetween(Long value1, Long value2) {
            addCriterion("business_object_id between", value1, value2, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andBusinessObjectIdNotBetween(Long value1, Long value2) {
            addCriterion("business_object_id not between", value1, value2, "businessObjectId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdIsNull() {
            addCriterion("field_type_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdIsNotNull() {
            addCriterion("field_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdEqualTo(Long value) {
            addCriterion("field_type_id =", value, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdNotEqualTo(Long value) {
            addCriterion("field_type_id <>", value, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdGreaterThan(Long value) {
            addCriterion("field_type_id >", value, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("field_type_id >=", value, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdLessThan(Long value) {
            addCriterion("field_type_id <", value, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("field_type_id <=", value, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdIn(List<Long> values) {
            addCriterion("field_type_id in", values, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdNotIn(List<Long> values) {
            addCriterion("field_type_id not in", values, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdBetween(Long value1, Long value2) {
            addCriterion("field_type_id between", value1, value2, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andFieldTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("field_type_id not between", value1, value2, "fieldTypeId");
            return (Criteria) this;
        }

        public Criteria andIsFixIsNull() {
            addCriterion("is_fix is null");
            return (Criteria) this;
        }

        public Criteria andIsFixIsNotNull() {
            addCriterion("is_fix is not null");
            return (Criteria) this;
        }

        public Criteria andIsFixEqualTo(Integer value) {
            addCriterion("is_fix =", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixNotEqualTo(Integer value) {
            addCriterion("is_fix <>", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixGreaterThan(Integer value) {
            addCriterion("is_fix >", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_fix >=", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixLessThan(Integer value) {
            addCriterion("is_fix <", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixLessThanOrEqualTo(Integer value) {
            addCriterion("is_fix <=", value, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixIn(List<Integer> values) {
            addCriterion("is_fix in", values, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixNotIn(List<Integer> values) {
            addCriterion("is_fix not in", values, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixBetween(Integer value1, Integer value2) {
            addCriterion("is_fix between", value1, value2, "isFix");
            return (Criteria) this;
        }

        public Criteria andIsFixNotBetween(Integer value1, Integer value2) {
            addCriterion("is_fix not between", value1, value2, "isFix");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeIsNull() {
            addCriterion("display_type is null");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeIsNotNull() {
            addCriterion("display_type is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeEqualTo(Integer value) {
            addCriterion("display_type =", value, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeNotEqualTo(Integer value) {
            addCriterion("display_type <>", value, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeGreaterThan(Integer value) {
            addCriterion("display_type >", value, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_type >=", value, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeLessThan(Integer value) {
            addCriterion("display_type <", value, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("display_type <=", value, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeIn(List<Integer> values) {
            addCriterion("display_type in", values, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeNotIn(List<Integer> values) {
            addCriterion("display_type not in", values, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeBetween(Integer value1, Integer value2) {
            addCriterion("display_type between", value1, value2, "displayType");
            return (Criteria) this;
        }

        public Criteria andDisplayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("display_type not between", value1, value2, "displayType");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryIsNull() {
            addCriterion("is_mandatory is null");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryIsNotNull() {
            addCriterion("is_mandatory is not null");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryEqualTo(Integer value) {
            addCriterion("is_mandatory =", value, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryNotEqualTo(Integer value) {
            addCriterion("is_mandatory <>", value, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryGreaterThan(Integer value) {
            addCriterion("is_mandatory >", value, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_mandatory >=", value, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryLessThan(Integer value) {
            addCriterion("is_mandatory <", value, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryLessThanOrEqualTo(Integer value) {
            addCriterion("is_mandatory <=", value, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryIn(List<Integer> values) {
            addCriterion("is_mandatory in", values, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryNotIn(List<Integer> values) {
            addCriterion("is_mandatory not in", values, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryBetween(Integer value1, Integer value2) {
            addCriterion("is_mandatory between", value1, value2, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsMandatoryNotBetween(Integer value1, Integer value2) {
            addCriterion("is_mandatory not between", value1, value2, "isMandatory");
            return (Criteria) this;
        }

        public Criteria andIsBasicIsNull() {
            addCriterion("is_basic is null");
            return (Criteria) this;
        }

        public Criteria andIsBasicIsNotNull() {
            addCriterion("is_basic is not null");
            return (Criteria) this;
        }

        public Criteria andIsBasicEqualTo(Integer value) {
            addCriterion("is_basic =", value, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicNotEqualTo(Integer value) {
            addCriterion("is_basic <>", value, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicGreaterThan(Integer value) {
            addCriterion("is_basic >", value, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_basic >=", value, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicLessThan(Integer value) {
            addCriterion("is_basic <", value, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicLessThanOrEqualTo(Integer value) {
            addCriterion("is_basic <=", value, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicIn(List<Integer> values) {
            addCriterion("is_basic in", values, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicNotIn(List<Integer> values) {
            addCriterion("is_basic not in", values, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicBetween(Integer value1, Integer value2) {
            addCriterion("is_basic between", value1, value2, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsBasicNotBetween(Integer value1, Integer value2) {
            addCriterion("is_basic not between", value1, value2, "isBasic");
            return (Criteria) this;
        }

        public Criteria andIsShareIsNull() {
            addCriterion("is_share is null");
            return (Criteria) this;
        }

        public Criteria andIsShareIsNotNull() {
            addCriterion("is_share is not null");
            return (Criteria) this;
        }

        public Criteria andIsShareEqualTo(Integer value) {
            addCriterion("is_share =", value, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareNotEqualTo(Integer value) {
            addCriterion("is_share <>", value, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareGreaterThan(Integer value) {
            addCriterion("is_share >", value, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_share >=", value, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareLessThan(Integer value) {
            addCriterion("is_share <", value, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareLessThanOrEqualTo(Integer value) {
            addCriterion("is_share <=", value, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareIn(List<Integer> values) {
            addCriterion("is_share in", values, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareNotIn(List<Integer> values) {
            addCriterion("is_share not in", values, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareBetween(Integer value1, Integer value2) {
            addCriterion("is_share between", value1, value2, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsShareNotBetween(Integer value1, Integer value2) {
            addCriterion("is_share not between", value1, value2, "isShare");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNull() {
            addCriterion("is_system is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemIsNotNull() {
            addCriterion("is_system is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemEqualTo(Integer value) {
            addCriterion("is_system =", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotEqualTo(Integer value) {
            addCriterion("is_system <>", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThan(Integer value) {
            addCriterion("is_system >", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_system >=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThan(Integer value) {
            addCriterion("is_system <", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemLessThanOrEqualTo(Integer value) {
            addCriterion("is_system <=", value, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemIn(List<Integer> values) {
            addCriterion("is_system in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotIn(List<Integer> values) {
            addCriterion("is_system not in", values, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemBetween(Integer value1, Integer value2) {
            addCriterion("is_system between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSystemNotBetween(Integer value1, Integer value2) {
            addCriterion("is_system not between", value1, value2, "isSystem");
            return (Criteria) this;
        }

        public Criteria andIsSearchIsNull() {
            addCriterion("is_search is null");
            return (Criteria) this;
        }

        public Criteria andIsSearchIsNotNull() {
            addCriterion("is_search is not null");
            return (Criteria) this;
        }

        public Criteria andIsSearchEqualTo(Integer value) {
            addCriterion("is_search =", value, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchNotEqualTo(Integer value) {
            addCriterion("is_search <>", value, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchGreaterThan(Integer value) {
            addCriterion("is_search >", value, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_search >=", value, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchLessThan(Integer value) {
            addCriterion("is_search <", value, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchLessThanOrEqualTo(Integer value) {
            addCriterion("is_search <=", value, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchIn(List<Integer> values) {
            addCriterion("is_search in", values, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchNotIn(List<Integer> values) {
            addCriterion("is_search not in", values, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchBetween(Integer value1, Integer value2) {
            addCriterion("is_search between", value1, value2, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsSearchNotBetween(Integer value1, Integer value2) {
            addCriterion("is_search not between", value1, value2, "isSearch");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyIsNull() {
            addCriterion("is_readonly is null");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyIsNotNull() {
            addCriterion("is_readonly is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyEqualTo(Integer value) {
            addCriterion("is_readonly =", value, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyNotEqualTo(Integer value) {
            addCriterion("is_readonly <>", value, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyGreaterThan(Integer value) {
            addCriterion("is_readonly >", value, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_readonly >=", value, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyLessThan(Integer value) {
            addCriterion("is_readonly <", value, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyLessThanOrEqualTo(Integer value) {
            addCriterion("is_readonly <=", value, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyIn(List<Integer> values) {
            addCriterion("is_readonly in", values, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyNotIn(List<Integer> values) {
            addCriterion("is_readonly not in", values, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyBetween(Integer value1, Integer value2) {
            addCriterion("is_readonly between", value1, value2, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsReadonlyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_readonly not between", value1, value2, "isReadonly");
            return (Criteria) this;
        }

        public Criteria andIsInitIsNull() {
            addCriterion("is_init is null");
            return (Criteria) this;
        }

        public Criteria andIsInitIsNotNull() {
            addCriterion("is_init is not null");
            return (Criteria) this;
        }

        public Criteria andIsInitEqualTo(Integer value) {
            addCriterion("is_init =", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotEqualTo(Integer value) {
            addCriterion("is_init <>", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitGreaterThan(Integer value) {
            addCriterion("is_init >", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_init >=", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitLessThan(Integer value) {
            addCriterion("is_init <", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitLessThanOrEqualTo(Integer value) {
            addCriterion("is_init <=", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitIn(List<Integer> values) {
            addCriterion("is_init in", values, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotIn(List<Integer> values) {
            addCriterion("is_init not in", values, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitBetween(Integer value1, Integer value2) {
            addCriterion("is_init between", value1, value2, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotBetween(Integer value1, Integer value2) {
            addCriterion("is_init not between", value1, value2, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Integer value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Integer value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Integer value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Integer value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Integer> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Integer> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Integer value1, Integer value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryIsNull() {
            addCriterion("can_edit_mandatory is null");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryIsNotNull() {
            addCriterion("can_edit_mandatory is not null");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryEqualTo(Integer value) {
            addCriterion("can_edit_mandatory =", value, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryNotEqualTo(Integer value) {
            addCriterion("can_edit_mandatory <>", value, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryGreaterThan(Integer value) {
            addCriterion("can_edit_mandatory >", value, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_edit_mandatory >=", value, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryLessThan(Integer value) {
            addCriterion("can_edit_mandatory <", value, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryLessThanOrEqualTo(Integer value) {
            addCriterion("can_edit_mandatory <=", value, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryIn(List<Integer> values) {
            addCriterion("can_edit_mandatory in", values, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryNotIn(List<Integer> values) {
            addCriterion("can_edit_mandatory not in", values, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryBetween(Integer value1, Integer value2) {
            addCriterion("can_edit_mandatory between", value1, value2, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditMandatoryNotBetween(Integer value1, Integer value2) {
            addCriterion("can_edit_mandatory not between", value1, value2, "canEditMandatory");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledIsNull() {
            addCriterion("can_edit_enabled is null");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledIsNotNull() {
            addCriterion("can_edit_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledEqualTo(Integer value) {
            addCriterion("can_edit_enabled =", value, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledNotEqualTo(Integer value) {
            addCriterion("can_edit_enabled <>", value, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledGreaterThan(Integer value) {
            addCriterion("can_edit_enabled >", value, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_edit_enabled >=", value, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledLessThan(Integer value) {
            addCriterion("can_edit_enabled <", value, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("can_edit_enabled <=", value, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledIn(List<Integer> values) {
            addCriterion("can_edit_enabled in", values, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledNotIn(List<Integer> values) {
            addCriterion("can_edit_enabled not in", values, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledBetween(Integer value1, Integer value2) {
            addCriterion("can_edit_enabled between", value1, value2, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andCanEditEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("can_edit_enabled not between", value1, value2, "canEditEnabled");
            return (Criteria) this;
        }

        public Criteria andAccessIsNull() {
            addCriterion("access is null");
            return (Criteria) this;
        }

        public Criteria andAccessIsNotNull() {
            addCriterion("access is not null");
            return (Criteria) this;
        }

        public Criteria andAccessEqualTo(Integer value) {
            addCriterion("access =", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotEqualTo(Integer value) {
            addCriterion("access <>", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessGreaterThan(Integer value) {
            addCriterion("access >", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("access >=", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessLessThan(Integer value) {
            addCriterion("access <", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessLessThanOrEqualTo(Integer value) {
            addCriterion("access <=", value, "access");
            return (Criteria) this;
        }

        public Criteria andAccessIn(List<Integer> values) {
            addCriterion("access in", values, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotIn(List<Integer> values) {
            addCriterion("access not in", values, "access");
            return (Criteria) this;
        }

        public Criteria andAccessBetween(Integer value1, Integer value2) {
            addCriterion("access between", value1, value2, "access");
            return (Criteria) this;
        }

        public Criteria andAccessNotBetween(Integer value1, Integer value2) {
            addCriterion("access not between", value1, value2, "access");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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