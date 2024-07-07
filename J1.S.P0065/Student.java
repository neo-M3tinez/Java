package j1.s.p0065;

public class Student {
    private String name;
    private String className; 
    private double math;
    private double physical;
    private double chemistry;
    private double average;
    private char type;

    // Constructor to initialize student attributes
    public Student(String name, String className, double math, double physical, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
        this.average = calculateAverage();
        this.type = calculateType(this.average);
    }

    // Getter and setter methods for student attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAverage() {
        return average;
    }

    // Method to calculate the average score
    private double calculateAverage() {
        return (this.math + this.chemistry + this.physical) / 3.0;
    }

    // Method to calculate the type based on the average score
    private char calculateType(double average) {
        if (average > 7.5) {
            return 'A';
        } else if (average >= 6 && average < 7.5) {
            return 'B';
        } else if (average >= 4 && average < 6) {
            return 'C';
        } else {
            return 'D';
        }
    }
}
