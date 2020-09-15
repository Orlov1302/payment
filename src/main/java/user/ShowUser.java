package user;

import payment.PaymantPhone;

import javax.swing.*;
import java.util.Date;

public class ShowUser {
    public ShowUser( User user, PaymantPhone paymantPhone ){
        // создать новый контейнер типа JFraDe
        JFrame jfrm = new JFrame("Тестирование платежа" );
        // задать исходные размеры фрейма
        jfrm.setSize(1000, 500);
        // завершить работу, если пользователь закрывает приложение
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //////////////////////////////
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        JPanel panel2 = new JPanel();
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        jfrm.add(mainPanel);

        // Первая панель
        JLabel jlab1 = new JLabel("Пользователь №" + user.numberUser + " " + user.stringFIO );
        panel1.add(jlab1);
        JLabel jlab2 = new JLabel("Счет: " + user.numberAccount + "   Номер телефона: " + user.getPhone().getNumberPhone() );
        panel1.add(jlab2);

        // Вторая панель
        JButton jbtnA = new JButton("Alpha " );
        jbtnA.addActionListener( (ae) -> this.pay(user, paymantPhone) ) ;
        panel2.add(jbtnA);

        // отобразить фрейм
        jfrm.setVisible(true);
    }

    public void pay(User user, PaymantPhone paymantPhone) {
        System.out.println(user.payPhone(new Date(), paymantPhone, 200));
    }
}
