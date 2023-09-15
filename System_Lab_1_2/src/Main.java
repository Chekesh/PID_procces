import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            ProcessBuilder prok = new ProcessBuilder("tasklist");
            Process process = prok.start();  // запускаем процесс
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String list;
            int propusk = 0;
            boolean first = true;
            while ((list = br.readLine()) != null) {
                //System.out.println(list);
                if (!list.trim().isEmpty()) {
                    String[] str = list.trim().split("\\s+"); 
                    if (str.length >= 2 && propusk++ > 2) {
                        if (first) {                      // первый процесс
                            System.out.println("Первуй запущенный процесс " + str[0] + " и его pid " + str[1]);
                            first = false;
                        }
                        System.out.println("Name: "+ str[0]); // вывод имени процесса
                        System.out.println("Pid: " + str[1]); // вывод pid процесса
                    }
                }
            }
            int exit = process.exitValue();  // завершаем процесс
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}