package ru.job4j.io.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean isCoupe;
    @XmlAttribute
    private int horsePower;
    private WheelDrive typeOfWheelDrive;
    private String[] parameters;

    public Car() {
    }

    public Car(boolean isCoupe, int horsePower, WheelDrive typeOfWheelDrive, String... parameters) {
        this.isCoupe = isCoupe;
        this.horsePower = horsePower;
        this.typeOfWheelDrive = typeOfWheelDrive;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isCoupe=" + isCoupe +
                ", horsePower=" + horsePower +
                ", typeOfWheelDrive=" + typeOfWheelDrive +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car(true, 200, new WheelDrive("Front wheel drive"), "2", "blue");

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result = "";

        try (StringWriter sw = new StringWriter()) {
            marshaller.marshal(car, sw);
            result = sw.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader sr = new StringReader(result)) {
            Car desCar = (Car) unmarshaller.unmarshal(sr);
            System.out.println(desCar);
        }
    }
}
