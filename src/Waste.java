public class Waste {

    private String type;
    private double weight;
    private boolean recyclable;

    public Waste(String type, double weight, boolean recyclable) {
        this.type = type;
        this.weight = weight;
        this.recyclable = recyclable;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isRecyclable() {
        return recyclable;
    }

    @Override
    public String toString() {
        return "Waste Type: " + type +
                " | Weight: " + weight + " kg" +
                " | Recyclable: " + (recyclable ? "Yes" : "No");
    }
}