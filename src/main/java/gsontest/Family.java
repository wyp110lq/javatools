package gsontest;

class Family {

    private String father;

    private String mother;

    public Family(String father, String mother) {
        super();
        this.father = father;
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "Family [father=" + father + ", mother=" + mother + "]";
    }

}
