package examples;

public class CD {
    private int id;
    private String artist;
    private String title;

    public CD(int i, String a, String t) {
        id = i;
        artist = a;
        title = t;
    }

    @Override
    public String toString() {
        return "CD [id=" + id + ", artist=" + artist + ", title="
                + title + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((artist == null) ? 0 : artist.hashCode());
        result = prime * result + id;
        result = prime * result
                + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CD other = (CD) obj;
        if (artist == null) {
            if (other.artist != null)
                return false;
        }
        else if (!artist.equals(other.artist))
            return false;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        return true;
    }
}
