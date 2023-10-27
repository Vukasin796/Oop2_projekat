package model;

import java.util.List;

public class Menadzer extends Radnik {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menadzer(String ime, String prezime, String biografija, double plata, List<Radnik> departman) {
        super(ime, prezime, biografija, plata);
        this.departman = departman;
    }

    public List<Radnik> departman;

    public List<Radnik> getDepartman() {
        return departman;
    }

    public void setDepartman(List<Radnik> departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        return this.toString() + "|" + departman;
    }
}
