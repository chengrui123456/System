package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeCompanyExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public NoticeCompanyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
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

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameIsNull() {
            addCriterion("company_username is null");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameIsNotNull() {
            addCriterion("company_username is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameEqualTo(String value) {
            addCriterion("company_username =", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameNotEqualTo(String value) {
            addCriterion("company_username <>", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameGreaterThan(String value) {
            addCriterion("company_username >", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameGreaterThanOrEqualTo(String value) {
            addCriterion("company_username >=", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameLessThan(String value) {
            addCriterion("company_username <", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameLessThanOrEqualTo(String value) {
            addCriterion("company_username <=", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameLike(String value) {
            addCriterion("company_username like", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameNotLike(String value) {
            addCriterion("company_username not like", value, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameIn(List<String> values) {
            addCriterion("company_username in", values, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameNotIn(List<String> values) {
            addCriterion("company_username not in", values, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameBetween(String value1, String value2) {
            addCriterion("company_username between", value1, value2, "company_username");
            return (Criteria) this;
        }

        public Criteria andCompany_usernameNotBetween(String value1, String value2) {
            addCriterion("company_username not between", value1, value2, "company_username");
            return (Criteria) this;
        }

        public Criteria andRelease_dateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andRelease_dateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andRelease_dateEqualTo(Date value) {
            addCriterion("release_date =", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateNotEqualTo(Date value) {
            addCriterion("release_date <>", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateGreaterThan(Date value) {
            addCriterion("release_date >", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("release_date >=", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateLessThan(Date value) {
            addCriterion("release_date <", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateLessThanOrEqualTo(Date value) {
            addCriterion("release_date <=", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateIn(List<Date> values) {
            addCriterion("release_date in", values, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateNotIn(List<Date> values) {
            addCriterion("release_date not in", values, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateBetween(Date value1, Date value2) {
            addCriterion("release_date between", value1, value2, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateNotBetween(Date value1, Date value2) {
            addCriterion("release_date not between", value1, value2, "release_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateIsNull() {
            addCriterion("audit_date is null");
            return (Criteria) this;
        }

        public Criteria andAudit_dateIsNotNull() {
            addCriterion("audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andAudit_dateEqualTo(Date value) {
            addCriterion("audit_date =", value, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateNotEqualTo(Date value) {
            addCriterion("audit_date <>", value, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateGreaterThan(Date value) {
            addCriterion("audit_date >", value, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_date >=", value, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateLessThan(Date value) {
            addCriterion("audit_date <", value, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateLessThanOrEqualTo(Date value) {
            addCriterion("audit_date <=", value, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateIn(List<Date> values) {
            addCriterion("audit_date in", values, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateNotIn(List<Date> values) {
            addCriterion("audit_date not in", values, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateBetween(Date value1, Date value2) {
            addCriterion("audit_date between", value1, value2, "audit_date");
            return (Criteria) this;
        }

        public Criteria andAudit_dateNotBetween(Date value1, Date value2) {
            addCriterion("audit_date not between", value1, value2, "audit_date");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table notice_company
     *
     * @mbg.generated do_not_delete_during_merge Tue Sep 10 16:29:23 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table notice_company
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
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