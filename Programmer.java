public class Programmer{
  private Company[] companyPreference;
  private final String name;

  public Programmer(String name){
    this.name = name;
  }

  /*
  public String toString(){
    return this.getName();
  }
  */

  public void setCompanyPreference(Company[] preferences){
    this.companyPreference = preferences;
  }

  public Company[] getCompanyPreference() {
    return companyPreference;
  }

  public String getName(){
    return this.name;
  }

}