public class Programmer{
  private String[] companyPreference;

  public Programmer(String[] givenPreferences){
    companyPreference = givenPreferences;
  }

  public String toString(){
    return this.getName();
  }
}