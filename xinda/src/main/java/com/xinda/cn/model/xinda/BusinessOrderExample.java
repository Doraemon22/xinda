package com.xinda.cn.model.xinda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class BusinessOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected int pageSize;
    protected int pageStart;
    protected String no;
 protected String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

    public BusinessOrderExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIsNull() {
            addCriterion("BUSINESS_NO is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIsNotNull() {
            addCriterion("BUSINESS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoEqualTo(String value) {
            addCriterion("BUSINESS_NO =", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotEqualTo(String value) {
            addCriterion("BUSINESS_NO <>", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThan(String value) {
            addCriterion("BUSINESS_NO >", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NO >=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThan(String value) {
            addCriterion("BUSINESS_NO <", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_NO <=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLike(String value) {
            addCriterion("BUSINESS_NO like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotLike(String value) {
            addCriterion("BUSINESS_NO not like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIn(List<String> values) {
            addCriterion("BUSINESS_NO in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotIn(List<String> values) {
            addCriterion("BUSINESS_NO not in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoBetween(String value1, String value2) {
            addCriterion("BUSINESS_NO between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_NO not between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("PRODUCT_ID like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("PRODUCT_ID not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andOrderInfoIsNull() {
            addCriterion("ORDER_INFO is null");
            return (Criteria) this;
        }

        public Criteria andOrderInfoIsNotNull() {
            addCriterion("ORDER_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInfoEqualTo(String value) {
            addCriterion("ORDER_INFO =", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotEqualTo(String value) {
            addCriterion("ORDER_INFO <>", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoGreaterThan(String value) {
            addCriterion("ORDER_INFO >", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_INFO >=", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoLessThan(String value) {
            addCriterion("ORDER_INFO <", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_INFO <=", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoLike(String value) {
            addCriterion("ORDER_INFO like", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotLike(String value) {
            addCriterion("ORDER_INFO not like", value, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoIn(List<String> values) {
            addCriterion("ORDER_INFO in", values, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotIn(List<String> values) {
            addCriterion("ORDER_INFO not in", values, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoBetween(String value1, String value2) {
            addCriterion("ORDER_INFO between", value1, value2, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andOrderInfoNotBetween(String value1, String value2) {
            addCriterion("ORDER_INFO not between", value1, value2, "orderInfo");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Integer value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Integer value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Integer value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Integer value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Integer> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Integer> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Integer value1, Integer value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Integer value) {
            addCriterion("UNIT_PRICE =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Integer value) {
            addCriterion("UNIT_PRICE <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Integer value) {
            addCriterion("UNIT_PRICE >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("UNIT_PRICE >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Integer value) {
            addCriterion("UNIT_PRICE <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("UNIT_PRICE <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Integer> values) {
            addCriterion("UNIT_PRICE in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Integer> values) {
            addCriterion("UNIT_PRICE not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_PRICE between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("UNIT_PRICE not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andBuyNumIsNull() {
            addCriterion("BUY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBuyNumIsNotNull() {
            addCriterion("BUY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBuyNumEqualTo(Integer value) {
            addCriterion("BUY_NUM =", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotEqualTo(Integer value) {
            addCriterion("BUY_NUM <>", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumGreaterThan(Integer value) {
            addCriterion("BUY_NUM >", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUY_NUM >=", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumLessThan(Integer value) {
            addCriterion("BUY_NUM <", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumLessThanOrEqualTo(Integer value) {
            addCriterion("BUY_NUM <=", value, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumIn(List<Integer> values) {
            addCriterion("BUY_NUM in", values, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotIn(List<Integer> values) {
            addCriterion("BUY_NUM not in", values, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumBetween(Integer value1, Integer value2) {
            addCriterion("BUY_NUM between", value1, value2, "buyNum");
            return (Criteria) this;
        }

        public Criteria andBuyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("BUY_NUM not between", value1, value2, "buyNum");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("TOTAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("TOTAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Integer value) {
            addCriterion("TOTAL_PRICE =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Integer value) {
            addCriterion("TOTAL_PRICE <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Integer value) {
            addCriterion("TOTAL_PRICE >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_PRICE >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Integer value) {
            addCriterion("TOTAL_PRICE <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Integer value) {
            addCriterion("TOTAL_PRICE <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Integer> values) {
            addCriterion("TOTAL_PRICE in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Integer> values) {
            addCriterion("TOTAL_PRICE not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_PRICE between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("TOTAL_PRICE not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andEIdIsNull() {
            addCriterion("E_ID is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("E_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(String value) {
            addCriterion("E_ID =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(String value) {
            addCriterion("E_ID <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(String value) {
            addCriterion("E_ID >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(String value) {
            addCriterion("E_ID >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(String value) {
            addCriterion("E_ID <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(String value) {
            addCriterion("E_ID <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLike(String value) {
            addCriterion("E_ID like", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotLike(String value) {
            addCriterion("E_ID not like", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<String> values) {
            addCriterion("E_ID in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<String> values) {
            addCriterion("E_ID not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(String value1, String value2) {
            addCriterion("E_ID between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(String value1, String value2) {
            addCriterion("E_ID not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
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