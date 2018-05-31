package com.zjingwen.szptcoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class PersonalInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonalInfoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNull() {
            addCriterion("stuNum is null");
            return (Criteria) this;
        }

        public Criteria andStuNumIsNotNull() {
            addCriterion("stuNum is not null");
            return (Criteria) this;
        }

        public Criteria andStuNumEqualTo(Integer value) {
            addCriterion("stuNum =", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotEqualTo(Integer value) {
            addCriterion("stuNum <>", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThan(Integer value) {
            addCriterion("stuNum >", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuNum >=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThan(Integer value) {
            addCriterion("stuNum <", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumLessThanOrEqualTo(Integer value) {
            addCriterion("stuNum <=", value, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumIn(List<Integer> values) {
            addCriterion("stuNum in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotIn(List<Integer> values) {
            addCriterion("stuNum not in", values, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumBetween(Integer value1, Integer value2) {
            addCriterion("stuNum between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuNumNotBetween(Integer value1, Integer value2) {
            addCriterion("stuNum not between", value1, value2, "stuNum");
            return (Criteria) this;
        }

        public Criteria andStuPassIsNull() {
            addCriterion("stuPass is null");
            return (Criteria) this;
        }

        public Criteria andStuPassIsNotNull() {
            addCriterion("stuPass is not null");
            return (Criteria) this;
        }

        public Criteria andStuPassEqualTo(String value) {
            addCriterion("stuPass =", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotEqualTo(String value) {
            addCriterion("stuPass <>", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassGreaterThan(String value) {
            addCriterion("stuPass >", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassGreaterThanOrEqualTo(String value) {
            addCriterion("stuPass >=", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassLessThan(String value) {
            addCriterion("stuPass <", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassLessThanOrEqualTo(String value) {
            addCriterion("stuPass <=", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassLike(String value) {
            addCriterion("stuPass like", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotLike(String value) {
            addCriterion("stuPass not like", value, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassIn(List<String> values) {
            addCriterion("stuPass in", values, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotIn(List<String> values) {
            addCriterion("stuPass not in", values, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassBetween(String value1, String value2) {
            addCriterion("stuPass between", value1, value2, "stuPass");
            return (Criteria) this;
        }

        public Criteria andStuPassNotBetween(String value1, String value2) {
            addCriterion("stuPass not between", value1, value2, "stuPass");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("uId is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("uId is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("uId =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("uId <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("uId >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("uId >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("uId <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("uId <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("uId in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("uId not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("uId between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("uId not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andMIdIsNull() {
            addCriterion("mId is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("mId is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("mId =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("mId <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("mId >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mId >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("mId <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("mId <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("mId in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("mId not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("mId between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mId not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andAIdIsNull() {
            addCriterion("aId is null");
            return (Criteria) this;
        }

        public Criteria andAIdIsNotNull() {
            addCriterion("aId is not null");
            return (Criteria) this;
        }

        public Criteria andAIdEqualTo(Integer value) {
            addCriterion("aId =", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotEqualTo(Integer value) {
            addCriterion("aId <>", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThan(Integer value) {
            addCriterion("aId >", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("aId >=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThan(Integer value) {
            addCriterion("aId <", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdLessThanOrEqualTo(Integer value) {
            addCriterion("aId <=", value, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdIn(List<Integer> values) {
            addCriterion("aId in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotIn(List<Integer> values) {
            addCriterion("aId not in", values, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdBetween(Integer value1, Integer value2) {
            addCriterion("aId between", value1, value2, "aId");
            return (Criteria) this;
        }

        public Criteria andAIdNotBetween(Integer value1, Integer value2) {
            addCriterion("aId not between", value1, value2, "aId");
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

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
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