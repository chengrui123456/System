package com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectSelectExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public ProjectSelectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
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
     * This method corresponds to the database table project_select
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
     * This method corresponds to the database table project_select
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_select
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
     * This class corresponds to the database table project_select
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

        public Criteria andStudentNoIsNull() {
            addCriterion("studentNo is null");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNotNull() {
            addCriterion("studentNo is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNoEqualTo(String value) {
            addCriterion("studentNo =", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotEqualTo(String value) {
            addCriterion("studentNo <>", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThan(String value) {
            addCriterion("studentNo >", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("studentNo >=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThan(String value) {
            addCriterion("studentNo <", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThanOrEqualTo(String value) {
            addCriterion("studentNo <=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLike(String value) {
            addCriterion("studentNo like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotLike(String value) {
            addCriterion("studentNo not like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoIn(List<String> values) {
            addCriterion("studentNo in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotIn(List<String> values) {
            addCriterion("studentNo not in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoBetween(String value1, String value2) {
            addCriterion("studentNo between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotBetween(String value1, String value2) {
            addCriterion("studentNo not between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNull() {
            addCriterion("projectNo is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("projectNo is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("projectNo =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("projectNo <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("projectNo >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("projectNo >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("projectNo <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("projectNo <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("projectNo like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("projectNo not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("projectNo in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("projectNo not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("projectNo between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("projectNo not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andSel_reasonIsNull() {
            addCriterion("sel_reason is null");
            return (Criteria) this;
        }

        public Criteria andSel_reasonIsNotNull() {
            addCriterion("sel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andSel_reasonEqualTo(String value) {
            addCriterion("sel_reason =", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonNotEqualTo(String value) {
            addCriterion("sel_reason <>", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonGreaterThan(String value) {
            addCriterion("sel_reason >", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonGreaterThanOrEqualTo(String value) {
            addCriterion("sel_reason >=", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonLessThan(String value) {
            addCriterion("sel_reason <", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonLessThanOrEqualTo(String value) {
            addCriterion("sel_reason <=", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonLike(String value) {
            addCriterion("sel_reason like", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonNotLike(String value) {
            addCriterion("sel_reason not like", value, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonIn(List<String> values) {
            addCriterion("sel_reason in", values, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonNotIn(List<String> values) {
            addCriterion("sel_reason not in", values, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonBetween(String value1, String value2) {
            addCriterion("sel_reason between", value1, value2, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andSel_reasonNotBetween(String value1, String value2) {
            addCriterion("sel_reason not between", value1, value2, "sel_reason");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateIsNull() {
            addCriterion("company_sel_date is null");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateIsNotNull() {
            addCriterion("company_sel_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateEqualTo(Date value) {
            addCriterion("company_sel_date =", value, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateNotEqualTo(Date value) {
            addCriterion("company_sel_date <>", value, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateGreaterThan(Date value) {
            addCriterion("company_sel_date >", value, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("company_sel_date >=", value, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateLessThan(Date value) {
            addCriterion("company_sel_date <", value, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateLessThanOrEqualTo(Date value) {
            addCriterion("company_sel_date <=", value, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateIn(List<Date> values) {
            addCriterion("company_sel_date in", values, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateNotIn(List<Date> values) {
            addCriterion("company_sel_date not in", values, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateBetween(Date value1, Date value2) {
            addCriterion("company_sel_date between", value1, value2, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andCompany_sel_dateNotBetween(Date value1, Date value2) {
            addCriterion("company_sel_date not between", value1, value2, "company_sel_date");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCompany_nameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompany_nameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_nameEqualTo(String value) {
            addCriterion("company_name =", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameGreaterThan(String value) {
            addCriterion("company_name >", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameLessThan(String value) {
            addCriterion("company_name <", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameLike(String value) {
            addCriterion("company_name like", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotLike(String value) {
            addCriterion("company_name not like", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameIn(List<String> values) {
            addCriterion("company_name in", values, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "company_name");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table project_select
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
     * This class corresponds to the database table project_select
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