package ch.bbw.pr.hafenboote.model;

/**
 * @class: Boot
 * @package: ch.bbw.hafenboote
 * @author: Sebastian
 * @date: 23.02.2021
 **/

public class Boot {
	public int laenge;
	public String name;

	public Boot( String name, int laenge) {
		this.laenge = laenge;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Boot{" +
				"laenge=" + laenge +
				", name='" + name + '\'' +
				'}';
	}
} //End of Class
