package music_player;

public class song {
    private final String aName;
    private final String aArtist;
    private final int aLength;


    public song(String pName, String pArtist, int pLength) {
        assert pName!=null && pArtist!=null && pLength>0;
        aName = pName;
        aArtist = pArtist;
        aLength = pLength;
    }

    public String getName() {
        return aName;
    }

    public String getArtist() {
        return aArtist;
    }

    public int getLength() {
        return aLength;
    }
}
