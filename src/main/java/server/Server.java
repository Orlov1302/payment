package server;

import payment.ParametersPayment;
import taking.Taking;

import java.util.HashSet;

public class Server implements Runnable {
    private Thread thread;
    private Taking taking;
    private HashSet<ParametersPayment> oldPayments; // Здесь храняться старые запросы

    public Server(Taking taking) {
        this.taking = taking;
        oldPayments = new HashSet<>();
        thread = new Thread(this);
        thread.start();
    }

    public void stopThread(){
        thread.interrupt();
    }

    public void stopServer(){
        taking.stopTaking();
    }

    public void run() {
	    while(true) {
            try {
                ParametersPayment parametersPayment;
                parametersPayment = taking.takePayment();
                if( parametersPayment == null ){
                    System.out.println("Поток остановлен жестко");
                    break;
                }else if( parametersPayment.getDate() == null ||
                        parametersPayment.getNumberAccount() == null ||
                        parametersPayment.getNumberPhone() == null ) {
                    System.out.println("Поток остановлен мягко");
                    break;
                }else{
                    System.out.print("Платеж со счета " + parametersPayment.getNumberAccount() +
                        " на телефон " + parametersPayment.getNumberPhone());
                    if (oldPayments.contains(parametersPayment)) {
                        System.out.println(" не выполнен. Запрос поступил повторно!!!");
                    } else {
                        System.out.println(" выполнен.");
                        oldPayments.add(parametersPayment);
                    }
                }
            }
            catch (Exception exc) {
                System.out.println(exc.getMessage());
                break;
            }
        }
    }
}

////