package com.gruop.cmoic.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChapterExample() {
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

        public Criteria andComicsidIsNull() {
            addCriterion("comicsId is null");
            return (Criteria) this;
        }

        public Criteria andComicsidIsNotNull() {
            addCriterion("comicsId is not null");
            return (Criteria) this;
        }

        public Criteria andComicsidEqualTo(Integer value) {
            addCriterion("comicsId =", value, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidNotEqualTo(Integer value) {
            addCriterion("comicsId <>", value, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidGreaterThan(Integer value) {
            addCriterion("comicsId >", value, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("comicsId >=", value, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidLessThan(Integer value) {
            addCriterion("comicsId <", value, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidLessThanOrEqualTo(Integer value) {
            addCriterion("comicsId <=", value, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidIn(List<Integer> values) {
            addCriterion("comicsId in", values, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidNotIn(List<Integer> values) {
            addCriterion("comicsId not in", values, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidBetween(Integer value1, Integer value2) {
            addCriterion("comicsId between", value1, value2, "comicsid");
            return (Criteria) this;
        }

        public Criteria andComicsidNotBetween(Integer value1, Integer value2) {
            addCriterion("comicsId not between", value1, value2, "comicsid");
            return (Criteria) this;
        }

        public Criteria andChapternumIsNull() {
            addCriterion("chapterNum is null");
            return (Criteria) this;
        }

        public Criteria andChapternumIsNotNull() {
            addCriterion("chapterNum is not null");
            return (Criteria) this;
        }

        public Criteria andChapternumEqualTo(Integer value) {
            addCriterion("chapterNum =", value, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumNotEqualTo(Integer value) {
            addCriterion("chapterNum <>", value, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumGreaterThan(Integer value) {
            addCriterion("chapterNum >", value, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapterNum >=", value, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumLessThan(Integer value) {
            addCriterion("chapterNum <", value, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumLessThanOrEqualTo(Integer value) {
            addCriterion("chapterNum <=", value, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumIn(List<Integer> values) {
            addCriterion("chapterNum in", values, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumNotIn(List<Integer> values) {
            addCriterion("chapterNum not in", values, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumBetween(Integer value1, Integer value2) {
            addCriterion("chapterNum between", value1, value2, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternumNotBetween(Integer value1, Integer value2) {
            addCriterion("chapterNum not between", value1, value2, "chapternum");
            return (Criteria) this;
        }

        public Criteria andChapternameIsNull() {
            addCriterion("chapterName is null");
            return (Criteria) this;
        }

        public Criteria andChapternameIsNotNull() {
            addCriterion("chapterName is not null");
            return (Criteria) this;
        }

        public Criteria andChapternameEqualTo(String value) {
            addCriterion("chapterName =", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotEqualTo(String value) {
            addCriterion("chapterName <>", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameGreaterThan(String value) {
            addCriterion("chapterName >", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameGreaterThanOrEqualTo(String value) {
            addCriterion("chapterName >=", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameLessThan(String value) {
            addCriterion("chapterName <", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameLessThanOrEqualTo(String value) {
            addCriterion("chapterName <=", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameLike(String value) {
            addCriterion("chapterName like", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotLike(String value) {
            addCriterion("chapterName not like", value, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameIn(List<String> values) {
            addCriterion("chapterName in", values, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotIn(List<String> values) {
            addCriterion("chapterName not in", values, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameBetween(String value1, String value2) {
            addCriterion("chapterName between", value1, value2, "chaptername");
            return (Criteria) this;
        }

        public Criteria andChapternameNotBetween(String value1, String value2) {
            addCriterion("chapterName not between", value1, value2, "chaptername");
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

        public Criteria andUploadtimeIsNull() {
            addCriterion("uploadTime is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("uploadTime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("uploadTime >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(Date value) {
            addCriterionForJDBCDate("uploadTime <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("uploadTime <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterionForJDBCDate("uploadTime in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("uploadTime not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("uploadTime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("uploadTime not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressIsNull() {
            addCriterion("chapterContentAddress is null");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressIsNotNull() {
            addCriterion("chapterContentAddress is not null");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressEqualTo(String value) {
            addCriterion("chapterContentAddress =", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressNotEqualTo(String value) {
            addCriterion("chapterContentAddress <>", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressGreaterThan(String value) {
            addCriterion("chapterContentAddress >", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressGreaterThanOrEqualTo(String value) {
            addCriterion("chapterContentAddress >=", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressLessThan(String value) {
            addCriterion("chapterContentAddress <", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressLessThanOrEqualTo(String value) {
            addCriterion("chapterContentAddress <=", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressLike(String value) {
            addCriterion("chapterContentAddress like", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressNotLike(String value) {
            addCriterion("chapterContentAddress not like", value, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressIn(List<String> values) {
            addCriterion("chapterContentAddress in", values, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressNotIn(List<String> values) {
            addCriterion("chapterContentAddress not in", values, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressBetween(String value1, String value2) {
            addCriterion("chapterContentAddress between", value1, value2, "chaptercontentaddress");
            return (Criteria) this;
        }

        public Criteria andChaptercontentaddressNotBetween(String value1, String value2) {
            addCriterion("chapterContentAddress not between", value1, value2, "chaptercontentaddress");
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