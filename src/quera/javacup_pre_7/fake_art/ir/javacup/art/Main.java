package quera.javacup_pre_7.fake_art.ir.javacup.art;

public class Main {
	public static void main(String[] args) throws Exception {
		// **************example 1***************
		Artist a1 = new Artist();
		a1.setName("Sohrab Sepehri");
		a1.setContemporary(Boolean.TRUE);
		
		Painting p1 = new Painting();
		p1.setArtist(a1);
		p1.setName("Kashan");
		p1.setYear(1972);
		p1.setGenre("Landscape");
		Painting p2 = new FakeArt().fake(p1, "name", "year");
		System.out.println("---example 1---");
		System.out.println(p2.getArtist());
		System.out.println(p2.getName());
		System.out.println(p2.getGenre());
		System.out.println(p2.getYear());
		System.out.println(p1 == p2);
		// *************example 2*****************
		p2 = new FakeArt().fake(p1, "artist.name", "name", "genre");
		System.out.println("---example 2---");
		System.out.println(p2.getArtist().getName());
		System.out.println(p2.getArtist().getContemporary());
		System.out.println(p2.getName());
		System.out.println(p2.getGenre());
		System.out.println(p2.getYear());
		// *************test 3*****************
		Arpit p = new Arpit();
		p.setName("ASdas");
		Arpit as = new FakeArt().fake(p,"name");
		System.out.println("---example 3---");
		//System.out.println(as.getPainting());
		System.out.println(as.getName());
	}
}

class Artist {
	String name;
	Boolean contemporary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getContemporary() {
		return contemporary;
	}
	public void setContemporary(Boolean contemporary) {
		this.contemporary = contemporary;
	}
}

class Painter extends Artist {
	private Painting painting;

	public Painting getPainting() {
		return painting;
	}

	public void setPainting(Painting painting) {
		this.painting = painting;
	}
}

class Arpit extends Painter {

}

class Painting {
	private Artist artist;
	private String name;
	private int year;
	private String genre;
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
