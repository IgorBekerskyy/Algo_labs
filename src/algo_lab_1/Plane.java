package algo_lab_1;

public class Plane {

    private String name;
    private Double volumeOfFuelTanksInLiters;
    private Integer passengerCapacity;

    public Plane(String name, Double volumeOfFuelTanksInLiters, Integer passengerCapacity) {
        this.name = name;
        this.volumeOfFuelTanksInLiters = volumeOfFuelTanksInLiters;
        this.passengerCapacity = passengerCapacity;
    }

    public String getName() {
        return name;
    }

    public Double getVolumeOfFuelTanksInLiters() {
        return volumeOfFuelTanksInLiters;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", volumeOfFuelTanksInLiters=" + volumeOfFuelTanksInLiters +
                ", passengerCapacity=" + passengerCapacity +
                '}';
    }
}
