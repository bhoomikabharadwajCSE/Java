abstract class EnergySource {
    protected String sourceId;
    protected String sourceName;
    protected double energyGenerated;

    public EnergySource(String sourceId, String sourceName, double energyGenerated) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.energyGenerated = energyGenerated;
    }

    public abstract double calcEff();

    public void display() {
        System.out.println("Source ID: " + sourceId);
        System.out.println("Source Name: " + sourceName);
        System.out.println("Energy Generated: " + energyGenerated);
        System.out.println("Efficiency: " + String.format("%.2f", calcEff()) + "%");
        System.out.println();
    }
}

class SolarEnergy extends EnergySource {

    public SolarEnergy(String sourceId, String sourceName, double energyGenerated) {
        super(sourceId, sourceName, energyGenerated);
    }

    @Override
    public double calcEff() {
        return (energyGenerated / 5000.0) * 100;
    }
}

class WindEnergy extends EnergySource {

    public WindEnergy(String sourceId, String sourceName, double energyGenerated) {
        super(sourceId, sourceName, energyGenerated);
    }

    @Override
    public double calcEff() {
        return (energyGenerated / 8000.0) * 100;
    }
}

public class Program3 {
    public static void main(String[] args) {

        System.out.println("--- Energy Source Efficiency Report ---");
        System.out.println();

        EnergySource ref;

        ref = new SolarEnergy("SOL-101", "Sahara Solar Farm", 3500.0);
        ref.display();

        ref = new WindEnergy("WND-202", "North Sea Wind Turbine", 6400.0);
        ref.display();
    }
}
