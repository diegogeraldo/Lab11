import java.io.Serializable;

public class Person implements Serializable, Comparable<Person> {
    private int age;
    private String name;
    private String address;
    private String zipCode;
    private double salary;

    // Default constructor
    public Person() {}

    // Full constructor
    public Person(int age, String name, String address, String zipCode, double salary) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.salary = salary;
    }

    // Getters & Setters
    public int getAge() { 
    	return age; 
    }
    public void setAge(int age) { 
    	this.age = age; 
    }

    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public String getAddress() { 
    	return address; 
    }
    public void setAddress(String address) { 
    	this.address = address; 
    }

    public String getZipCode() { 
    	return zipCode; 
    }
    public void setZipCode(String zipCode) { 
    	this.zipCode = zipCode; 
    }

    public double getSalary() { 
    	return salary; 
    }
    public void setSalary(double salary) { 
    	this.salary = salary; 
    }

    // Sorting by salary 
    @Override
    public int compareTo(Person other) {
        return Double.compare(other.salary, this.salary);
    }

    // Formatted output
    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nAddress: %s\nZip Code: %s\nSalary: $%,.2f\n",
            name, age, address, zipCode, salary);
    }
}