package muhammedf.afet.model;

public enum OnayDurumu {

    OnayBekliyor, Onaylandi, Reddedildi, Yayinda;

    @Override
    public String toString() {
        switch (this){
            case OnayBekliyor: return "Onay Bekliyor";
            case Onaylandi: return "Onaylandı";
            case Reddedildi: return "Reddedildi";
            case Yayinda: return "Yayında";
        }
        return super.toString();
    }
}
