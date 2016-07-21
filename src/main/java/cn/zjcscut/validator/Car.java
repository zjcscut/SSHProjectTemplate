package cn.zjcscut.validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zjc
 * @version 2016/7/20 23:19
 * @function Hibernate Validator的测试类
 */
public class Car {

	@NotNull
	private String manufacturer;

	@NotNull
	@Size(min = 2,max = 14)
	private String licensePlate;

	@Min(2)
	private int seatCount;

	public Car(String manufacturer, String licensePlate, int seatCount) {
		this.manufacturer = manufacturer;
		this.licensePlate = licensePlate;
		this.seatCount = seatCount;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
}
