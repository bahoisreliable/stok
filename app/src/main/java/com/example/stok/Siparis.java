package com.example.stok;

public class Siparis {
    private String urunAdi;
    private String urunFiyat;
    private String urunAdet;

    public Siparis(String ad, String fiyat,String adet) {
        this.urunAdi=ad;
        this.urunFiyat=fiyat;
        this.urunAdet=adet;
    }

    public String getUrunAdet() {
        return urunAdet;
    }

    public void setUrunAdet(String urunAdet) {
        this.urunAdet = urunAdet;
    }



    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(String urunFiyat) {
        this.urunFiyat = urunFiyat;
    }
}
