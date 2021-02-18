import java.time.LocalDate;

public class Buchung {
    private LocalDate von, bis;
    private Baumaschiene baumaschiene;
    private Auftrag auftrag;
    private Buchung naechste;

    Buchung(Auftrag a, Baumaschiene bm, LocalDate von, LocalDate bis, Buchung b){
        this.von=von;
        this.bis=bis;
        this.auftrag=a;
        this.baumaschiene=bm;
        this.naechste=b;
    }

    public LocalDate getVon() {
        return von;
    }

    public void setVon(LocalDate von) {
        this.von = von;
    }

    public LocalDate getBis() {
        return bis;
    }

    public void setBis(LocalDate bis) {
        this.bis = bis;
    }

    public Baumaschiene getBaumaschiene() {
        return baumaschiene;
    }

    public void setBaumaschiene(Baumaschiene baumaschiene) {
        this.baumaschiene = baumaschiene;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }

    public Buchung getNaechste() {
        return naechste;
    }

    public void setNaechste(Buchung naechste) {
        this.naechste = naechste;
    }
}
