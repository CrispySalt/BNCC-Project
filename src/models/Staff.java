package models;

public class Staff {

	protected String id;
	protected String nama;
	protected String jenisKelamin;
	protected String jabatan;
	protected long gaji;
	protected int ranking;
	public Staff(String id, String nama, String jenisKelamin, String jabatan, long gaji,int ranking) {
		super();
		this.id = id;
		this.nama = nama;
		this.jenisKelamin = jenisKelamin;
		this.jabatan = jabatan;
		this.gaji = gaji;
		this.ranking=ranking;
	}
	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public long getGaji() {
		return gaji;
	}
	public void setGaji(long gaji) {
		this.gaji = gaji;
	}
	
	

}
