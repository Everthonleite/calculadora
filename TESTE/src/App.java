import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Obtenha a data da reserva e a data de aniversário do cliente
            System.out.print("Digite a data da reserva (dd/MM/yyyy): ");
            Date reservaDate = dateFormat.parse(scanner.nextLine());

            System.out.print("Digite a data de aniversário do cliente (dd/MM/yyyy): ");
            Date aniversarioDate = dateFormat.parse(scanner.nextLine());

            // Crie objetos de calendário para as datas
            Calendar reservaCalendar = Calendar.getInstance();
            reservaCalendar.setTime(reservaDate);

            Calendar aniversarioCalendar = Calendar.getInstance();
            aniversarioCalendar.setTime(aniversarioDate);

            // Verifique se o mês do aniversário deve ser contabilizado
            int proRataMonths = 0;

            reservaCalendar.add(Calendar.MONTH, 1); // Adicione 1 mês à data da reserva

            while (reservaCalendar.before(aniversarioCalendar)) {
                proRataMonths++;
                reservaCalendar.add(Calendar.MONTH, 1);
            }

            System.out.println("Pro rata: " + proRataMonths + " meses");
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        } finally {
            scanner.close();
        }
    }
}
