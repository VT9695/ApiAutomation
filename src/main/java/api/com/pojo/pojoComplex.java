package api.com.pojo;

import java.util.List;

public class pojoComplex {
	
	
	private String name;
	private List<String>jobs;
	private List<cityModel>cityModels;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getJobs() {
		return jobs;
	}
	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}
	public List<cityModel> getCityModels() {
		return cityModels;
	}
	public void setCityModels(List<cityModel> cityModels) {
		this.cityModels = cityModels;
	}
	
}
