package ir.digikala.tutorial.session5;

public  class Sample {
    private  String name;
    public Sample( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Sample2 extends Sample {

    public Sample2(String name) {
        super(name);
    }

    public String getName() {
        return "Prefix" + super.getName();
    }
    public void print(final Sample value) {
        value.setName("In print method!");
        System.out.println(value.getName());
    }
}


class Sample3 {
    public void print(final Sample value) {
        value.setName("In print method!");
        System.out.println(value.getName());
    }

    public void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    public int fib(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }
        return fib(a - 1) + fib(a - 2);
    }


}

class Runner {
    public static void main(String[] args) {
//        Sample3 sample3 = new Sample3();
////        Sample s =new Sample( "To print");
////        sample3.print(s);
////        System.out.println(s.getName());
//        System.out.println(sample3.fib(100));
        Sample s = new Sample2("Hello");
        System.out.println(s.getName());
    }
}
