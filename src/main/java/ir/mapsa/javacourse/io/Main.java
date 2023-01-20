package ir.mapsa.javacourse.io;

import ir.mapsa.javacourse.tutorial.session5.Student;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("myfile.txt");
//        URL url = new URL("https://google.com");
//        byte[] bytes = new byte[1024];
//        InputStream inputStream = url.openStream();
//        int read;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        while ((read = inputStream.read(bytes)) != -1) {
//            baos.write(bytes, 0, read);
//        }
//        System.out.println(baos);

//        OutputStream os = new FileOutputStream(file,true);
//        os.write("سلام دنیا".getBytes(StandardCharsets.UTF_8));
//        os.flush();
//        os.close();
        try(FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter)) {

//            PrintWriter pw = new PrintWriter(fileWriter);
//        fileWriter.append("Hello world");
//        fileWriter.flush();
//        fileWriter.close();
            bw.append("Hello world\n");
            bw.flush();
        }

        try(FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr)) {

//        char[] chars = new char[1024];
//
//        int read;
//        String s = "";
//        while ((read = fr.read(chars)) != -1) {
//            s += new String(chars, 0, read);
//        }
//        fr.close();

            String line;
            String s = "";
            while ((line = bf.readLine()) != null) {
                s += line + "\n";
            }
            System.out.println(s);
        }
//        Student student = new Student();
//        student.setNationalId("123453256");
//        student.setPassedCourse(12);
//        student.setId(1L);
//        student.setAge(20);
//        student.setFamily("Doe");
//        student.setName("John");

//        OutputStream os = new FileOutputStream("objectFile");
//        ObjectOutputStream outputStream = new ObjectOutputStream(os);
//        outputStream.writeObject(student);
//        outputStream.flush();
//        outputStream.flush();
//        os.flush();
//        os.close();

//        InputStream is = new FileInputStream("objectFile");
//        ObjectInputStream ois = new ObjectInputStream(is);
//        Student object = (Student) ois.readObject();
//        is.close();
//        ois.close();
    }
}
