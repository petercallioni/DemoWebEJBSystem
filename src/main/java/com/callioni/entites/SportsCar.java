
package com.callioni.entites;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class SportsCar extends Car implements Serializable
{

	private Boolean turboCharger;

	private Boolean sportsPackage;

	private Boolean launchAssist;

	public SportsCar()
	{

	}

	public SportsCar(Boolean turboCharger, Boolean sportsPackage, Boolean launchAssist, String colour, String make, String model)
	{
		super(colour, make, model);
		this.turboCharger = turboCharger;
		this.sportsPackage = sportsPackage;
		this.launchAssist = launchAssist;
	}
	
	public Boolean getTurboCharger()
	{
		return this.turboCharger;
	}

	public void setTurboCharger(Boolean turboCharger)
	{
		this.turboCharger = turboCharger;
	}

	public Boolean getSportsPackage()
	{
		return this.sportsPackage;
	}

	public void setSportsPackage(Boolean sportsPackage)
	{
		this.sportsPackage = sportsPackage;
	}

	public Boolean getLaunchAssist()
	{
		return this.launchAssist;
	}

	public void setLaunchAssist(Boolean launchAssist)
	{
		this.launchAssist = launchAssist;
	}

	@Override
	public String toString()
	{
		return super.toString()+" SportsCar{" + "turboCharger=" + turboCharger + ", sportsPackage=" + sportsPackage + ", launchAssist=" + launchAssist + '}';
	}

}
