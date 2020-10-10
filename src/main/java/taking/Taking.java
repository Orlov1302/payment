package taking;

import payment.PaymentParameters;

public interface Taking {
    PaymentParameters takePayment();
    void stopTaking();
}

////