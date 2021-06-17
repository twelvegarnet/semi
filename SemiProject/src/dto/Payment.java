package dto;

public class Payment {
	
	private String paymentUid;
	private String amt;
	private String merchant_uid;
	private String userid;
	
	
	@Override
	public String toString() {
		return "Payment [paymentUid=" + paymentUid + ", amt=" + amt + ", merchant_uid=" + merchant_uid + ", userid="
				+ userid + "]";
	}
	public String getPaymentUid() {
		return paymentUid;
	}
	public void setPaymentUid(String paymentUid) {
		this.paymentUid = paymentUid;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
