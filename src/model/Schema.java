package model;

public class Schema {

    public int id;
    public String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return " Id: (" + this.id + ")"+" Name: " + this.name + "\n";
    }


}
