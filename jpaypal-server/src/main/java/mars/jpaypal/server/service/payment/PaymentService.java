package mars.jpaypal.server.service.payment;

import static mars.jpaypal.domain.constants.Constants.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.core.rest.APIContext;
import com.paypal.core.rest.PayPalRESTException;

import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;
import mars.jpaypal.server.service.AccessTokenGenerator;
import mars.jpaypal.server.service.payment.internal.assembler.PaymentDTOAssembler;
import mars.jpaypal.server.service.payment.internal.assembler.PaymentExecuteDTOAssembler;

public final class PaymentService {

  public PaymentDTO createPayment(PaymentFB paymentFB) throws PayPalRESTException {
    Payment payment = new Payment();

    Details amountDetails = new Details();
    amountDetails.setSubtotal(paymentFB.getAmount());
    amountDetails.setShipping("0.00");
    amountDetails.setTax("0.00");

    Amount amount = new Amount();
    amount.setCurrency(paymentFB.getCurrency());
    amount.setTotal(paymentFB.getAmount());
    amount.setDetails(amountDetails);

    RedirectUrls redirectUrls = new RedirectUrls();
    redirectUrls.setReturnUrl(paymentFB.getReturnUrl());
    redirectUrls.setCancelUrl(paymentFB.getCancelUrl());

    Transaction transaction = new Transaction();
    transaction.setAmount(amount);
    transaction.setDescription(paymentFB.getDescription());
    List<Transaction> transactions = new ArrayList<Transaction>();
    transactions.add(transaction);

    Payer payer = new Payer();
    payer.setPaymentMethod(paypalPaymentMethod);

    payment.setIntent(paypalIntentSale);
    payment.setPayer(payer);
    payment.setRedirectUrls(redirectUrls);
    payment.setTransactions(transactions);

    String accessToken = AccessTokenGenerator.getAccessToken();
    String requestId = UUID.randomUUID().toString();
    APIContext apiContext = new APIContext(accessToken, requestId);
    payment = payment.create(apiContext);

    return new PaymentDTOAssembler().toDTO(payment);
  }

  public PaymentExecuteDTO executePayment(String paymentId, String payerId) throws PayPalRESTException {
    PaymentExecution paymentExecution = new PaymentExecution(payerId);
    String accessToken = AccessTokenGenerator.getAccessToken();
    Payment payment = getPayment(paymentId);
    Payment executed = payment.execute(accessToken, paymentExecution);

    return new PaymentExecuteDTOAssembler().toDTO(executed);
  }

  private Payment getPayment(String paymentId) throws PayPalRESTException {
    String accessToken = AccessTokenGenerator.getAccessToken();
    String requestUuid = UUID.randomUUID().toString();
    APIContext apiContext = new APIContext(accessToken, requestUuid);
    return Payment.get(apiContext, paymentId);
  }

}