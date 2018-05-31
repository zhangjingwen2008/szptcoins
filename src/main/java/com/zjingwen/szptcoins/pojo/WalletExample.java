package com.zjingwen.szptcoins.pojo;

import java.util.ArrayList;
import java.util.List;

public class WalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletExample() {
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

        public Criteria andPublicKeyIsNull() {
            addCriterion("publicKey is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNotNull() {
            addCriterion("publicKey is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyEqualTo(String value) {
            addCriterion("publicKey =", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotEqualTo(String value) {
            addCriterion("publicKey <>", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThan(String value) {
            addCriterion("publicKey >", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("publicKey >=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThan(String value) {
            addCriterion("publicKey <", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("publicKey <=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLike(String value) {
            addCriterion("publicKey like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotLike(String value) {
            addCriterion("publicKey not like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIn(List<String> values) {
            addCriterion("publicKey in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotIn(List<String> values) {
            addCriterion("publicKey not in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyBetween(String value1, String value2) {
            addCriterion("publicKey between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotBetween(String value1, String value2) {
            addCriterion("publicKey not between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNull() {
            addCriterion("privateKey is null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNotNull() {
            addCriterion("privateKey is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyEqualTo(String value) {
            addCriterion("privateKey =", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotEqualTo(String value) {
            addCriterion("privateKey <>", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThan(String value) {
            addCriterion("privateKey >", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("privateKey >=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThan(String value) {
            addCriterion("privateKey <", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("privateKey <=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLike(String value) {
            addCriterion("privateKey like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotLike(String value) {
            addCriterion("privateKey not like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIn(List<String> values) {
            addCriterion("privateKey in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotIn(List<String> values) {
            addCriterion("privateKey not in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyBetween(String value1, String value2) {
            addCriterion("privateKey between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("privateKey not between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andWifIsNull() {
            addCriterion("wif is null");
            return (Criteria) this;
        }

        public Criteria andWifIsNotNull() {
            addCriterion("wif is not null");
            return (Criteria) this;
        }

        public Criteria andWifEqualTo(String value) {
            addCriterion("wif =", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifNotEqualTo(String value) {
            addCriterion("wif <>", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifGreaterThan(String value) {
            addCriterion("wif >", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifGreaterThanOrEqualTo(String value) {
            addCriterion("wif >=", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifLessThan(String value) {
            addCriterion("wif <", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifLessThanOrEqualTo(String value) {
            addCriterion("wif <=", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifLike(String value) {
            addCriterion("wif like", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifNotLike(String value) {
            addCriterion("wif not like", value, "wif");
            return (Criteria) this;
        }

        public Criteria andWifIn(List<String> values) {
            addCriterion("wif in", values, "wif");
            return (Criteria) this;
        }

        public Criteria andWifNotIn(List<String> values) {
            addCriterion("wif not in", values, "wif");
            return (Criteria) this;
        }

        public Criteria andWifBetween(String value1, String value2) {
            addCriterion("wif between", value1, value2, "wif");
            return (Criteria) this;
        }

        public Criteria andWifNotBetween(String value1, String value2) {
            addCriterion("wif not between", value1, value2, "wif");
            return (Criteria) this;
        }

        public Criteria andWifCompressedIsNull() {
            addCriterion("wifCompressed is null");
            return (Criteria) this;
        }

        public Criteria andWifCompressedIsNotNull() {
            addCriterion("wifCompressed is not null");
            return (Criteria) this;
        }

        public Criteria andWifCompressedEqualTo(String value) {
            addCriterion("wifCompressed =", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedNotEqualTo(String value) {
            addCriterion("wifCompressed <>", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedGreaterThan(String value) {
            addCriterion("wifCompressed >", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedGreaterThanOrEqualTo(String value) {
            addCriterion("wifCompressed >=", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedLessThan(String value) {
            addCriterion("wifCompressed <", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedLessThanOrEqualTo(String value) {
            addCriterion("wifCompressed <=", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedLike(String value) {
            addCriterion("wifCompressed like", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedNotLike(String value) {
            addCriterion("wifCompressed not like", value, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedIn(List<String> values) {
            addCriterion("wifCompressed in", values, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedNotIn(List<String> values) {
            addCriterion("wifCompressed not in", values, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedBetween(String value1, String value2) {
            addCriterion("wifCompressed between", value1, value2, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andWifCompressedNotBetween(String value1, String value2) {
            addCriterion("wifCompressed not between", value1, value2, "wifCompressed");
            return (Criteria) this;
        }

        public Criteria andBase58IsNull() {
            addCriterion("base58 is null");
            return (Criteria) this;
        }

        public Criteria andBase58IsNotNull() {
            addCriterion("base58 is not null");
            return (Criteria) this;
        }

        public Criteria andBase58EqualTo(String value) {
            addCriterion("base58 =", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58NotEqualTo(String value) {
            addCriterion("base58 <>", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58GreaterThan(String value) {
            addCriterion("base58 >", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58GreaterThanOrEqualTo(String value) {
            addCriterion("base58 >=", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58LessThan(String value) {
            addCriterion("base58 <", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58LessThanOrEqualTo(String value) {
            addCriterion("base58 <=", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58Like(String value) {
            addCriterion("base58 like", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58NotLike(String value) {
            addCriterion("base58 not like", value, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58In(List<String> values) {
            addCriterion("base58 in", values, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58NotIn(List<String> values) {
            addCriterion("base58 not in", values, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58Between(String value1, String value2) {
            addCriterion("base58 between", value1, value2, "base58");
            return (Criteria) this;
        }

        public Criteria andBase58NotBetween(String value1, String value2) {
            addCriterion("base58 not between", value1, value2, "base58");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andHash160IsNull() {
            addCriterion("hash160 is null");
            return (Criteria) this;
        }

        public Criteria andHash160IsNotNull() {
            addCriterion("hash160 is not null");
            return (Criteria) this;
        }

        public Criteria andHash160EqualTo(String value) {
            addCriterion("hash160 =", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160NotEqualTo(String value) {
            addCriterion("hash160 <>", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160GreaterThan(String value) {
            addCriterion("hash160 >", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160GreaterThanOrEqualTo(String value) {
            addCriterion("hash160 >=", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160LessThan(String value) {
            addCriterion("hash160 <", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160LessThanOrEqualTo(String value) {
            addCriterion("hash160 <=", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160Like(String value) {
            addCriterion("hash160 like", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160NotLike(String value) {
            addCriterion("hash160 not like", value, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160In(List<String> values) {
            addCriterion("hash160 in", values, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160NotIn(List<String> values) {
            addCriterion("hash160 not in", values, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160Between(String value1, String value2) {
            addCriterion("hash160 between", value1, value2, "hash160");
            return (Criteria) this;
        }

        public Criteria andHash160NotBetween(String value1, String value2) {
            addCriterion("hash160 not between", value1, value2, "hash160");
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