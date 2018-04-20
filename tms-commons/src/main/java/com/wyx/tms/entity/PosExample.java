package com.wyx.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PosExample() {
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

        public Criteria andPosNameIsNull() {
            addCriterion("pos_name is null");
            return (Criteria) this;
        }

        public Criteria andPosNameIsNotNull() {
            addCriterion("pos_name is not null");
            return (Criteria) this;
        }

        public Criteria andPosNameEqualTo(String value) {
            addCriterion("pos_name =", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameNotEqualTo(String value) {
            addCriterion("pos_name <>", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameGreaterThan(String value) {
            addCriterion("pos_name >", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameGreaterThanOrEqualTo(String value) {
            addCriterion("pos_name >=", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameLessThan(String value) {
            addCriterion("pos_name <", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameLessThanOrEqualTo(String value) {
            addCriterion("pos_name <=", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameLike(String value) {
            addCriterion("pos_name like", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameNotLike(String value) {
            addCriterion("pos_name not like", value, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameIn(List<String> values) {
            addCriterion("pos_name in", values, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameNotIn(List<String> values) {
            addCriterion("pos_name not in", values, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameBetween(String value1, String value2) {
            addCriterion("pos_name between", value1, value2, "posName");
            return (Criteria) this;
        }

        public Criteria andPosNameNotBetween(String value1, String value2) {
            addCriterion("pos_name not between", value1, value2, "posName");
            return (Criteria) this;
        }

        public Criteria andPosPicIsNull() {
            addCriterion("pos_pic is null");
            return (Criteria) this;
        }

        public Criteria andPosPicIsNotNull() {
            addCriterion("pos_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPosPicEqualTo(String value) {
            addCriterion("pos_pic =", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicNotEqualTo(String value) {
            addCriterion("pos_pic <>", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicGreaterThan(String value) {
            addCriterion("pos_pic >", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicGreaterThanOrEqualTo(String value) {
            addCriterion("pos_pic >=", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicLessThan(String value) {
            addCriterion("pos_pic <", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicLessThanOrEqualTo(String value) {
            addCriterion("pos_pic <=", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicLike(String value) {
            addCriterion("pos_pic like", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicNotLike(String value) {
            addCriterion("pos_pic not like", value, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicIn(List<String> values) {
            addCriterion("pos_pic in", values, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicNotIn(List<String> values) {
            addCriterion("pos_pic not in", values, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicBetween(String value1, String value2) {
            addCriterion("pos_pic between", value1, value2, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosPicNotBetween(String value1, String value2) {
            addCriterion("pos_pic not between", value1, value2, "posPic");
            return (Criteria) this;
        }

        public Criteria andPosLicenseIsNull() {
            addCriterion("pos_license is null");
            return (Criteria) this;
        }

        public Criteria andPosLicenseIsNotNull() {
            addCriterion("pos_license is not null");
            return (Criteria) this;
        }

        public Criteria andPosLicenseEqualTo(String value) {
            addCriterion("pos_license =", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseNotEqualTo(String value) {
            addCriterion("pos_license <>", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseGreaterThan(String value) {
            addCriterion("pos_license >", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("pos_license >=", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseLessThan(String value) {
            addCriterion("pos_license <", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseLessThanOrEqualTo(String value) {
            addCriterion("pos_license <=", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseLike(String value) {
            addCriterion("pos_license like", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseNotLike(String value) {
            addCriterion("pos_license not like", value, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseIn(List<String> values) {
            addCriterion("pos_license in", values, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseNotIn(List<String> values) {
            addCriterion("pos_license not in", values, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseBetween(String value1, String value2) {
            addCriterion("pos_license between", value1, value2, "posLicense");
            return (Criteria) this;
        }

        public Criteria andPosLicenseNotBetween(String value1, String value2) {
            addCriterion("pos_license not between", value1, value2, "posLicense");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andPosSiteIsNull() {
            addCriterion("pos_site is null");
            return (Criteria) this;
        }

        public Criteria andPosSiteIsNotNull() {
            addCriterion("pos_site is not null");
            return (Criteria) this;
        }

        public Criteria andPosSiteEqualTo(String value) {
            addCriterion("pos_site =", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteNotEqualTo(String value) {
            addCriterion("pos_site <>", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteGreaterThan(String value) {
            addCriterion("pos_site >", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteGreaterThanOrEqualTo(String value) {
            addCriterion("pos_site >=", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteLessThan(String value) {
            addCriterion("pos_site <", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteLessThanOrEqualTo(String value) {
            addCriterion("pos_site <=", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteLike(String value) {
            addCriterion("pos_site like", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteNotLike(String value) {
            addCriterion("pos_site not like", value, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteIn(List<String> values) {
            addCriterion("pos_site in", values, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteNotIn(List<String> values) {
            addCriterion("pos_site not in", values, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteBetween(String value1, String value2) {
            addCriterion("pos_site between", value1, value2, "posSite");
            return (Criteria) this;
        }

        public Criteria andPosSiteNotBetween(String value1, String value2) {
            addCriterion("pos_site not between", value1, value2, "posSite");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeIsNull() {
            addCriterion("obsolete_time is null");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeIsNotNull() {
            addCriterion("obsolete_time is not null");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeEqualTo(Date value) {
            addCriterion("obsolete_time =", value, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeNotEqualTo(Date value) {
            addCriterion("obsolete_time <>", value, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeGreaterThan(Date value) {
            addCriterion("obsolete_time >", value, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("obsolete_time >=", value, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeLessThan(Date value) {
            addCriterion("obsolete_time <", value, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("obsolete_time <=", value, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeIn(List<Date> values) {
            addCriterion("obsolete_time in", values, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeNotIn(List<Date> values) {
            addCriterion("obsolete_time not in", values, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeBetween(Date value1, Date value2) {
            addCriterion("obsolete_time between", value1, value2, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andObsoleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("obsolete_time not between", value1, value2, "obsoleteTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeIsNull() {
            addCriterion("modification_time is null");
            return (Criteria) this;
        }

        public Criteria andModificationTimeIsNotNull() {
            addCriterion("modification_time is not null");
            return (Criteria) this;
        }

        public Criteria andModificationTimeEqualTo(Date value) {
            addCriterion("modification_time =", value, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeNotEqualTo(Date value) {
            addCriterion("modification_time <>", value, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeGreaterThan(Date value) {
            addCriterion("modification_time >", value, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modification_time >=", value, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeLessThan(Date value) {
            addCriterion("modification_time <", value, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeLessThanOrEqualTo(Date value) {
            addCriterion("modification_time <=", value, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeIn(List<Date> values) {
            addCriterion("modification_time in", values, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeNotIn(List<Date> values) {
            addCriterion("modification_time not in", values, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeBetween(Date value1, Date value2) {
            addCriterion("modification_time between", value1, value2, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andModificationTimeNotBetween(Date value1, Date value2) {
            addCriterion("modification_time not between", value1, value2, "modificationTime");
            return (Criteria) this;
        }

        public Criteria andPosNumberIsNull() {
            addCriterion("pos_number is null");
            return (Criteria) this;
        }

        public Criteria andPosNumberIsNotNull() {
            addCriterion("pos_number is not null");
            return (Criteria) this;
        }

        public Criteria andPosNumberEqualTo(String value) {
            addCriterion("pos_number =", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberNotEqualTo(String value) {
            addCriterion("pos_number <>", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberGreaterThan(String value) {
            addCriterion("pos_number >", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberGreaterThanOrEqualTo(String value) {
            addCriterion("pos_number >=", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberLessThan(String value) {
            addCriterion("pos_number <", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberLessThanOrEqualTo(String value) {
            addCriterion("pos_number <=", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberLike(String value) {
            addCriterion("pos_number like", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberNotLike(String value) {
            addCriterion("pos_number not like", value, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberIn(List<String> values) {
            addCriterion("pos_number in", values, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberNotIn(List<String> values) {
            addCriterion("pos_number not in", values, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberBetween(String value1, String value2) {
            addCriterion("pos_number between", value1, value2, "posNumber");
            return (Criteria) this;
        }

        public Criteria andPosNumberNotBetween(String value1, String value2) {
            addCriterion("pos_number not between", value1, value2, "posNumber");
            return (Criteria) this;
        }
    }

    /**
     */
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