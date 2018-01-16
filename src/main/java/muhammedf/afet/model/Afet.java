package muhammedf.afet.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Afet implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String seriNo;

	@Column
	private String glideNo;

	@Column
	@Temporal(TemporalType.DATE)
	private Date baslangicTarihi;

	@Column
	@Temporal(TemporalType.DATE)
	private Date bitisTarihi;

	@Column
	private Integer sure;

	@Column
	private String afetTuru;

	@Column
	private String il;

	@Column
	private String ilce;

	@Column
	private String koy;

	@Column
	private String mahalle;

	@Column
	private String belde;

	@Column
	private String neden;

	@Column
	private Double enlem;

	@Column
	private Double boylam;

	@Column
	private String nedenAciklama;

	@Column
	private String etkiledigiAlanlar;

	@Column
	private String kaynak;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Afet)) {
			return false;
		}
		Afet other = (Afet) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public Date getBaslangicTarihi() {
		return baslangicTarihi;
	}

	public void setBaslangicTarihi(Date baslangicTarihi) {
		this.baslangicTarihi = baslangicTarihi;
	}

	public Date getBitisTarihi() {
		return bitisTarihi;
	}

	public void setBitisTarihi(Date bitisTarihi) {
		this.bitisTarihi = bitisTarihi;
	}

	public Integer getSure() {
		return sure;
	}

	public void setSure(Integer sure) {
		this.sure = sure;
	}

	public String getAfetTuru() {
		return afetTuru;
	}

	public void setAfetTuru(String afetTuru) {
		this.afetTuru = afetTuru;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getKoy() {
		return koy;
	}

	public void setKoy(String koy) {
		this.koy = koy;
	}

	public String getMahalle() {
		return mahalle;
	}

	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}

	public String getBelde() {
		return belde;
	}

	public void setBelde(String belde) {
		this.belde = belde;
	}

	public Double getEnlem() {
		return enlem;
	}

	public void setEnlem(Double enlem) {
		this.enlem = enlem;
	}

	public Double getBoylam() {
		return boylam;
	}

	public void setBoylam(Double boylam) {
		this.boylam = boylam;
	}

	public String getNedenAciklama() {
		return nedenAciklama;
	}

	public void setNedenAciklama(String nedenAciklama) {
		this.nedenAciklama = nedenAciklama;
	}

	public String getEtkiledigiAlanlar() {
		return etkiledigiAlanlar;
	}

	public void setEtkiledigiAlanlar(String etkiledigiAlanlar) {
		this.etkiledigiAlanlar = etkiledigiAlanlar;
	}

	public String getKaynak() {
		return kaynak;
	}

	public void setKaynak(String kaynak) {
		this.kaynak = kaynak;
	}

	public String getSeriNo() {
		return seriNo;
	}

	public void setSeriNo(String seriNo) {
		this.seriNo = seriNo;
	}

	public String getGlideNo() {
		return glideNo;
	}

	public void setGlideNo(String glideNo) {
		this.glideNo = glideNo;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getNeden() {
		return neden;
	}

	public void setNeden(String neden) {
		this.neden = neden;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (seriNo != null && !seriNo.trim().isEmpty())
			result += "seriNo: " + seriNo;
		if (glideNo != null && !glideNo.trim().isEmpty())
			result += ", glideNo: " + glideNo;
		if (sure != null)
			result += ", sure: " + sure;
		if (afetTuru != null && !afetTuru.trim().isEmpty())
			result += ", afetTuru: " + afetTuru;
		if (il != null && !il.trim().isEmpty())
			result += ", il: " + il;
		if (ilce != null && !ilce.trim().isEmpty())
			result += ", ilce: " + ilce;
		if (koy != null && !koy.trim().isEmpty())
			result += ", koy: " + koy;
		if (mahalle != null && !mahalle.trim().isEmpty())
			result += ", mahalle: " + mahalle;
		if (belde != null && !belde.trim().isEmpty())
			result += ", belde: " + belde;
		if (neden != null && !neden.trim().isEmpty())
			result += ", neden: " + neden;
		if (enlem != null)
			result += ", enlem: " + enlem;
		if (boylam != null)
			result += ", boylam: " + boylam;
		if (nedenAciklama != null && !nedenAciklama.trim().isEmpty())
			result += ", nedenAciklama: " + nedenAciklama;
		if (etkiledigiAlanlar != null && !etkiledigiAlanlar.trim().isEmpty())
			result += ", etkiledigiAlanlar: " + etkiledigiAlanlar;
		if (kaynak != null && !kaynak.trim().isEmpty())
			result += ", kaynak: " + kaynak;
		return result;
	}

}