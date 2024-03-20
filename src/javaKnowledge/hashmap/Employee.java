package javaKnowledge.hashmap;

public class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    Shallow comparison: The default implementation of equals method is defined in Java. lang. Object
    class which simply checks if two Object references (say x and y) refer to the same Object.
     i.e. It checks if x == y.
     */
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this)
//            return true;
//        if (!(obj instanceof Employee))
//            return false;
//        Employee employee = (Employee) obj;
//        return employee.getAge() == this.getAge()
//                && employee.getName() == this.getName();
//    }

    // commented
    @Override
    /*Typically, hashCode() just returns the object's address in memory if you don't override it.
      As much as is reasonably practical, the hashCode method defined by class Object does return distinct integers
      for distinct objects. (This is typically implemented by converting the internal address of the object into
      an integer, but this implementation technique is not required by the JavaTM programming language.)*/
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}
