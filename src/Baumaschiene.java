import java.time.LocalDate;

public class Baumaschiene {
    private static int maschienenZaehler=0;
    private int maschieneNr;
    private String bezeichnung, typ;
    private double preisProTag;
    private Buchung ersteBuchung;

    public Baumaschiene(String bezeichnung, String typ, double preisProTag, Buchung ersteBuchung) {
        maschienenZaehler++;
        this.maschieneNr = maschienenZaehler;
        this.bezeichnung = bezeichnung;
        this.typ = typ;
        this.preisProTag = preisProTag;
        this.ersteBuchung = ersteBuchung;
    }

    public boolean istFrei(LocalDate von, LocalDate bis){
        if (ersteBuchung==null) return true;

        boolean frei=true;
        Buchung temp=ersteBuchung;

        while (true){
            if (temp.getVon().compareTo(von)<=0 && temp.getBis().compareTo(von)>=0) frei= false;
            if (temp.getBis().compareTo(bis)>=0 && temp.getVon().compareTo(bis)<=0) frei= false;
            if (temp.getNaechste()==null) break;
            temp=temp.getNaechste();

        }
        System.out.println("Test of Frei: "+frei);
        return frei;
    }

    public Buchung buche(Auftrag a, LocalDate von, LocalDate bis) {
        Buchung buchung = new Buchung(a, this, von, bis, null);

        if (ersteBuchung == null) {
            ersteBuchung = buchung;
            System.out.println("Fall 1");
        } else if(ersteBuchung.getNaechste()==null && ersteBuchung.getVon().compareTo(von)>=0 && istFrei(von,bis)){ //liegt nach dem ersten Eintrag
        ersteBuchung.setNaechste(buchung);
            System.out.println("Fall 2");
        } else if(ersteBuchung.getVon().compareTo(von)<=0 && istFrei(von,bis)){ //liegt vor dem ersten eintrag ganz vorne
             buchung.setNaechste(ersteBuchung);
             ersteBuchung=buchung;
             System.out.println("Fall 3");

        }else if (istFrei(von,bis)) {
            System.out.println("Fall 4");

            Buchung temp=ersteBuchung;
            while (temp.getNaechste()!=null && von.compareTo(temp.getVon())<=0){
                temp=temp.getNaechste();
            }

            temp.setNaechste(buchung);
        } else {
            System.out.println("Fall 5");
            return null;
        }
        return buchung;
    }

    @Override
    public String toString() {
        String ausgabe="Baumaschiene{" +
                "maschieneNr=" + maschieneNr +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", typ='" + typ + '\'' +
                ", preisProTag=" + preisProTag +
                ",Buchungen=" + ersteBuchung;
        Buchung temp=ersteBuchung;
        while (temp.getNaechste()!=null){
            ausgabe+=", "+temp;
            temp=temp.getNaechste();

        }
        ausgabe+='}';
        return ausgabe;
    }

    public int getMaschieneNr() {
        return maschieneNr;
    }

    public void setMaschieneNr(int maschieneNr) {
        this.maschieneNr = maschieneNr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public double getPreisProTag() {
        return preisProTag;
    }

    public void setPreisProTag(double preisProTag) {
        this.preisProTag = preisProTag;
    }

    public Buchung getErsteBuchung() {
        return ersteBuchung;
    }

    public void setErsteBuchung(Buchung ersteBuchung) {
        this.ersteBuchung = ersteBuchung;
    }
}
