package web.api.assessment.model;

public class CustomerTransactions {
	
	/**
	 * @param id
	 * @param amountSpent
	 * @param month
	 */
	public CustomerTransactions(String id, Integer amountSpent, String month) {
		super();
		id = id;
		this.amountSpent = amountSpent;
		this.month = month;
	}

	/**
	 * 
	 */
	public CustomerTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	String id;
	Integer amountSpent;
	String month;
	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the amountSpent
	 */
	public Integer getAmountSpent() {
		return amountSpent;
	}

	/**
	 * @param amountSpent the amountSpent to set
	 */
	public void setAmountSpent(Integer amountSpent) {
		this.amountSpent = amountSpent;
	}

}
