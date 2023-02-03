package ir.mapsa.javacourse.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.mapsa.javacourse.tutorial.session5.Student;

import java.util.Calendar;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,1990);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.MONTH,1);
        Student student = new Student("Ali", "Alavi", "1234566789", 1L, 30, 10,calendar.getTime());
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);

        Student map = objectMapper.readValue(s, Student.class);
        System.out.println(map);

//        Date date = new Date();
//        Calendar instance = Calendar.getInstance();
//        instance.set(Calendar.YEAR,1980);
//        instance.set(Calendar.MONTH,3);
//        instance.add(Calendar.DAY_OF_YEAR,-2);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
//        String format = simpleDateFormat.format(instance.getTime());
//        try {
//            Date parse = simpleDateFormat.parse(format);
//            System.out.println(parse);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(format);
//        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
//        System.out.println(instance.getTime());
//        System.out.println(date.getYear());
//        System.out.println(System.currentTimeMillis()/(1000L *60*60*24*356));
    }
}
