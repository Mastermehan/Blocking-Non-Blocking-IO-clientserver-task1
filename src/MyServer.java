import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//мы использовали   блокирующий ввод-вывод,
// потому что поток нам нужно  блокировать  на время ожидания операций ввода-вывода,
// и у нас одна операция для пользователя. Пареаллельность выполнения нам не требуется
// и в быстродействии ничего не теряется

public class MyServer {
    public static void main(String[] args) throws IOException {
        //  Занимаем порт 23444, определяя серверный сокет
        ServerSocket servSocket = new ServerSocket(23444);
        while (true) {
            //    Ждем подключения клиента иполучаем потоки для дальнейшей работы
            try (Socket socket = servSocket.accept();
                 //   Получаем потоки для дальнейшей работы
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    try {
                        int number = Integer.parseInt(line);
                        // пишем ответ
                        out.println("Ваше значение: " + Calculate.Fibonacci(number));
                    } catch (Exception ex) {
                        out.println("Значение неверно, введите другое значение");
                        ex.printStackTrace(System.out);
                    }
                }
            }
        }
    }
}






