package mars.jpaypal.domain.constants;

public class Constants {

  public static final String UTF_8 = "UTF-8";

  // PayPal REST api constants
  public static final String paypalPaymentMethod = "paypal";
  public static final String paypalIntentSale = "sale";
  public static final String paypalApprovalUrl = "approval_url";
  public static final String paypalPayerId = "PayerID";
  public static final String paypalToken = "token";
  // Paypal REST - Payment states
  public static final String paypalCreated = "created";
  public static final String paypalApproved = "approved";
  public static final String paypalFailed = "failed";
  public static final String paypalCanceled = "canceled";
  public static final String paypalExpired = "expired";
  // Paypal REST - Sale states
  public static final String paypalPending = "pending";
  public static final String paypalCompleted = "completed";
  public static final String paypalRefunded = "refunded";
  public static final String paypalPartiallyRefunded = "partially_refunded";

  // PaymentFB
  public static final String amount = "amount";
  public static final String currency = "currency";
  public static final String returnUrl = "returnUrl";
  public static final String cancelUrl = "cancelUrl";
  public static final String description = "description";

  // PaymentExecuteFB
  public static final String paymentId = "paymentId";
  public static final String payerId = "payerId";

}