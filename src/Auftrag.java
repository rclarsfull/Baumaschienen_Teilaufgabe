import java.time.LocalDate;
import java.util.ArrayList;

public class Auftrag {
    private static int auftragsZaehler=0;
    private int auftrgsNr;
    private LocalDate auftragsDatum;

    public Auftrag(LocalDate auftragsDatum) {
        this.auftragsDatum =LocalDate.now();
        auftragsZaehler++;
        auftrgsNr=auftragsZaehler;
        buchungen=new ArrayList<Buchung>();
    }
    public ArrayList<Buchung> getBuchungen() {
        return buchungen;
    }

    public void setBuchungen(ArrayList<Buchung> buchungen) {
        this.buchungen = buchungen;
    }

    private ArrayList<Buchung> buchungen;




    public static int getAuftragsZaehler() {
        return auftragsZaehler;
    }

    public int getAuftrgsNr() {
        return auftrgsNr;
    }

    public LocalDate getAuftragsDatum() {
        return auftragsDatum;
    }
}
