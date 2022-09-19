public class Musician extends Person{
    public Musician(String name, int age) {
        super(name, age);
    }

    public Musician(String name) {
        super(name);
    }

    @Override
    public String hello(){
        return System.out.printf("Hello %s , musician \n", this.name).toString();
    }
    public void play(){
        System.out.printf("%s is playing a great composition \n", this.name);
    }
}

