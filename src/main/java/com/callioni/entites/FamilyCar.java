
package com.callioni.entites;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class FamilyCar extends Car implements Serializable
{

	private Boolean sunRoof;
	private Boolean airCon;
	private Boolean gps;

	public FamilyCar()
	{

	}

	public FamilyCar(Boolean sunRoof, Boolean airCon, Boolean gps, String colour, String make, String model)
	{
		super(colour, make, model);
		this.sunRoof = sunRoof;
		this.airCon = airCon;
		this.gps = gps;
	}
	
	public Boolean getSunRoof()
	{
		return this.sunRoof;
	}

	public void setSunRoof(Boolean sunRoof)
	{
		this.sunRoof = sunRoof;
	}

	public Boolean getAirCon()
	{
		return this.airCon;
	}

	public void setAirCon(Boolean airCon)
	{
		this.airCon = airCon;
	}

	public Boolean getGps()
	{
		return this.gps;
	}

	public void setGps(Boolean gps)
	{
		this.gps = gps;
	}

	@Override
	public String toString()
	{
		return super.toString()+" FamilyCar{" + "sunRoof=" + sunRoof + ", airCon=" + airCon + ", gps=" + gps + '}';
	}
	
}
