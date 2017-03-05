package us.lazerzes.citysim.location;

public class LocationBuilding extends GenericLocation {

	public LocationBuilding(int x, int y, String name) {
		super(x, y, name);
	}

	public LocationBuilding(LocationBuilding another) {
		super(another.getPosition().x, another.getPosition().y, another.getName());
	}

}
