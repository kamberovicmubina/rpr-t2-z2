package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaPripada;
    private boolean krajnjaPripada;

    public Interval (double poc, double kraj, boolean pprip, boolean kprip) {
        if (poc > kraj) throw new IllegalArgumentException ("Neisparavan interval");
        pocetnaTacka = poc;
        krajnjaTacka = kraj;
        pocetnaPripada = pprip;
        krajnjaPripada = kprip;
    }
    public Interval () {
        pocetnaPripada = false;
        krajnjaPripada = false;
        pocetnaTacka = 0;
        krajnjaTacka = 0;
    }
    public boolean isNull () {
        return pocetnaTacka == 0 && krajnjaTacka == 0 && pocetnaPripada == false && krajnjaPripada == false;
    }
    public boolean isIn (double tacka) {
        if (pocetnaPripada && krajnjaPripada)
            return (tacka >= pocetnaTacka && tacka <= krajnjaTacka);
        else if (pocetnaPripada)
            return (tacka >= pocetnaTacka && tacka < krajnjaTacka);
        else if (krajnjaPripada)
            return (tacka > pocetnaTacka && tacka <= krajnjaTacka);
        return (tacka > pocetnaTacka && tacka < krajnjaTacka);
    }
    public Interval intersect (Interval i) {
        Interval novi = new Interval();
        if (krajnjaTacka < i.pocetnaTacka ) { // prvi interval zavrsi prije nego sto drugi pocne-nema presjeka
            return novi;
        } else if (pocetnaTacka > i.krajnjaTacka) { // nema presjeka
            return novi;
        }
        if (pocetnaTacka <= i.pocetnaTacka) {
            novi.pocetnaTacka = i.pocetnaTacka;
            if (i.pocetnaPripada) novi.pocetnaPripada = true;
            else novi.pocetnaPripada = false;
        }
        else {
            novi.pocetnaTacka = pocetnaTacka;
            if (pocetnaPripada) novi.pocetnaPripada = true;
            else novi.pocetnaPripada = false;
        }
        if (krajnjaTacka >= i.krajnjaTacka) {
            novi.krajnjaTacka = i.krajnjaTacka;
            if (i.krajnjaPripada) novi.krajnjaPripada = true;
            else novi.krajnjaPripada = false;
        }
        else {
            novi.krajnjaTacka = krajnjaTacka;
            if (krajnjaPripada) novi.krajnjaPripada = true;
            else novi.krajnjaPripada = false;
        }
        return novi;
    }
    public static Interval intersect (Interval i1, Interval i2) {
        Interval novi = new Interval();
        if (i1.krajnjaTacka < i2.pocetnaTacka ) {
            return novi;
        } else if (i1.pocetnaTacka > i2.krajnjaTacka) {
            return novi;
        }
        if (i1.pocetnaTacka <= i2.pocetnaTacka) {
            novi.pocetnaTacka = i2.pocetnaTacka;
            if (i2.pocetnaPripada) novi.pocetnaPripada = true;
            else novi.pocetnaPripada = false;
        }
        else {
            novi.pocetnaTacka = i1.pocetnaTacka;
            if (i1.pocetnaPripada) novi.pocetnaPripada = true;
            else novi.pocetnaPripada = false;
        }
        if (i1.krajnjaTacka >= i2.krajnjaTacka) {
            novi.krajnjaTacka = i2.krajnjaTacka;
            if (i2.krajnjaPripada) novi.krajnjaPripada = true;
            else novi.krajnjaPripada = false;
        }
        else {
            novi.krajnjaTacka = i1.krajnjaTacka;
            if (i1.krajnjaPripada) novi.krajnjaPripada = true;
            else novi.krajnjaPripada = false;
        }
        return novi;
    }
    @Override
    public String toString() {
        if (isNull()) return "()";
        String s;
        if (pocetnaPripada) s = "[";
        else s = "(";
        s = s + pocetnaTacka + "," + krajnjaTacka;
        if (krajnjaPripada) s += "]";
        else s += ")";
        return s;
    }

    public boolean equals (Interval i) {
        return pocetnaTacka == i.pocetnaTacka && pocetnaPripada == i.pocetnaPripada && krajnjaTacka == i.krajnjaTacka && krajnjaPripada == i.krajnjaPripada;
    }
}
