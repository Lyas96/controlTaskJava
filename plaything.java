
public class plaything {
    int id;
    String name;
    int kolvo;
    int weight;

    public String info() {
        return "Toy.info : " +
                "id = " + this.getId() +
                " name = " + this.getName() +
                " kolvo = " + this.getKolvo() +
                " weight " + this.getWeight();
    }

    public plaything() {
    }

    public plaything(int id, String name, int kolvo, int weight) {
        this.id = id;
        this.name = name;
        this.kolvo = kolvo;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}