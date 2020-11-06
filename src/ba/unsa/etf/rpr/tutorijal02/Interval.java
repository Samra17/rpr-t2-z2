package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pripadnostPrve, pripadnostDruge;

    public Interval(double pocetna, double krajnja, boolean pripadnostPrve, boolean isPripadnostDruge) throws IllegalArgumentException {
        if (pocetna > krajnja) throw new IllegalArgumentException("Nispravni podaci");
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pripadnostPrve = pripadnostPrve;
        this.pripadnostDruge = isPripadnostDruge;
    }

    public Interval() {
        this.pocetna = 0;
        this.krajnja = 0;
        pripadnostPrve = false;
        pripadnostDruge = false;
    }


    public double getPocetna() {
        return pocetna;
    }

    public void setPocetna(double pocetna) throws IllegalArgumentException {
        //if (pocetna > krajnja) throw new IllegalArgumentException();
        this.pocetna = pocetna;
    }

    public double getKrajnja() {
        return krajnja;
    }

    public void setKrajnja(double krajnja) throws IllegalArgumentException {
        // if (krajnja < pocetna) throw new IllegalArgumentException();
        this.krajnja = krajnja;
    }

    public boolean isPripadnostPrve() {
        return pripadnostPrve;
    }

    public void setPripadnostPrve(boolean pripadnostPrve) {
        this.pripadnostPrve = pripadnostPrve;
    }

    public boolean isPripadnostDruge() {
        return pripadnostDruge;
    }

    public void setPripadnostDruge(boolean pripadnostDruge) {
        this.pripadnostDruge = pripadnostDruge;
    }

    public boolean isNull() {
        return pocetna == krajnja;
    }

    public boolean isIn(double tacka) {
        if (pripadnostPrve && tacka >= pocetna && pripadnostDruge && tacka <= krajnja) return true;
        if (!pripadnostPrve && tacka > pocetna && pripadnostDruge && tacka <= krajnja) return true;
        if (pripadnostPrve && tacka >= pocetna && !pripadnostDruge && tacka < krajnja) return true;
        if (!pripadnostPrve && tacka > pocetna && !pripadnostDruge && tacka < krajnja) return true;
        return false;
    }

    @Override
    public String toString() {
        if(pocetna == 0 && krajnja == 0)
            return "()";
        else if(pripadnostPrve && pripadnostDruge)
            return "[" + pocetna + "," + krajnja + "]";
        else if(!pripadnostPrve && pripadnostDruge)
            return "(" + pocetna + "," + krajnja + "]";
        else if(pripadnostPrve && !pripadnostDruge)
            return "[" + pocetna + "," + krajnja + ")";
        else
            return "(" + pocetna + "," + krajnja + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Interval i = (Interval) obj;
        return pocetna == i.pocetna && krajnja == i.krajnja && pripadnostDruge == i.pripadnostDruge && pripadnostPrve == i.pripadnostPrve;
    }

    public Interval intersect(Interval i) {
        if(i.pocetna > pocetna) {
            pocetna = i.pocetna;
            pripadnostPrve = i.pripadnostPrve;
        }
        if(krajnja > i.krajnja) {
            krajnja = i.krajnja;
            pripadnostDruge = i.pripadnostDruge;
        }
        return this;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval i = new Interval();
        if(i2.getPocetna() > i1.getPocetna()) {
            i.setPocetna(i2.getPocetna());
            i.setPripadnostPrve(i2.isPripadnostPrve());
        }
        else {
            i.setPocetna(i1.getPocetna());
            i.setPripadnostPrve( i1.isPripadnostPrve());
        }
        if(i1.getKrajnja() > i2.getKrajnja()) {
            i.setKrajnja(i2.getKrajnja());
            i.setPripadnostDruge(i2.isPripadnostDruge());
        }
        else {
            i.setKrajnja(i1.getKrajnja());
            i.setPripadnostDruge(i1.isPripadnostDruge());
        }
        return  i;
    }
}

