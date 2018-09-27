public class Company{
  private String[] programmerPreferences;

  public Company(String[] givenPreferences){
    this.programmerPreferences = givenPreferences;
  }

  public String toString(){
    return this.getName();
  }
}