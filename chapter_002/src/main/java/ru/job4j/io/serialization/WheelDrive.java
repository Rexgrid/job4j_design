package ru.job4j.io.serialization;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "WheelDrive")
public class WheelDrive {
    @XmlAttribute
    private String typeOfWheelDrive;

    public WheelDrive() {}

    public WheelDrive(String typeOfWheelDrive) {
        this.typeOfWheelDrive = typeOfWheelDrive;
    }

    @Override
    public String toString() {
        return "WheelDrive{" +
                "typeOfWheelDrive='" + typeOfWheelDrive + '\'' +
                '}';
    }
}
